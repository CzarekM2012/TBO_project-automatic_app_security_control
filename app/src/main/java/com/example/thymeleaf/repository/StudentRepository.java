package com.example.thymeleaf.repository;

import com.example.thymeleaf.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
@RequiredArgsConstructor
public class StudentRepository {

    private final JdbcTemplate jdbcTemplate;
    private final SafeStudentRepository safeStudentRepository;

    public Student save(Student student) {
        String query = "INSERT INTO student (id, name, birthday, created_at) VALUES ('" +
                UUID.randomUUID().toString() + "','" +
                student.getName() + "','" +
                student.getBirthday().toString() + "','" +
                LocalDateTime.now() + "')";

        jdbcTemplate.execute(query);
        return student;
//        return safeStudentRepository.save(student);
    }

    public void delete(Student student) {
        safeStudentRepository.delete(student);
    }

    public Optional<Student> findById(String id) {
        return safeStudentRepository.findById(id);
    }

    public List<Student> findAll() {
        return safeStudentRepository.findAll();
    }
}
