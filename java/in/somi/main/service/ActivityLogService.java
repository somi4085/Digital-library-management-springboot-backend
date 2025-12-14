package in.somi.main.service;

import java.util.List;

import in.somi.main.dto.ActivityLogDTO;

public interface ActivityLogService {
	
	ActivityLogDTO createActivityLog(Long userId, String action, String details);
	
	ActivityLogDTO getActivityLogById(Long id);
	
	List<ActivityLogDTO> getAllActivityLogs();
	
	void deleteActivityLog(Long id);
}
