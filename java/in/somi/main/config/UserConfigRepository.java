package in.somi.main.config;

import org.springframework.data.jpa.repository.JpaRepository;

import in.somi.main.entity.User;

public interface UserConfigRepository extends JpaRepository<User, Long>{
	
}
