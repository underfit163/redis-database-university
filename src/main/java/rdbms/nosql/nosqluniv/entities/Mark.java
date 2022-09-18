package rdbms.nosql.nosqluniv.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@RedisHash("Mark")
public class Mark implements Serializable {
    @Id
    private UUID id;
    private String evaluation;
    private LocalDate passdate;
    @Indexed
    private Student student;
    @Indexed
    private Exam exam;

    public Mark(UUID id, String evaluation, LocalDate passdate, Student student, Exam exam) {
        this.id = id;
        this.evaluation = evaluation;
        this.passdate = passdate;
        this.student = student;
        this.exam = exam;
    }
}
