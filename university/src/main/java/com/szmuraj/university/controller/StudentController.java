package com.szmuraj.university.controller;

import com.szmuraj.university.domain.Student;
import com.szmuraj.university.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("")
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    @GetMapping("/id/{idStudent}")
    public Student getById(@PathVariable("idStudent") int idStudent) {
        return studentRepository.getById(idStudent);
    }

    @GetMapping("/name/{studentName}")
    public List<Student> getByName(@PathVariable("studentName") String studentName) {
        return studentRepository.getByName(studentName);
    }

    @GetMapping("/term/{term}")
    public List<Student> getByTerm(@PathVariable("term") int term) {
        return studentRepository.getByTerm(term);
    }

    @PostMapping("")
    public int add(@RequestBody List<Student> student){
        return studentRepository.save(student);
    }

    @PutMapping("/{idStudent}")
    public int update(@PathVariable("idStudent") int idStudent, @RequestBody Student updatedStudent) {
        Student student = studentRepository.getById(idStudent);

        if (student != null) {
            student.setStudentName(updatedStudent.getStudentName());
            student.setTerm(updatedStudent.getTerm());

            studentRepository.update(student);

            return 1;
        } else {
            return 0;
        }
    }

    @PatchMapping("/{idStudent}")
    public int partialUpdate(@PathVariable("idStudent") int idStudent, @RequestBody Student updatedStudent) {
        Student student = studentRepository.getById(idStudent);

        if (student != null) {
            if (updatedStudent.getStudentName() != null) student.setStudentName(updatedStudent.getStudentName());
            if (updatedStudent.getTerm() > 0) student.setTerm(updatedStudent.getTerm());

            studentRepository.update(student);

            return 1;
        } else {
            return 0;
        }
    }

    @DeleteMapping("/{idStudent}")
    public int delete(@PathVariable("idStudent") int idStudent) {
        return studentRepository.delete(idStudent);
    }
}
