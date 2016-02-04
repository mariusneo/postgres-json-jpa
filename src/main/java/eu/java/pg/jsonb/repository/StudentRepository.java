package eu.java.pg.jsonb.repository;

import eu.java.pg.jsonb.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
