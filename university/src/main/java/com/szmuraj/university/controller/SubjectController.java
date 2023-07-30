package com.szmuraj.university.controller;

import com.szmuraj.university.domain.Subject;
import com.szmuraj.university.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;

    @GetMapping("")
    public List<Subject> getAll() {
        return subjectRepository.getAll();
    }

    @GetMapping("/id/{idSubject}")
    public Subject getById(@PathVariable("idSubject") int idSubject) {
        return subjectRepository.getById(idSubject);
    }

    @GetMapping("/name/{subjectName}")
    public List<Subject> getByName(@PathVariable("subjectName") String subjectName) {
        return subjectRepository.getByName(subjectName);
    }

    @GetMapping("/group/{subjectGroup}")
    public List<Subject> getByGroup(@PathVariable("subjectGroup") int subjectGroup) {
        return subjectRepository.getByGroup(subjectGroup);
    }

    @PostMapping("")
    public int add(@RequestBody List<Subject> subject){
        return subjectRepository.save(subject);
    }

    @PutMapping("/{idSubject}")
    public int update(@PathVariable("idSubject") int idSubject, @RequestBody Subject updatedSubject) {
        Subject subject = subjectRepository.getById(idSubject);

        if (subject != null) {
            subject.setSubjectName(updatedSubject.getSubjectName());
            subject.setSubjectGroup(updatedSubject.getSubjectGroup());

            subjectRepository.update(subject);

            return 1;
        } else {
            return 0;
        }
    }

    @PatchMapping("/{idSubject}")
    public int partialUpdate(@PathVariable("idSubject") int idSubject, @RequestBody Subject updatedSubject) {
        Subject subject = subjectRepository.getById(idSubject);

        if (subject != null) {
            if (updatedSubject.getSubjectName() != null) subject.setSubjectName(updatedSubject.getSubjectName());
            if (updatedSubject.getSubjectGroup() > 0) subject.setSubjectGroup(updatedSubject.getSubjectGroup());

            subjectRepository.update(subject);

            return 1;
        } else {
            return 0;
        }
    }

    @DeleteMapping("/{idSubject}")
    public int delete(@PathVariable("idSubject") int idSubject) {
        return subjectRepository.delete(idSubject);
    }
}
