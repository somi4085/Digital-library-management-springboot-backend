package in.somi.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.somi.main.dto.CreateNotificationRequestDTO;
import in.somi.main.dto.NotificationDTO;
import in.somi.main.entity.Notification;
import in.somi.main.repository.NotificationRepository;
import in.somi.main.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {
	
	@Autowired
	private NotificationRepository repository;

	@Override
	public NotificationDTO createNotification(CreateNotificationRequestDTO dto) {
		Notification notification = new Notification();
		notification.setUserId(dto.getUserId());
		notification.setMessage(dto.getMessage());
		notification.setIsRead(false);
		
		Notification saved = repository.save(notification);
		return mapToDo(saved);
		
	}

	@Override
	public NotificationDTO getNotificationById(Long id) {
		Notification notification = repository.findById(id).orElseThrow(() -> new RuntimeException("Notification not found"));
		
		return mapToDo(notification);
	}

	@Override
	public List<NotificationDTO> getAllNotifications() {
		return repository.findAll().stream().map(this::mapToDo).toList();
	}

	@Override
	public NotificationDTO markAsRead(Long id) {
		Notification notification = repository.findById(id).orElseThrow(() -> new RuntimeException("Notification not found"));
		
		notification.setIsRead(true);
		Notification updated = repository.save(notification);
		return mapToDo(updated);
	}

	@Override
	public void deleteNotifications(Long id) {
		repository.deleteById(id);
	}
	
	private NotificationDTO mapToDo(Notification notification) {
		NotificationDTO dto = new NotificationDTO();
		dto.setId(notification.getId());
		dto.setUserId(notification.getUserId());
		dto.setMessage(notification.getMessage());
		dto.setIsRead(notification.getIsRead());
		return dto;
	}
}
