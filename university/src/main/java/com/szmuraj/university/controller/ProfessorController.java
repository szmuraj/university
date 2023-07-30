package com.szmuraj.university.controller;

import com.szmuraj.university.domain.Professor;
import com.szmuraj.university.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    ProfessorRepository professorRepository;

    @GetMapping("")
    public List<Professor> getAll() {
        return professorRepository.getAll();
    }

    @GetMapping("/id/{idProfessor}")
    public Professor getById(@PathVariable("idProfessor") int idProfessor) {
        return professorRepository.getById(idProfessor);
    }

    @GetMapping("/name/{professorName}")
    public List<Professor> getByName(@PathVariable("professorName") String professorName) {
        return professorRepository.getByName(professorName);
    }

    @PostMapping("")
    public int add(@RequestBody List<Professor> professor){
        return professorRepository.save(professor);
    }

    @PutMapping("/{idProfessor}")
    public int update(@PathVariable("idProfessor") int idProfessor, @RequestBody Professor updatedProfessor) {
        Professor professor = professorRepository.getById(idProfessor);

        if (professor != null) {
            professor.setProfessorName(updatedProfessor.getProfessorName());

            professorRepository.update(professor);

            return 1;
        } else {
            return 0;
        }
    }

    @DeleteMapping("/{idProfessor}")
    public int delete(@PathVariable("idProfessor") int idProfessor) {
        return professorRepository.delete(idProfessor);
    }
}
