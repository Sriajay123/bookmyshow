package com.project.bookmyshow.services;

import com.project.bookmyshow.models.Show;
import com.project.bookmyshow.models.ShowSeat;

import java.util.List;
import java.util.Optional;

public interface ShowSeatService {
    Optional<ShowSeat> findById(int showSeatId);

    List<ShowSeat> findShowSeatsByIdInAndSeatStatus_AvailableAndShow(List<Integer> showSeatIds, Show show);

}
