package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StudentController {
    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("students", repository.findAll());
        model.addAttribute("studentCount", repository.count());
        return "students";
    }

    @GetMapping("/students/new")
    public String newStudent(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("pageTitle", "Add Student");
        return "student-form";
    }

    @PostMapping("/students")
    public String create(@Valid @ModelAttribute Student student,
                         BindingResult result, Model model,
                         RedirectAttributes redirect) {
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Add Student");
            return "student-form";
        }
        try {
            repository.save(student);
            redirect.addFlashAttribute("success", "Student added successfully.");
        } catch (DataIntegrityViolationException ex) {
            model.addAttribute("pageTitle", "Add Student");
            model.addAttribute("emailError", "This email address is already registered.");
            return "student-form";
        }
        return "redirect:/";
    }

    @GetMapping("/students/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID: " + id));
        model.addAttribute("student", student);
        model.addAttribute("pageTitle", "Edit Student");
        return "student-form";
    }

    @PostMapping("/students/update/{id}")
    public String update(@PathVariable Long id, @Valid @ModelAttribute Student student,
                         BindingResult result, Model model, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Edit Student");
            return "student-form";
        }
        student.setId(id);
        try {
            repository.save(student);
            redirect.addFlashAttribute("success", "Student updated successfully.");
        } catch (DataIntegrityViolationException ex) {
            model.addAttribute("pageTitle", "Edit Student");
            model.addAttribute("emailError", "This email address is already registered.");
            return "student-form";
        }
        return "redirect:/";
    }

    @PostMapping("/students/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        repository.deleteById(id);
        redirect.addFlashAttribute("success", "Student deleted successfully.");
        return "redirect:/";
    }
}
