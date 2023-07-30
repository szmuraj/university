package com.szmuraj.university.controller;

import com.szmuraj.university.domain.Grade;
import com.szmuraj.university.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    GradeRepository gradeRepository;

    @GetMapping("")
    public List<Grade> getAll() {
        return gradeRepository.getAll();
    }

    @GetMapping("/id/{idGrade}")
    public Grade getById(@PathVariable("idGrade") int idGrade) {
        return gradeRepository.getById(idGrade);
    }

    @GetMapping("/idStudent/{idStudent}")
    public Grade getByIdStudent(@PathVariable("idStudent") int idStudent) {
        return gradeRepository.getByIdStudent(idStudent);
    }

    @GetMapping("/idProfessor/{idProfessor}")
    public Grade getByIdProfessor(@PathVariable("idProfessor") int idProfessor) {
        return gradeRepository.getByIdProfessor(idProfessor);
    }

    @GetMapping("/idSubject/{idSubject}")
    public Grade getByIdSubject(@PathVariable("idSubject") int idSubject) {
        return gradeRepository.getByIdSubject(idSubject);
    }

    @GetMapping("/idSpecialization/{idSpecialization}")
    public Grade getByIdSpecialization(@PathVariable("idSpecialization") int idSpecialization) {
        return gradeRepository.getByIdSpecialization(idSpecialization);
    }

    @GetMapping("/{grade}")
    public Grade getByGrade(@PathVariable("grade") double grade) {
        return gradeRepository.getByGrade(grade);
    }

    @PostMapping("")
    public int add(@RequestBody List<Grade> grade){
        return gradeRepository.save(grade);
    }

    @PutMapping("/{idGrade}")
    public int update(@PathVariable("idGrade") int idGrade, @RequestBody Grade updatedGrade) {
        Grade grade= gradeRepository.getById(idGrade);

        if (grade != null) {
            grade.setIdStudent(updatedGrade.getIdStudent());
            grade.setIdProfessor(updatedGrade.getIdProfessor());
            grade.setIdSubject(updatedGrade.getIdSubject());
            grade.setIdSpecialization(updatedGrade.getIdSpecialization());
            grade.setGrade(updatedGrade.getGrade());

            gradeRepository.update(grade);

            return 1;
        } else {
            return 0;
        }
    }

    @PatchMapping("/{idGrade}")
    public int partialUpdate(@PathVariable("idGrade") int idGrade, @RequestBody Grade updatedGrade) {
        Grade grade = gradeRepository.getById(idGrade);

        if (grade != null) {
            if (updatedGrade.getIdStudent() != 0) grade.setIdStudent(updatedGrade.getIdStudent());
            if (updatedGrade.getIdProfessor() != 0) grade.setIdProfessor(updatedGrade.getIdProfessor());
            if (updatedGrade.getIdSubject() != 0) grade.setIdSubject(updatedGrade.getIdSubject());
            if (updatedGrade.getIdSpecialization() != 0) grade.setIdSpecialization(updatedGrade.getIdSpecialization());
            if (updatedGrade.getGrade() != 0) grade.setGrade(updatedGrade.getGrade());

            gradeRepository.update(grade);

            return 1;
        } else {
            return 0;
        }
    }

    @DeleteMapping("/{idGrade}")
    public int delete(@PathVariable("idGrade") int idGrade) {
        return gradeRepository.delete(idGrade);
    }
}
