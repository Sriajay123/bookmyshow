package com.project.bookmyshow.repositories;

import com.project.bookmyshow.models.Show;
import com.project.bookmyshow.models.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.List;
import java.util.Optional;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {

    Optional<ShowSeat> findById(int showSeatId);

//    @Query(value = "select * from show_seats")

    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    List<ShowSeat> findShowSeatsByIdInAndSeatStatus_AvailableAndShow(List<Integer> showSeatIds, Show show);
}
