package com.project.bookmyshow.services;

import com.project.bookmyshow.models.Show;

import java.util.Optional;

public interface ShowService {
    Optional<Show> findById(int showId);
}
