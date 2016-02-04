package eu.java.pg.jsonb.repository;

import eu.java.pg.jsonb.domain.CommonPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonPersonRepository extends JpaRepository<CommonPerson, Long> {
}
