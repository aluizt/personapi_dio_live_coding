package one.digitalinnovation.personapi.repository;

import one.digitalinnovation.personapi.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity,Long> {
}
