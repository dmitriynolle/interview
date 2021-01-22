package ru.interviev.lesson7.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.interviev.lesson7.entites.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

}
