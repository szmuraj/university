package com.szmuraj.university.repository;

import com.szmuraj.university.domain.StudentFieldSpecialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentFieldSpecializationRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<StudentFieldSpecialization> getAll() {
        return jdbcTemplate.query("SELECT * FROM studentFieldSpecialization",
                BeanPropertyRowMapper.newInstance(StudentFieldSpecialization.class));
    }

    public StudentFieldSpecialization getById(int idStudentFieldSpecialization) {
        return jdbcTemplate.queryForObject("SELECT * FROM studentFieldSpecialization WHERE " +
                "idStudentFieldSpecialization = ?", BeanPropertyRowMapper.newInstance(StudentFieldSpecialization.class), idStudentFieldSpecialization);
    }

    public StudentFieldSpecialization getByIdStudent(int idStudent) {
        return jdbcTemplate.queryForObject("SELECT * FROM studentFieldSpecialization WHERE " +
                "idStudent = ?", BeanPropertyRowMapper.newInstance(StudentFieldSpecialization.class), idStudent);
    }
    public StudentFieldSpecialization getByIdField(int idField) {
        return jdbcTemplate.queryForObject("SELECT * FROM studentFieldSpecialization WHERE " +
                "idField = ?", BeanPropertyRowMapper.newInstance(StudentFieldSpecialization.class), idField);
    }

    public StudentFieldSpecialization getByIdSpecialization(int idSpecialization) {
        return jdbcTemplate.queryForObject("SELECT * FROM studentFieldSpecialization WHERE " +
                "idSpecialization = ?", BeanPropertyRowMapper.newInstance(StudentFieldSpecialization.class), idSpecialization);
    }

    public int save(List<StudentFieldSpecialization> studentFieldSpecializations) {
        studentFieldSpecializations.forEach(studentFieldSpecialization -> jdbcTemplate
                .update("INSERT INTO studentFieldSpecialization(idStudent, idField, idSpecialization) VALUES(?, ?, ?)",
                        studentFieldSpecialization.getIdStudent(),
                        studentFieldSpecialization.getIdField(),
                        studentFieldSpecialization.getIdSpecialization()
                ));
        return 1;

    }

    public int update(StudentFieldSpecialization studentFieldSpecialization) {
        return jdbcTemplate.update("UPDATE studentFieldSpecialization SET idStudent=?, idField=?, idSpecialization=? WHERE idStudentFieldSpecialization=?",
                studentFieldSpecialization.getIdStudent(),
                studentFieldSpecialization.getIdField(),
                studentFieldSpecialization.getIdSpecialization(),
                studentFieldSpecialization.getIdStudentFieldSpecialization()
        );
    }

    public int delete(int idStudentFieldSpecialization) {
        return jdbcTemplate.update("DELETE FROM studentFieldSpecialization WHERE idStudentFieldSpecialization=?", idStudentFieldSpecialization);
    }
}
