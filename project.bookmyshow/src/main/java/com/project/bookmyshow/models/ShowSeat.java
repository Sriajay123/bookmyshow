package com.project.bookmyshow.models;

public class ShowSeat extends BaseModel{
    private Show show;

    private Seat seat;
    private SeatStatus seatStatus;

    private User bookedBy;
}
