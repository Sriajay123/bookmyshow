package com.project.bookmyshow.models;

import java.util.List;

public class Ticket extends BaseModel{
    private Movie movie;

    private Show show;

    private List<ShowSeat> showSeats;

    private User user;
}
