package in.somi.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.somi.main.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
