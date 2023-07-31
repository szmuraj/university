package com.szmuraj.university.repository;

import com.szmuraj.university.domain.Professor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ProfessorControllerTest {

    @Autowired
    private ProfessorRepository professorRepository;

    @Test
    void testGetProfessorById() {
        //Given
        Professor professor1 = new Professor();
        professor1.setProfessorName("testName");

        List<Professor> professors = new ArrayList<>();
        professors.add(professor1);

        professorRepository.save(professors);

        //When & Then
        Assertions.assertEquals(professorRepository.getByName("testName").get(0).idProfessor, professorRepository.getById(professorRepository.getByName("testName").get(0).idProfessor).idProfessor);

        //Clean
        professorRepository.delete(professorRepository.getByName("testName").get(0).idProfessor);
    }

    @Test
    void testGetProfessorByName() {
        //Given
        Professor professor1 = new Professor();
        professor1.setProfessorName("testName");

        List<Professor> professors = new ArrayList<>();
        professors.add(professor1);

        professorRepository.save(professors);

        //When & Then
        Assertions.assertEquals("testName", professorRepository.getByName("testName").get(0).professorName);

        //Clean
        professorRepository.delete(professorRepository.getByName("testName").get(0).idProfessor);
    }

    @Test
    void testPostProfessor() {
        //Given
        Professor professor1 = new Professor();
        professor1.setProfessorName("testName");

        List<Professor> professors = new ArrayList<>();
        professors.add(professor1);

        professorRepository.save(professors);

        //When & Then
        Assertions.assertEquals("testName", professorRepository.getByName("testName").get(0).professorName);

        //Clean
        professorRepository.delete(professorRepository.getByName("testName").get(0).idProfessor);
    }

    @Test
    void testPutProfessor() {
        //Given
        Professor professor1 = new Professor();
        professor1.setProfessorName("testName");

        List<Professor> professors = new ArrayList<>();
        professors.add(professor1);
        professorRepository.save(professors);

        int idProfessor1 = professorRepository.getByName("testName").get(0).idProfessor;

        //When
        Professor professor2 = new Professor();
        professor2.setProfessorName("updatedName");
        professor2.setIdProfessor(idProfessor1);

        professorRepository.update(professor2);


        // Then
        Assertions.assertEquals(idProfessor1, professorRepository.getByName("updatedName").get(0).idProfessor);

        //Clean
        professorRepository.delete(idProfessor1);
    }

    @Test
    void testPatchProfessor() {
        //Given
        Professor professor1 = new Professor();
        professor1.setProfessorName("testName");

        List<Professor> professors = new ArrayList<>();
        professors.add(professor1);
        professorRepository.save(professors);

        int idProfessor1 = professorRepository.getByName("testName").get(0).idProfessor;

        //When
        Professor professor2 = new Professor();
        professor2.setProfessorName("updatedName");
        professor2.setIdProfessor(idProfessor1);

        professorRepository.update(professor2);


        // Then
        Assertions.assertEquals(idProfessor1, professorRepository.getByName("updatedName").get(0).idProfessor);

        //Clean
        professorRepository.delete(idProfessor1);
    }

    @Test
    void testDeleteProfessor() {
        //Given
        Professor professor1 = new Professor();
        professor1.setProfessorName("testName");

        Professor professor2 = new Professor();
        professor2.setProfessorName("testName");

        List<Professor> professors = new ArrayList<>();
        professors.add(professor1);
        professors.add(professor2);

        professorRepository.save(professors);

        //When & Then
        Assertions.assertEquals(2, professorRepository.getByName("testName").toArray().length);
        professorRepository.delete(professorRepository.getByName("testName").get(0).idProfessor);

        Assertions.assertEquals(1, professorRepository.getByName("testName").toArray().length);

        //Clean
        professorRepository.delete(professorRepository.getByName("testName").get(0).idProfessor);
    }
}
