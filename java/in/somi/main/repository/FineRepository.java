package in.somi.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.somi.main.entity.Fine;

public interface FineRepository extends JpaRepository<Fine, Long> {
	List<Fine> findByUserId(Long userId);
}
