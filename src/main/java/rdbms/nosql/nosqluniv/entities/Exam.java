package rdbms.nosql.nosqluniv.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.util.UUID;

@Data
@RedisHash("Exam")
public class Exam implements Serializable {
    @Id
    private UUID id;
    private String passtype;
    private Integer totalhours;
    private Integer semester;
    @Indexed
    private Subject subject;
    @Indexed
    private Teacher teacher;

    public Exam(UUID id, String passtype, Integer totalhours, Integer semester, Subject subject, Teacher teacher) {
        this.id = id;
        this.passtype = passtype;
        this.totalhours = totalhours;
        this.semester = semester;
        this.subject = subject;
        this.teacher = teacher;
    }
}
