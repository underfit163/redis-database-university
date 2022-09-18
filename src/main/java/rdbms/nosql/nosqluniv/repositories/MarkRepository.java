package rdbms.nosql.nosqluniv.repositories;

import org.springframework.data.repository.CrudRepository;
import rdbms.nosql.nosqluniv.entities.Mark;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MarkRepository extends CrudRepository<Mark, UUID> {
    Optional<List<Mark>> searchMarksByExam_SubjectSubjectname(String sub);
    List<Mark> findAllMarkByStudentFio(String fio);
}
