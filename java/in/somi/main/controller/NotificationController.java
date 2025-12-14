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

import in.somi.main.dto.CreateNotificationRequestDTO;
import in.somi.main.dto.NotificationDTO;
import in.somi.main.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
	
	@Autowired
	private NotificationService service;
	
	@PostMapping
	public NotificationDTO createNotification(@RequestBody CreateNotificationRequestDTO dto) {
		return service.createNotification(dto);
	}
	
	@GetMapping
	public List<NotificationDTO> getAllnotifications() {
		return service.getAllNotifications();
	}
	
	@GetMapping("/{id}")
	public NotificationDTO getById(@PathVariable Long id) {
		return service.getNotificationById(id);
	}
	
	@PutMapping("/{id}")
	public NotificationDTO marksAsRead(@PathVariable Long id) {
		return service.markAsRead(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		 service.deleteNotifications(id);
	}
}

