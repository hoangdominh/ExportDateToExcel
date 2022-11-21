package com.example.springbootexportdatatoexcel.repository;

import com.example.springbootexportdatatoexcel.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
