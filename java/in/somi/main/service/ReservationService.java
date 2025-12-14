package in.somi.main.service;

import java.util.List;

import in.somi.main.dto.CreateReservationRequestDTO;
import in.somi.main.dto.ReservationDTO;


public interface ReservationService {
	
	ReservationDTO createReservation(CreateReservationRequestDTO dto);
	
	List<ReservationDTO> getAllReservation();
	
	ReservationDTO getReservationById(Long id);
	
	ReservationDTO updateStatus(Long id, String status);
	
	void deleteById(Long id);
}
