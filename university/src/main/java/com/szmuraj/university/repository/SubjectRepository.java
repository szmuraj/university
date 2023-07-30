package com.szmuraj.university.repository;

import com.szmuraj.university.domain.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Subject> getAll() {
        return jdbcTemplate.query("SELECT * FROM subject",
                BeanPropertyRowMapper.newInstance(Subject.class));
    }

    public Subject getById(int idSubject) {
        return jdbcTemplate.queryForObject("SELECT * FROM subject WHERE " +
                "idSubject = ?", BeanPropertyRowMapper.newInstance(Subject.class), idSubject);
    }

    public List<Subject> getByName(String subjectName) {
        return jdbcTemplate.query("SELECT * FROM subject WHERE subjectName = ?",
                BeanPropertyRowMapper.newInstance(Subject.class), subjectName);
    }

    public List<Subject> getByGroup(int subjectGroup) {
        return jdbcTemplate.query("SELECT * FROM subject WHERE subjectGroup = ?",
                BeanPropertyRowMapper.newInstance(Subject.class), subjectGroup);
    }

    public int save(List<Subject> subjects) {
        subjects.forEach(subject -> jdbcTemplate
                .update("INSERT INTO subject(subjectName, subjectGroup) VALUES(?, ?)",
                        subject.getSubjectName(),
                        subject.getSubjectGroup()
                ));
        return 1;

    }

    public int update(Subject subject) {
        return jdbcTemplate.update("UPDATE subject SET subjectName=?, subjectGroup=? WHERE idSubject=?",
                subject.getSubjectName(), subject.getSubjectGroup(), subject.getIdSubject());
    }

    public int delete(int idSubject) {
        return jdbcTemplate.update("DELETE FROM subject WHERE idSubject=?", idSubject);
    }
}
