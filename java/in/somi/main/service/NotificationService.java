package in.somi.main.service;

import java.util.List;

import in.somi.main.dto.CreateNotificationRequestDTO;
import in.somi.main.dto.NotificationDTO;

public interface NotificationService {
	
	NotificationDTO createNotification(CreateNotificationRequestDTO dto);
	
	NotificationDTO getNotificationById(Long id);
	
	List<NotificationDTO>  getAllNotifications();
	
	NotificationDTO markAsRead(Long id);
	
	void deleteNotifications(Long id);
}
