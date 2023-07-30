package com.szmuraj.university.repository;


import com.szmuraj.university.domain.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GradeRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Grade> getAll() {
        return jdbcTemplate.query("SELECT * FROM grade",
                BeanPropertyRowMapper.newInstance(Grade.class));
    }

    public Grade getById(int idGrade) {
        return jdbcTemplate.queryForObject("SELECT * FROM grade WHERE " +
                "idGrade = ?", BeanPropertyRowMapper.newInstance(Grade.class), idGrade);
    }

    public Grade getByIdStudent(int idStudent) {
        return jdbcTemplate.queryForObject("SELECT * FROM grade WHERE " +
                "idStudent = ?", BeanPropertyRowMapper.newInstance(Grade.class), idStudent);
    }

    public Grade getByIdProfessor(int idProfessor) {
        return jdbcTemplate.queryForObject("SELECT * FROM grade WHERE " +
                "idProfessor = ?", BeanPropertyRowMapper.newInstance(Grade.class), idProfessor);
    }

    public Grade getByIdSubject(int idSubject) {
        return jdbcTemplate.queryForObject("SELECT * FROM grade WHERE " +
                "idSubject = ?", BeanPropertyRowMapper.newInstance(Grade.class), idSubject);
    }

    public Grade getByIdSpecialization(int idSpecialization) {
        return jdbcTemplate.queryForObject("SELECT * FROM grade WHERE " +
                "idSpecialization = ?", BeanPropertyRowMapper.newInstance(Grade.class), idSpecialization);
    }

    public Grade getByGrade(double grade) {
        return jdbcTemplate.queryForObject("SELECT * FROM grade WHERE " +
                "grade = ?", BeanPropertyRowMapper.newInstance(Grade.class), grade);
    }

    public int save(List<Grade> grades) {
        grades.forEach(grade -> jdbcTemplate
                .update("INSERT INTO grade(idStudent, idProfessor, idSubject, idSpecialization, grade) VALUES(?, ?, ?, ?, ?)",
                        grade.getIdStudent(),
                        grade.getIdProfessor(),
                        grade.getIdSubject(),
                        grade.getIdSpecialization(),
                        grade.getGrade()
                ));
        return 1;

    }

    public int update(Grade grade) {
        return jdbcTemplate.update("UPDATE grade SET idStudent=?, idProfessor=?, idSubject=?, idSpecialization=?, grade=? WHERE idGrade=?",
                grade.getIdStudent(),
                grade.getIdProfessor(),
                grade.getIdSubject(),
                grade.getIdSpecialization(),
                grade.getGrade(),
                grade.getIdGrade()
        );
    }

    public int delete(int idGrade) {
        return jdbcTemplate.update("DELETE FROM grade WHERE idGrade=?", idGrade);
    }
}
