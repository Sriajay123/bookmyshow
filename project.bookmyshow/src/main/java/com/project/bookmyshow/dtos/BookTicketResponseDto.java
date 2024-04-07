package com.project.bookmyshow.dtos;

import com.project.bookmyshow.models.Ticket;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class BookTicketResponseDto {
    private Response response;
    private Ticket ticket;
}
