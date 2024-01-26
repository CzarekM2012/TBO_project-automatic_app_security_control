package com.example.thymeleaf.repository;

import com.example.thymeleaf.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SafeStudentRepository extends JpaRepository<Student, String> {

}
