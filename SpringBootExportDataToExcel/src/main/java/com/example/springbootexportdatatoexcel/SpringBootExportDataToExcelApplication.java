package com.example.springbootexportdatatoexcel;

import com.example.springbootexportdatatoexcel.model.Student;
import com.example.springbootexportdatatoexcel.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootExportDataToExcelApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExportDataToExcelApplication.class, args);
    }

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        Student student1 = new Student(1L,"Minh Hoang","Mai Son","Son La","30799");
        Student student2 = new Student(2L,"Van Ninh","Na Bo","Son La","40199");
        Student student3 = new Student(3L,"Duc Minh","Na San","Son La","10599");

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
    }
}
