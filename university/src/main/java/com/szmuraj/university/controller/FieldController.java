package com.szmuraj.university.controller;

import com.szmuraj.university.domain.Field;
import com.szmuraj.university.repository.FieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/field")
public class FieldController {

    @Autowired
    FieldRepository fieldRepository;

    @GetMapping("")
    public List<Field> getAll() {
        return fieldRepository.getAll();
    }

    @GetMapping("/id/{idField}")
    public Field getById(@PathVariable("idField") int idField) {
        return fieldRepository.getById(idField);
    }

    @GetMapping("/name/{fieldName}")
    public List<Field> getByName(@PathVariable("fieldName") String fieldName) {
        return fieldRepository.getByName(fieldName);
    }

    @PostMapping("")
    public int add(@RequestBody List<Field> field){
        return fieldRepository.save(field);
    }

    @PutMapping("/{idField}")
    public int update(@PathVariable("idField") int idField, @RequestBody Field updatedField) {
        Field field = fieldRepository.getById(idField);

        if (field != null) {
            field.setFieldName(updatedField.getFieldName());

            fieldRepository.update(field);

            return 1;
        } else {
            return 0;
        }
    }

    @DeleteMapping("/{idField}")
    public int delete(@PathVariable("idField") int idField) {
        return fieldRepository.delete(idField);
    }
}
