package com.example.ioc.Service;

import com.example.ioc.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {
    List<Student> list=new ArrayList<>(
            Arrays.asList(new Student(1,"ram","spring"),new Student(2, "ravi", "javascript")));
    public List<Student> getAllStudents() {
        return list;
    }

    public Student getStudentByRollNo(int rollno) {
        int in=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getRno()==rollno){
                in=i;
            }
        }
        return list.get(in);
    }

    public void addStudent(Student std) {
        list.add(std);
    }

    public String updateStudent(Student std) {
        int in=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getRno()== std.getRno()){
                in=i;
            }
        }
        list.set(in,std);
        return "updated";
    }

    public String deleteStudentByRollNo(int rollno) {
        int in=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getRno()==rollno){
                in=i;
            }
        }
        list.remove(in);
        return "deleted";
    }
}
