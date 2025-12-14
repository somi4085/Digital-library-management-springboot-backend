package in.somi.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.somi.main.dto.CreateReservationRequestDTO;
import in.somi.main.dto.ReservationDTO;
import in.somi.main.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired
	private ReservationService service;
	
	@PostMapping
	public ReservationDTO createReservation(@RequestBody CreateReservationRequestDTO dto) {
		return service.createReservation(dto);
	}
	
	@GetMapping("/{id}")
	public ReservationDTO getById(@PathVariable Long id) {
		return service.getReservationById(id);
	}
	
	@GetMapping
	public List<ReservationDTO> getAllreservation(){
		return service.getAllReservation();
	}
	
	@PutMapping("/{id}")
	public ReservationDTO updaestatus( @PathVariable Long id, String status) {
		return service.updateStatus(id, status);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		 service.deleteById(id);
	}
}
