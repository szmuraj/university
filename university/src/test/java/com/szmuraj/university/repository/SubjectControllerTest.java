package com.szmuraj.university.repository;

import com.szmuraj.university.domain.Subject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SubjectControllerTest {

    @Autowired
    private SubjectRepository subjectRepository;

    @Test
    void testGetSubjectById() {
        //Given
        Subject subject1 = new Subject();
        subject1.setSubjectName("testName");
        subject1.setSubjectGroup(6);

        List<Subject> subjects = new ArrayList<>();
        subjects.add(subject1);

        subjectRepository.save(subjects);

        //When & Then
        Assertions.assertEquals(subjectRepository.getByName("testName").get(0).idSubject, subjectRepository.getById(subjectRepository.getByName("testName").get(0).idSubject).idSubject);

        //Clean
        subjectRepository.delete(subjectRepository.getByName("testName").get(0).idSubject);
    }

    @Test
    void testGetSubjectByName() {
        //Given
        Subject subject1 = new Subject();
        subject1.setSubjectName("testName");
        subject1.setSubjectGroup(100);

        List<Subject> subjects = new ArrayList<>();
        subjects.add(subject1);

        subjectRepository.save(subjects);

        //When & Then
        Assertions.assertEquals("testName", subjectRepository.getByName("testName").get(0).subjectName);

        //Clean
        subjectRepository.delete(subjectRepository.getByName("testName").get(0).idSubject);
    }

    @Test
    void testGetSubjectByTerm() {
        //Given
        Subject subject1 = new Subject();
        subject1.setSubjectName("testName");
        subject1.setSubjectGroup(100);

        List<Subject> subjects = new ArrayList<>();
        subjects.add(subject1);

        subjectRepository.save(subjects);

        //When & Then
        Assertions.assertEquals(100, subjectRepository.getByGroup(100).get(0).subjectGroup);

        //Clean
        subjectRepository.delete(subjectRepository.getByName("testName").get(0).idSubject);
    }
    @Test
    void testPostSubject() {
        //Given
        Subject subject1 = new Subject();
        subject1.setSubjectName("testName");
        subject1.setSubjectGroup(100);

        List<Subject> subjects = new ArrayList<>();
        subjects.add(subject1);

        subjectRepository.save(subjects);

        //When & Then
        Assertions.assertEquals("testName", subjectRepository.getByName("testName").get(0).subjectName);

        //Clean
        subjectRepository.delete(subjectRepository.getByName("testName").get(0).idSubject);
    }

    @Test
    void testPutSubject() {
        //Given
        Subject subject1 = new Subject();
        subject1.setSubjectName("testName");
        subject1.setSubjectGroup(100);

        List<Subject> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjectRepository.save(subjects);

        int idSubject1 = subjectRepository.getByName("testName").get(0).idSubject;

        //When
        Subject subject2 = new Subject();
        subject2.setSubjectName("updatedName");
        subject2.setSubjectGroup(200);
        subject2.setIdSubject(idSubject1);

        subjectRepository.update(subject2);


        // Then
        Assertions.assertEquals(idSubject1, subjectRepository.getByName("updatedName").get(0).idSubject);

        //Clean
        subjectRepository.delete(idSubject1);
    }

    @Test
    void testPatchSubject() {
        //Given
        Subject subject1 = new Subject();
        subject1.setSubjectName("testName");
        subject1.setSubjectGroup(100);

        List<Subject> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjectRepository.save(subjects);

        int idSubject1 = subjectRepository.getByName("testName").get(0).idSubject;

        //When
        Subject subject2 = new Subject();
        subject2.setSubjectName("updatedName");
        subject2.setIdSubject(idSubject1);

        subjectRepository.update(subject2);


        // Then
        Assertions.assertEquals(idSubject1, subjectRepository.getByName("updatedName").get(0).idSubject);

        //Clean
        subjectRepository.delete(idSubject1);
    }

    @Test
    void testDeleteSubject() {
        //Given
        Subject subject1 = new Subject();
        subject1.setSubjectName("testName");
        subject1.setSubjectGroup(100);

        Subject subject2 = new Subject();
        subject2.setSubjectName("testName");
        subject2.setSubjectGroup(100);

        List<Subject> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);

        subjectRepository.save(subjects);

        //When & Then
        Assertions.assertEquals(2, subjectRepository.getByName("testName").toArray().length);
        subjectRepository.delete(subjectRepository.getByName("testName").get(0).idSubject);

        Assertions.assertEquals(1, subjectRepository.getByName("testName").toArray().length);

        //Clean
        subjectRepository.delete(subjectRepository.getByName("testName").get(0).idSubject);
    }
}
