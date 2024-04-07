package com.project.bookmyshow.services;

import com.project.bookmyshow.models.Show;
import com.project.bookmyshow.repositories.ShowRepository;

import java.util.Optional;

public class ShowServiceImpl implements ShowService{

    private ShowRepository showRepository;

    @Override
    public Optional<Show> findById(int showId) {
        return showRepository.findById(showId);
    }
}
