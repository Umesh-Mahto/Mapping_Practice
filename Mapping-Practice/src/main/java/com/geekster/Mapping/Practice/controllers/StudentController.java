package com.geekster.Mapping.Practice.controllers;

import com.geekster.Mapping.Practice.models.Student;
import com.geekster.Mapping.Practice.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
    @GetMapping("/getStudent")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }
    @PutMapping("/updateStudent")
    public String updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }
    @DeleteMapping("deleteStudent/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        return studentService.deleteStudent(id);
    }
}
