package com.project.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Show extends BaseModel {

    @ManyToOne
    private Screen screen;
    @ManyToOne
    private Movie movie;
    private Date startTime;
}
