package in.somi.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.somi.main.entity.ActivityLog;

public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long>{

}
