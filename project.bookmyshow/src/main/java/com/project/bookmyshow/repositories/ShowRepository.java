package com.project.bookmyshow.repositories;

import com.project.bookmyshow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show,Integer> {
    Optional<Show> findById(int showId);
}
