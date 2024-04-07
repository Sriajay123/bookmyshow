package com.project.bookmyshow.services;

import com.project.bookmyshow.models.Ticket;

import java.util.List;

public interface TicketService {
    Ticket bookTicket(int userId, int showId, List<Integer> showSeatIds) throws Exception;
}
