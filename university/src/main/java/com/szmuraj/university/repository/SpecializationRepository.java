package com.szmuraj.university.repository;

import com.szmuraj.university.domain.Specialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpecializationRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Specialization> getAll() {
        return jdbcTemplate.query("SELECT * FROM specialization",
                BeanPropertyRowMapper.newInstance(Specialization.class));
    }

    public Specialization getById(int idSpecialization) {
        return jdbcTemplate.queryForObject("SELECT * FROM specialization WHERE " +
                "idSpecialization = ?", BeanPropertyRowMapper.newInstance(Specialization.class), idSpecialization);
    }

    public List<Specialization> getByName(String specializationName) {
        return jdbcTemplate.query("SELECT * FROM specialization WHERE specializationName = ?",
                BeanPropertyRowMapper.newInstance(Specialization.class), specializationName);
    }

    public int save(List<Specialization> specializations) {
        specializations.forEach(specialization -> jdbcTemplate
                .update("INSERT INTO specialization(specializationName) VALUES(?)",
                        specialization.getSpecializationName()
                ));
        return 1;

    }

    public int update(Specialization specialization) {
        return jdbcTemplate.update("UPDATE specialization SET specializationName=? WHERE idSpecialization=?",
                specialization.getSpecializationName(), specialization.getIdSpecialization());
    }

    public int delete(int idSpecialization) {
        return jdbcTemplate.update("DELETE FROM specialization WHERE idSpecialization=?", idSpecialization);
    }
}
