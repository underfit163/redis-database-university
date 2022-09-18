package rdbms.nosql.nosqluniv.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@RedisHash("Student")
public class Student implements Serializable {
    @Id
    private UUID id;
    @Indexed
    private String fio;
    private LocalDate birthday;
    private String gender;
    private String phone;

    public Student(UUID id, String fio, LocalDate birthday, String gender, String phone) {
        this.id = id;
        this.fio = fio;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
    }
}
