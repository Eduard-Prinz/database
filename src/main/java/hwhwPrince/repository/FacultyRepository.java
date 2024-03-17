package hwhwPrince.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hwhwPrince.entities.Faculty;

import java.util.List;


public interface FacultyRepository extends JpaRepository<Faculty, Long>  {
    List<Faculty> findByColor(String color);
    List<Faculty> findByNameIgnoreCaseOrColorIgnoreCase(String name, String color);
}