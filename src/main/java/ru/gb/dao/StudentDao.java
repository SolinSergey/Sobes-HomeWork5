package ru.gb.dao;

import org.hibernate.Session;
import ru.gb.config.DBFactory;
import ru.gb.entities.Student;

import java.util.List;
public class StudentDao {
    Session currentSession=DBFactory.getSessionFactory().openSession();
    public void createNewStudent(Student student) {
        try {
            Session session = currentSession.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student){
        try {
            Session session = currentSession.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.update(student);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(Student student){
        try {
            Session session = currentSession.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.delete(student);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Student findStudentById(Long id){
        Student student = null;
        try {
            Session session = currentSession.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            student=session.get(Student.class,id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    public List<Student> findAllStudent(){
        List<Student> list;
        try (Session session = currentSession.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            list = session.createQuery("from Student").getResultList();
            session.getTransaction().commit();
        }
        return list;
    }
    public void closeSession(){
        currentSession.close();
    }
}
