package com.project.bookmyshow.controllers;


import com.project.bookmyshow.dtos.BookTicketRequestDto;
import com.project.bookmyshow.dtos.BookTicketResponseDto;
import com.project.bookmyshow.dtos.Response;
import com.project.bookmyshow.exceptions.InvalidBookTicketRequestException;
import com.project.bookmyshow.models.Ticket;
import com.project.bookmyshow.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @RequestMapping(path = "/bookTicket")
    public BookTicketResponseDto bookTicket(BookTicketRequestDto requestDto){
        BookTicketResponseDto responseDto = new BookTicketResponseDto();
        try{
            validateBookTicketRequest(requestDto);
            Ticket ticket = ticketService.bookTicket(requestDto.getUserId(), requestDto.getShowId(), requestDto.getShowSeatIds());
            Response response = Response.getSuccessResponse();
            responseDto.setResponse(response);
            responseDto.setTicket(ticket);
        }catch (Exception e){
            Response response = Response.getFailureResponse(e.getMessage());
            responseDto.setResponse(response);
        }
        return responseDto;
    }

    private static void validateBookTicketRequest(BookTicketRequestDto requestDto) throws InvalidBookTicketRequestException {
        if(requestDto.getShowId() <= 0){
            throw new InvalidBookTicketRequestException("Show id cannot be negative or zero");
        }
        if(requestDto.getUserId() <= 0){
            throw new InvalidBookTicketRequestException("User id cannot be negative or zero");
        }
        if(requestDto.getShowSeatIds() == null || requestDto.getShowSeatIds().isEmpty()){
            throw new InvalidBookTicketRequestException("Seat ids should be present");
        }
    }
}
