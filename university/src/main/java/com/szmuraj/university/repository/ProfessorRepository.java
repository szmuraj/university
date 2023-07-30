package com.szmuraj.university.repository;

import com.szmuraj.university.domain.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfessorRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Professor> getAll() {
        return jdbcTemplate.query("SELECT * FROM professor",
                BeanPropertyRowMapper.newInstance(Professor.class));
    }

    public Professor getById(int idProfessor) {
        return jdbcTemplate.queryForObject("SELECT * FROM professor WHERE " +
                "idProfessor = ?", BeanPropertyRowMapper.newInstance(Professor.class), idProfessor);
    }

    public List<Professor> getByName(String professorName) {
        return jdbcTemplate.query("SELECT * FROM professor WHERE professorName = ?",
                BeanPropertyRowMapper.newInstance(Professor.class), professorName);
    }

    public int save(List<Professor> professors) {
        professors.forEach(professor -> jdbcTemplate
                .update("INSERT INTO professor(professorName) VALUES(?)",
                        professor.getProfessorName()
                ));
        return 1;

    }

    public int update(Professor professor) {
        return jdbcTemplate.update("UPDATE professor SET professorName=? WHERE idProfessor=?",
                professor.getProfessorName(), professor.getIdProfessor());
    }

    public int delete(int idProfessor) {
        return jdbcTemplate.update("DELETE FROM professor WHERE idProfessor=?", idProfessor);
    }
}
