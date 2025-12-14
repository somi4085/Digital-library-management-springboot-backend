package in.somi.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.somi.main.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	List<Reservation> findByUserId(Long userId);
	
}
