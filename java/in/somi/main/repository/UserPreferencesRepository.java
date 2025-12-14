package in.somi.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.somi.main.entity.UserPreference;


public interface UserPreferencesRepository extends JpaRepository<UserPreference, Long> {

	Optional<UserPreference>  findByUserId(Long userId);
}
