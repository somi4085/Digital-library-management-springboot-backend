package in.somi.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.somi.main.dto.CreateFineRequestDTO;
import in.somi.main.dto.FineDTO;
import in.somi.main.entity.Fine;
import in.somi.main.repository.FineRepository;
import in.somi.main.service.FineService;

@Service
public class FineServiceImpl implements FineService {
	
	@Autowired
	private FineRepository repository;

	@Override
	public FineDTO createFine(CreateFineRequestDTO dto) {
		Fine fine = new Fine();
		fine.setUserId(dto.getUserId());
		fine.setAmount(dto.getAmount());
		fine.setReason(dto.getReason());
		fine.setStatus(dto.getStatus());
		
		Fine saved = repository.save(fine);
		return mapToDO(saved);
	}

	@Override
	public FineDTO getFineById(Long id) {
		Fine fine = repository.findById(id).orElseThrow(() ->  new RuntimeException("Fine not found"));
		return mapToDO(fine);
	}

	@Override
	public List<FineDTO> getAllFine() {
		return repository.findAll().stream().map(this::mapToDO).toList();
	}

	@Override
	public FineDTO updatedFine(Long id, CreateFineRequestDTO dto) {
		Fine fine = repository.findById(id).orElseThrow(() -> new RuntimeException("Fine not found"));
		
		fine.setAmount(dto.getAmount());
		fine.setReason(dto.getReason());
		
		Fine updated = repository.save(fine);
		return mapToDO(updated);
	}

	@Override
	public void deleteFine(Long id) {
		repository.deleteById(id);
	}
	
	private FineDTO mapToDO(Fine fine) {
		FineDTO dto = new FineDTO();
		dto.setId(fine.getId());
		dto.setUserId(fine.getUserId());
		dto.setAmount(dto.getAmount());
		dto.setReason(fine.getReason());
		dto.setStatus(fine.getStatus());
		return dto;
	}
}
