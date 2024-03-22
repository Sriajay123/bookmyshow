package com.project.bookmyshow.models;


import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Seat {
    private String name;
    private SeatType seatType;
}
