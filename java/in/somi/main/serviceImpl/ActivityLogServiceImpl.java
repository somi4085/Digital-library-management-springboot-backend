package in.somi.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.somi.main.dto.ActivityLogDTO;
import in.somi.main.entity.ActivityLog;
import in.somi.main.repository.ActivityLogRepository;
import in.somi.main.service.ActivityLogService;

@Service
public class ActivityLogServiceImpl  implements ActivityLogService{
	
	@Autowired
	private ActivityLogRepository repository;

	@Override
	public ActivityLogDTO createActivityLog(Long userId, String action, String details) {
		ActivityLog activityLog = new ActivityLog();
		activityLog.setDetails(details);
		activityLog.setUserId(userId);
		activityLog.setAction(action);
		
		ActivityLog saved = repository.save(activityLog);
		return mapToDo(saved);
		
	}

	@Override
	public ActivityLogDTO getActivityLogById(Long id) {
		ActivityLog activityLog = repository.findById(id).orElseThrow(() -> new RuntimeException("Activity log not found"));
		
		return mapToDo(activityLog);
	}

	@Override
	public List<ActivityLogDTO> getAllActivityLogs() {
		return repository.findAll().stream().map(this::mapToDo).toList();
	}

	@Override
	public void deleteActivityLog(Long id) {
		repository.deleteById(id);
	}
	
	private ActivityLogDTO mapToDo(ActivityLog activityLog) {
		ActivityLogDTO dto = new ActivityLogDTO();
		dto.setUserId(activityLog.getUserId());
		dto.setAction(activityLog.getAction());
		return dto;
	}
}
