package dao;

import model.Reservation;
import java.util.List;

public interface ReservationDao {
    void create(Reservation reservation);
    Reservation findById(Long id);
    List<Reservation> findAll();
    void update(Reservation reservation);
    void delete(Reservation reservation);
} 