package ru.gb;

import ru.gb.dao.StudentDao;
import ru.gb.entities.Student;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        StudentDao studentDao=new StudentDao();

        create1000Student(studentDao);

        Student student=studentDao.findStudentById(888L);
        if (student!=null){
            System.out.println(student);
        }
        studentDao.deleteStudent(student);
        student=studentDao.findStudentById(888L);
        if (student!=null){
            System.out.println(student);
        }

        student=studentDao.findStudentById(777L);
        if (student!=null){
            System.out.println(student);
        }
        student.setName("Иванов Петр");
        student.setMark(10);
        studentDao.updateStudent(student);
        student=studentDao.findStudentById(777L);
        if (student!=null){
            System.out.println(student);
        }

        List<Student> list=studentDao.findAllStudent();
        list.forEach(System.out::println);

        studentDao.closeSession();
    }

    public static void create1000Student(StudentDao studentDao){
        Student student=new Student();
        Random random=new Random(System.currentTimeMillis());
        for (int i=1;i<=1000;i++){
            student.setName("Студент №"+i);
            student.setMark(random.nextInt(4)+2);
            studentDao.createNewStudent(student);
        }
    }
}