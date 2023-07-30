package com.szmuraj.university.repository;


import com.szmuraj.university.controller.StudentController;
import com.szmuraj.university.domain.Student;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(StudentController.class)
public class StudentRepositoryTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentController studentController;

    @Test
    void testAddNew() {
        //Given
        Student student1 = new Student();
        student1.setStudentName("testName");
        student1.setTerm(6);

        List<Student> students = new ArrayList<>();
        students.add(student1);

        studentRepository.save(students);

        //When

        //Then
        Assertions.assertEquals("[Student(idStudent=35, studentName=testName, term=6)]", studentRepository.getByName("testName").toString());

        //Clean
        studentRepository.delete(36);

    }

    @Test
    void getAllStudents() throws Exception {
        //Given
        when(studentController.getAll()).thenReturn(List.of());

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/student")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0))
                );
    }



}
