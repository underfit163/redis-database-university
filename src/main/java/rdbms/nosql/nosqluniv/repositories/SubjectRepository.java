package rdbms.nosql.nosqluniv.repositories;

import org.springframework.data.repository.CrudRepository;
import rdbms.nosql.nosqluniv.entities.Subject;

import java.util.UUID;

public interface SubjectRepository extends CrudRepository<Subject, UUID> {
}
