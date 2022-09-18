package rdbms.nosql.nosqluniv.repositories;

import org.springframework.data.repository.CrudRepository;
import rdbms.nosql.nosqluniv.entities.Student;

import java.util.UUID;

public interface StudentRepository extends CrudRepository<Student, UUID> {
}
