package com.szmuraj.university.repository;

import com.szmuraj.university.domain.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FieldRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Field> getAll() {
        return jdbcTemplate.query("SELECT * FROM field",
                BeanPropertyRowMapper.newInstance(Field.class));
    }

    public Field getById(int idField) {
        return jdbcTemplate.queryForObject("SELECT * FROM field WHERE " +
                "idField = ?", BeanPropertyRowMapper.newInstance(Field.class), idField);
    }

    public List<Field> getByName(String fieldName) {
        return jdbcTemplate.query("SELECT * FROM field WHERE fieldName = ?",
                BeanPropertyRowMapper.newInstance(Field.class), fieldName);
    }

    public int save(List<Field> fields) {
        fields.forEach(field -> jdbcTemplate
                .update("INSERT INTO field(fieldName) VALUES(?)",
                        field.getFieldName()
                ));
        return 1;

    }

    public int update(Field field) {
        return jdbcTemplate.update("UPDATE field SET fieldName=? WHERE idField=?",
                field.getFieldName(), field.getIdField());
    }

    public int delete(int idField) {
        return jdbcTemplate.update("DELETE FROM field WHERE idField=?", idField);
    }
}
