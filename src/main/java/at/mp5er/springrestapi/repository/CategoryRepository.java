package at.mp5er.springrestapi.repository;

import at.mp5er.springrestapi.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}