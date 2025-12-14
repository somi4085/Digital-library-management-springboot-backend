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

import in.somi.main.dto.CreateFineRequestDTO;
import in.somi.main.dto.FineDTO;
import in.somi.main.service.FineService;

@RestController
@RequestMapping("/fine")
public class FineController {
	
	@Autowired
	private FineService fineService;
	
	@PostMapping
	public FineDTO createFine(CreateFineRequestDTO dto) {
		return fineService.createFine(dto);
	}
	
	@GetMapping("/{id}")
	public FineDTO getFineById(@PathVariable Long id) {
		return fineService.getFineById(id);
	}
	
	@GetMapping
	public List<FineDTO> getAllFine(){
		return fineService.getAllFine();
	}
	
	@PutMapping("/{id}")
	public FineDTO updateFine(@RequestBody CreateFineRequestDTO dto,@PathVariable Long id) {
		return fineService.updatedFine(id, dto);
	}
	
	@DeleteMapping("/{id}")
	public void deleteFineById(@PathVariable Long id) {
		 fineService.deleteFine(id);
	}
}
