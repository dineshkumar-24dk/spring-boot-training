package com.example.ioc.Controller;

import com.example.ioc.Model.Student;
import com.example.ioc.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService s;
    @GetMapping("students")
    public List<Student> getAllStudent(){
        return s.getAllStudents();
    }

    @GetMapping("students/{rno}")
    public Student getStudentByRollNO(@PathVariable("rno") int rollno){
        return s.getStudentByRollNo(rollno);
    }

    @PostMapping("students")
    public String addStudent(@RequestBody Student std){
        s.addStudent(std);
        return "added";
    }

    @PutMapping("students")
    public String UpdateStudent(@RequestBody Student std){
        return s.updateStudent(std);
    }

    @DeleteMapping("students/{rno}")
    public String deleteById(@PathVariable("rno") int rollno){
        return s.deleteStudentByRollNo(rollno);
    }
}
