package homeWork5;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDao {

    public Student findById(int id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Student.class, id);
    }

    public List<Student> findAll() {
        List<Student> users = (List<Student>)  HibernateSessionFactory.getSessionFactory().openSession().createQuery("From Student ").list();
        return users;
    }

    public void save(Student student) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(student);
        tx1.commit();
        session.close();
    }

    public void update(Student student) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(student);
        tx1.commit();
        session.close();
    }

    public void delete(Student student) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(student);
        tx1.commit();
        session.close();
    }
}
