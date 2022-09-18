package rdbms.nosql.nosqluniv;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import rdbms.nosql.nosqluniv.entities.*;
import rdbms.nosql.nosqluniv.repositories.*;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableRedisRepositories
public class NoSqlRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoSqlRedisApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ExamRepository examRepository,
                                        MarkRepository markRepository,
                                        StudentRepository studentRepository,
                                        SubjectRepository subjectRepository,
                                        TeacherRepository teacherRepository) {
        return args -> {
            examRepository.deleteAll();
            markRepository.deleteAll();
            studentRepository.deleteAll();
            subjectRepository.deleteAll();
            teacherRepository.deleteAll();


            Student student1 = new Student(
                    UUID.randomUUID(), "Андрей", LocalDate.of(1999, 3, 20), "м", "4354543");
            Student student2 = new Student(
                    UUID.randomUUID(), "Алексей", LocalDate.of(1998, 12, 31), "м", "784654");
            studentRepository.save(student1);
            studentRepository.save(student2);

            Subject subject1 = new Subject(UUID.randomUUID(), "noSql");
            Subject subject2 = new Subject(UUID.randomUUID(), "Java");
            subjectRepository.save(subject1);
            subjectRepository.save(subject2);

            Teacher teacher1 = new Teacher(
                    UUID.randomUUID(), "Анфиса", LocalDate.of(1989, 3, 20), "ж", "доцент",
                    "кандидат наук", "4354543");
            Teacher teacher2 = new Teacher(
                    UUID.randomUUID(),"Алексей", LocalDate.of(1978, 3, 20), "м", "доцент",
                    "кандидат наук", "111111");
            teacherRepository.save(teacher1);
            teacherRepository.save(teacher2);

            Exam exam1 = new Exam(UUID.randomUUID(), "экзамен", 54, 1, subject1, teacher1);
            Exam exam2 = new Exam(UUID.randomUUID(), "экзамен", 54, 2, subject2, teacher2);
            examRepository.save(exam1);
            examRepository.save(exam2);

            Mark mark1 = new Mark(UUID.randomUUID(), "5", LocalDate.of(2019, 1, 14), student1, exam1);
            Mark mark2 = new Mark(UUID.randomUUID(), "4", LocalDate.of(2019, 1, 14), student1, exam2);
            Mark mark3 = new Mark(UUID.randomUUID(), "3", LocalDate.of(2019, 1, 14), student2, exam1);
            Mark mark4 = new Mark(UUID.randomUUID(), "3", LocalDate.of(2019, 1, 14), student2, exam2);

            markRepository.save(mark1);
            markRepository.save(mark2);
            markRepository.save(mark3);
            markRepository.save(mark4);

            studentRepository.findAll().forEach(System.out::println);

            examRepository.searchExamsBySubjectSubjectname(subject2.getSubjectname()).ifPresent(System.out::println);
            markRepository.searchMarksByExam_SubjectSubjectname(subject1.getSubjectname()).ifPresent(System.out::println);
            markRepository.findAllMarkByStudentFio("Андрей").forEach(x-> System.out.println("Оценка: " + x.getEvaluation()));
        };
    }
}

