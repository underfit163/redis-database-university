package rdbms.nosql.nosqluniv.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@RedisHash("Teacher")
public class Teacher implements Serializable {
    @Id
    private UUID id;
    @Indexed
    private String fio;
    private LocalDate birthday;
    private String gender;
    private String title;
    private String teacherdegree;
    private String phone;

    public Teacher(UUID id, String fio, LocalDate birthday, String gender, String title, String teacherdegree, String phone) {
        this.id = id;
        this.fio = fio;
        this.birthday = birthday;
        this.gender = gender;
        this.title = title;
        this.teacherdegree = teacherdegree;
        this.phone = phone;
    }
}
