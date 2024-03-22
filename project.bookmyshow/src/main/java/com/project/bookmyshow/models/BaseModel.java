package com.project.bookmyshow.models;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;




@Data
@MappedSuperclass
public abstract class BaseModel {

    private  int id;

    private Date createdAt;
    private Date updatedAt;

}
