package com.szmuraj.university.controller;

import com.szmuraj.university.domain.StudentFieldSpecialization;
import com.szmuraj.university.repository.StudentFieldSpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentFieldSpecialization")
public class StudentFieldSpecializationController {

    @Autowired
    StudentFieldSpecializationRepository studentFieldSpecializationRepository;

    @GetMapping("")
    public List<StudentFieldSpecialization> getAll() {
        return studentFieldSpecializationRepository.getAll();
    }

    @GetMapping("/id/{idStudentFieldSpecialization}")
    public StudentFieldSpecialization getById(@PathVariable("idStudentFieldSpecialization") int idStudentFieldSpecialization) {
        return studentFieldSpecializationRepository.getById(idStudentFieldSpecialization);
    }

    @GetMapping("/idStudent/{idStudent}")
    public StudentFieldSpecialization getByIdStudent(@PathVariable("idStudent") int idStudent) {
        return studentFieldSpecializationRepository.getByIdStudent(idStudent);
    }

    @GetMapping("/idField/{idField}")
    public StudentFieldSpecialization getByIdField(@PathVariable("idField") int idField) {
        return studentFieldSpecializationRepository.getByIdField(idField);
    }

    @GetMapping("/idSpecialization/{idSpecialization}")
    public StudentFieldSpecialization getByIdSpecialization(@PathVariable("idSpecialization") int idSpecialization) {
        return studentFieldSpecializationRepository.getByIdSpecialization(idSpecialization);
    }

    @PostMapping("")
    public int add(@RequestBody List<StudentFieldSpecialization> studentFieldSpecialization){
        return studentFieldSpecializationRepository.save(studentFieldSpecialization);
    }

    @PutMapping("/{idStudentFieldSpecialization}")
    public int update(@PathVariable("idStudentFieldSpecialization") int idStudentFieldSpecialization, @RequestBody StudentFieldSpecialization updatedStudentFieldSpecialization) {
        StudentFieldSpecialization studentFieldSpecialization = studentFieldSpecializationRepository.getById(idStudentFieldSpecialization);

        if (studentFieldSpecialization != null) {
            studentFieldSpecialization.setIdStudent(updatedStudentFieldSpecialization.getIdStudent());
            studentFieldSpecialization.setIdField(updatedStudentFieldSpecialization.getIdField());
            studentFieldSpecialization.setIdSpecialization(updatedStudentFieldSpecialization.getIdSpecialization());

            studentFieldSpecializationRepository.update(studentFieldSpecialization);

            return 1;
        } else {
            return 0;
        }
    }

    @PatchMapping("/{idStudentFieldSpecialization}")
    public int partialUpdate(@PathVariable("idStudentFieldSpecialization") int idStudentFieldSpecialization, @RequestBody StudentFieldSpecialization updatedStudentFieldSpecialization) {
        StudentFieldSpecialization studentFieldSpecialization = studentFieldSpecializationRepository.getById(idStudentFieldSpecialization);

        if (studentFieldSpecialization != null) {
            if (updatedStudentFieldSpecialization.getIdStudent() != 0) studentFieldSpecialization.setIdStudent(updatedStudentFieldSpecialization.getIdStudent());
            if (updatedStudentFieldSpecialization.getIdField() != 0) studentFieldSpecialization.setIdField(updatedStudentFieldSpecialization.getIdField());
            if (updatedStudentFieldSpecialization.getIdSpecialization() != 0) studentFieldSpecialization.setIdSpecialization(updatedStudentFieldSpecialization.getIdSpecialization());

            studentFieldSpecializationRepository.update(studentFieldSpecialization);

            return 1;
        } else {
            return 0;
        }
    }

    @DeleteMapping("/{idStudentFieldSpecialization}")
    public int delete(@PathVariable("idStudentFieldSpecialization") int idStudentFieldSpecialization) {
        return studentFieldSpecializationRepository.delete(idStudentFieldSpecialization);
    }
}
