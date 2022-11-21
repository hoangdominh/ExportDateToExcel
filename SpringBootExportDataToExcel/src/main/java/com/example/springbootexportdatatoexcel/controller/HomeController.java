package com.example.springbootexportdatatoexcel.controller;

import com.example.springbootexportdatatoexcel.excel.UserExcelExporter;
import com.example.springbootexportdatatoexcel.model.Student;
import com.example.springbootexportdatatoexcel.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/web")
public class HomeController {
    @GetMapping("/home")
    public String homePage() {
        return "HomePage";
    }

    @Autowired
    private StudentRepository studentRepository;


    @GetMapping("/export/excel")
    public void exportExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Student_info.xlsx";

        response.setHeader(headerKey, headerValue);
        List<Student> listStudent = studentRepository.findAll();
        UserExcelExporter exp = new UserExcelExporter(listStudent);
        exp.export(response);

    }
}
