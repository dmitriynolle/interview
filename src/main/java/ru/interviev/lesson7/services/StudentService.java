package ru.interviev.lesson7.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.interviev.lesson7.entites.Student;
import ru.interviev.lesson7.repositories.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudent(){
        return (List<Student>) studentRepository.findAll();
    }

    public void saveStudent(Student student){
        studentRepository.save(student);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
