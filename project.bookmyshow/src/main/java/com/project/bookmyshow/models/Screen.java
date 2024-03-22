package com.project.bookmyshow.models;

import com.fasterxml.jackson.databind.ser.Serializers;

import java.util.List;

public class Screen extends BaseModel {
    private String name;

    private List<Seat> seats;
}
