package in.somi.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.somi.main.dto.ActivityLogDTO;
import in.somi.main.service.ActivityLogService;

@RestController
@RequestMapping
public class ActivityLogController {
	
	@Autowired
	private ActivityLogService service;
	
	@PostMapping
	public ActivityLogDTO activityLogCreate(@PathVariable Long userId, String action, String details) {
		return service.createActivityLog(userId, action, details);
	}
	
	@GetMapping("/{id}")
	public ActivityLogDTO getActivityLogById(@PathVariable Long id) {
		return service.getActivityLogById(id);
	}
	
	@GetMapping
	public List<ActivityLogDTO> getAllActivity() {
		return service.getAllActivityLogs();
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		 service.deleteActivityLog(id);
	}
}
