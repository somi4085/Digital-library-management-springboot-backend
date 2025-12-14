package in.somi.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.somi.main.dto.CreateReservationRequestDTO;
import in.somi.main.dto.ReservationDTO;
import in.somi.main.entity.Reservation;
import in.somi.main.repository.ReservationRepository;
import in.somi.main.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	private ReservationRepository repository;
	
	@Override
	public ReservationDTO createReservation(CreateReservationRequestDTO dto) {
		Reservation reservation = new Reservation();
		reservation.setUserId(dto.getUserId());
		reservation.setBookId(dto.getBookId());
		reservation.setStatus(dto.getStatus());
		
		Reservation saved = repository.save(reservation);
		return mapToDo(saved);
	}

	@Override
	public List<ReservationDTO> getAllReservation() {
		return repository.findAll().stream().map(this::mapToDo).toList();
	}

	@Override
	public ReservationDTO getReservationById(Long id) {
		Reservation reservation = repository.findById(id).orElseThrow(() -> new RuntimeException("Reservatiomn not found"));
		return mapToDo(reservation);
	}

	@Override
	public ReservationDTO updateStatus(Long id, String status) {
		Reservation reservation = repository.findById(id).orElseThrow(() -> new RuntimeException("Reservation not found"));
		
		reservation.setStatus(status);
		
		Reservation updated = repository.save(reservation);
		return mapToDo(updated);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	
	private ReservationDTO mapToDo(Reservation reservation) {
		ReservationDTO dto = new ReservationDTO();
		dto.setBookId(reservation.getBookId());
		dto.setId(reservation.getId());
		dto.setUserId(reservation.getUserId());
		dto.setStatus(reservation.getStatus());
		return dto;
	}
}
