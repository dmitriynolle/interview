package ru.interviev.lesson7.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.interviev.lesson7.entites.Student;
import ru.interviev.lesson7.services.StudentService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping()
public class StudentController {
    private StudentService studentService;
    List<Student> students = new ArrayList<>();

    @Autowired
    public void getStudentService(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public String allStudent(Model model){
        model.addAttribute("students", studentService.getAllStudent());
        return "Student";
    }

    @GetMapping("/save")
    public String saveStudent(){
        Student student = new Student();
        student.setName("Dima");
        student.setAge(42);
        studentService.saveStudent(student);
        return "redirect:student";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return "redirect:http://localhost:8080/student";
    }
}
