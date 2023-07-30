package com.szmuraj.university.controller;

import com.szmuraj.university.domain.Specialization;
import com.szmuraj.university.repository.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specialization")
public class SpecializationController {

    @Autowired
    SpecializationRepository specializationRepository;

    @GetMapping("")
    public List<Specialization> getAll() {
        return specializationRepository.getAll();
    }

    @GetMapping("/id/{idSpecialization}")
    public Specialization getById(@PathVariable("idSpecialization") int idSpecialization) {
        return specializationRepository.getById(idSpecialization);
    }

    @GetMapping("/name/{specializationName}")
    public List<Specialization> getByName(@PathVariable("specializationName") String specializationName) {
        return specializationRepository.getByName(specializationName);
    }

    @PostMapping("")
    public int add(@RequestBody List<Specialization> specialization){
        return specializationRepository.save(specialization);
    }

    @PutMapping("/{idSpecialization}")
    public int update(@PathVariable("idSpecialization") int idSpecialization, @RequestBody Specialization updatedSpecialization) {
        Specialization specialization = specializationRepository.getById(idSpecialization);

        if (specialization != null) {
            specialization.setSpecializationName(updatedSpecialization.getSpecializationName());

            specializationRepository.update(specialization);

            return 1;
        } else {
            return 0;
        }
    }

    @DeleteMapping("/{idSpecialization}")
    public int delete(@PathVariable("idSpecialization") int idSpecialization) {
        return specializationRepository.delete(idSpecialization);
    }
}
