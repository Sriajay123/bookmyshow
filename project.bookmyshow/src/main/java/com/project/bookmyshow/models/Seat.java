package com.project.bookmyshow.models;


import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name="seats")
public class Seat {
    private String name;
    private SeatType seatType;
}
