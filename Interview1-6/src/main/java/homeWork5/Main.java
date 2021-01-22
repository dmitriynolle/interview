package homeWork5;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hibernate tutorial");
        StudentDao dao = new StudentDao();
        Student student = new Student();
        for (int i = 0; i < 1000; i++) {
            student.setName("Nick " + (int) Math.floor(Math.random() * Math.floor(100)));
            student.setMark((int) Math.floor(Math.random() * Math.floor(5) + 1));
            dao.save(student);
        }
        student.setId(20);
        student.setName("Mike");
        student.setMark(10);
        dao.update(student);
        System.out.println(dao.findById(20).toString());
        dao.delete(student);
        List<Student> studentList = dao.findAll();

    }
}
