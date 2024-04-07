package com.project.bookmyshow.services;

import com.project.bookmyshow.exceptions.InvalidBookTicketRequestException;
import com.project.bookmyshow.exceptions.SeatsUnavailableException;
import com.project.bookmyshow.models.Show;
import com.project.bookmyshow.models.ShowSeat;
import com.project.bookmyshow.models.Ticket;
import com.project.bookmyshow.models.User;
import com.project.bookmyshow.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class TicketServiceImpl implements TicketService{


    private UserService userService;

    private ShowService showService;

    private ShowSeatService showSeatService;

    private TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(UserService userService, ShowService showService, ShowSeatService showSeatService, TicketRepository ticketRepository) {
        this.userService = userService;
        this.showService = showService;
        this.showSeatService = showSeatService;
        this.ticketRepository = ticketRepository;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(int userId, int showId, List<Integer> showSeatIds) throws Exception {


        /*
        1. Check if the user is valid
        2. Showid in showSeatIds and given showId should match
        3. Start transaction (SERIALIZABLE)
        4. select * from show_seats where id in (showSeatIds) and seat_status = 'Available' and show_id = {{showId}} for update
        5. if all seats are not available
        6. throw error and rollback the transaction
        7. Update show_seats set seat_status = 'BLOCKED' where ids in (showSeatIds)
        8. Generate ticket object
        9. Store ticket object in DB and return
         */
            Optional<User> userOptional = this.userService.findById(userId);
            User user;
            if(userOptional.isPresent()){
                user = userOptional.get();
            } else {
                throw new InvalidBookTicketRequestException("User is invalid");
            }

            Show show = this.showService.findById(showId).orElseThrow(() -> new InvalidBookTicketRequestException("Show id is invalid"));
            ShowSeat showSeat = this.showSeatService.findById(showSeatIds.get(0)).orElseThrow(() -> new InvalidBookTicketRequestException("Seat id is invalid"));
            if(showSeat.getShow().getId() != showId){
                throw new InvalidBookTicketRequestException("Given seats dont belong to the same show");
            }

            List<ShowSeat> showSeats = this.showSeatService.findShowSeatsByIdInAndSeatStatus_AvailableAndShow(showSeatIds, show);

            if(showSeats.size() != showSeatIds.size()){
                throw new SeatsUnavailableException("Some of the seats you are trying to book are unavailable");
            }

            for(ShowSeat ss: showSeats){
                ss.setBookedBy(user);
                ss.setSeatStatus(SeatStatus.BLOCKED);
            }
        showSeatService.saveAll(showSeats);

            Ticket ticket = new Ticket();
            ticket.setMovie(show.getMovie());
            ticket.setShow(show);
            ticket.setShowSeats(showSeats);
            ticket.setUser(user);

            return ticketRepository.save(ticket);
        }
    }
}
