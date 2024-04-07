package com.project.bookmyshow.services;

import com.project.bookmyshow.models.Show;
import com.project.bookmyshow.models.ShowSeat;
import com.project.bookmyshow.repositories.ShowSeatRepository;

import java.util.List;
import java.util.Optional;

public class ShowSeatServiceImpl implements ShowSeatService{

    private ShowSeatRepository showSeatRepository;
    @Override
    public Optional<ShowSeat> findById(int showSeatId) {
        return showSeatRepository.findById(showSeatId);
    }

    @Override
    public List<ShowSeat> findShowSeatsByIdInAndSeatStatus_AvailableAndShow(List<Integer> showSeatIds, Show show) {
        return showSeatRepository.findShowSeatsByIdInAndSeatStatus_AvailableAndShow(showSeatIds,show);
    }
}
