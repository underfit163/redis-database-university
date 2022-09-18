package rdbms.nosql.nosqluniv.repositories;


import org.springframework.data.repository.CrudRepository;
import rdbms.nosql.nosqluniv.entities.Exam;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExamRepository extends CrudRepository<Exam, UUID> {
    Optional<List<Exam>> searchExamsBySubjectSubjectname(String subject);
}
