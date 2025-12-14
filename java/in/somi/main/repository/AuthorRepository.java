package in.somi.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.somi.main.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}
