package rdbms.nosql.nosqluniv.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.util.UUID;

@Data
@RedisHash("Subject")
public class Subject implements Serializable {
    @Id
    private UUID id;
    @Indexed
    private String subjectname;

    public Subject(UUID id, String subjectname) {
        this.id = id;
        this.subjectname = subjectname;
    }
}
