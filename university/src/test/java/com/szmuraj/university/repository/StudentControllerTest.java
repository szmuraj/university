package com.szmuraj.university.repository;


import com.szmuraj.university.domain.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class StudentControllerTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void testGetStudentById() {
        //Given
        Student student1 = new Student();
        student1.setStudentName("testName");
        student1.setTerm(6);

        List<Student> students = new ArrayList<>();
        students.add(student1);

        studentRepository.save(students);

        //When & Then
        Assertions.assertEquals(studentRepository.getByName("testName").get(0).idStudent, studentRepository.getById(studentRepository.getByName("testName").get(0).idStudent).idStudent);

        //Clean
        studentRepository.delete(studentRepository.getByName("testName").get(0).idStudent);
    }

    @Test
    void testGetStudentByName() {
        //Given
        Student student1 = new Student();
        student1.setStudentName("testName");
        student1.setTerm(100);

        List<Student> students = new ArrayList<>();
        students.add(student1);

        studentRepository.save(students);

        //When & Then
        Assertions.assertEquals("testName", studentRepository.getByName("testName").get(0).studentName);

        //Clean
        studentRepository.delete(studentRepository.getByName("testName").get(0).idStudent);
    }

    @Test
    void testGetStudentByTerm() {
        //Given
        Student student1 = new Student();
        student1.setStudentName("testName");
        student1.setTerm(100);

        List<Student> students = new ArrayList<>();
        students.add(student1);

        studentRepository.save(students);

        //When & Then
        Assertions.assertEquals(100, studentRepository.getByTerm(100).get(0).term);

        //Clean
        studentRepository.delete(studentRepository.getByName("testName").get(0).idStudent);
    }
    @Test
    void testPostStudent() {
        //Given
        Student student1 = new Student();
        student1.setStudentName("testName");
        student1.setTerm(100);

        List<Student> students = new ArrayList<>();
        students.add(student1);

        studentRepository.save(students);

        //When & Then
        Assertions.assertEquals("testName", studentRepository.getByName("testName").get(0).studentName);

        //Clean
        studentRepository.delete(studentRepository.getByName("testName").get(0).idStudent);
    }

    @Test
    void testPutStudent() {
        //Given
        Student student1 = new Student();
        student1.setStudentName("testName");
        student1.setTerm(100);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        studentRepository.save(students);

        int idStudent1 = studentRepository.getByName("testName").get(0).idStudent;

        //When
        Student student2 = new Student();
        student2.setStudentName("updatedName");
        student2.setTerm(200);
        student2.setIdStudent(idStudent1);

        studentRepository.update(student2);


        // Then
        Assertions.assertEquals(idStudent1, studentRepository.getByName("updatedName").get(0).idStudent);

        //Clean
        studentRepository.delete(idStudent1);
    }

    @Test
    void testPatchStudent() {
        //Given
        Student student1 = new Student();
        student1.setStudentName("testName");
        student1.setTerm(100);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        studentRepository.save(students);

        int idStudent1 = studentRepository.getByName("testName").get(0).idStudent;

        //When
        Student student2 = new Student();
        student2.setStudentName("updatedName");
        student2.setIdStudent(idStudent1);

        studentRepository.update(student2);


        // Then
        Assertions.assertEquals(idStudent1, studentRepository.getByName("updatedName").get(0).idStudent);

        //Clean
        studentRepository.delete(idStudent1);
    }

    @Test
    void testDeleteStudent() {
        //Given
        Student student1 = new Student();
        student1.setStudentName("testName");
        student1.setTerm(100);

        Student student2 = new Student();
        student2.setStudentName("testName");
        student2.setTerm(100);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        studentRepository.save(students);

        //When & Then
        Assertions.assertEquals(2, studentRepository.getByName("testName").toArray().length);
        studentRepository.delete(studentRepository.getByName("testName").get(0).idStudent);

        Assertions.assertEquals(1, studentRepository.getByName("testName").toArray().length);

        //Clean
        studentRepository.delete(studentRepository.getByName("testName").get(0).idStudent);
    }
}
