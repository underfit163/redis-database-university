package rdbms.nosql.nosqluniv.repositories;



import org.springframework.data.keyvalue.repository.KeyValueRepository;
import rdbms.nosql.nosqluniv.entities.Teacher;

import java.util.UUID;

public interface TeacherRepository extends KeyValueRepository<Teacher, UUID> {
}
