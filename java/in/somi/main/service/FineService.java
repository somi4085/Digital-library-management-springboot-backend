package in.somi.main.service;

import java.util.List;

import in.somi.main.dto.CreateFineRequestDTO;
import in.somi.main.dto.FineDTO;

public interface FineService {
	
	FineDTO createFine(CreateFineRequestDTO dto);
	
	FineDTO getFineById(Long id);
	
	List<FineDTO> getAllFine();
	
	FineDTO updatedFine(Long id, CreateFineRequestDTO dto);
	
	void deleteFine(Long id);
}
