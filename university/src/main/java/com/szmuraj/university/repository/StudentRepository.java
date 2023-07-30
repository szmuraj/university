package com.szmuraj.university.repository;

import com.szmuraj.university.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Student> getAll() {
        return jdbcTemplate.query("SELECT * FROM student",
                BeanPropertyRowMapper.newInstance(Student.class));
    }

    public Student getById(int idStudent) {
        return jdbcTemplate.queryForObject("SELECT * FROM student WHERE " +
                "idStudent = ?", BeanPropertyRowMapper.newInstance(Student.class), idStudent);
    }

    public List<Student> getByName(String studentName) {
        return jdbcTemplate.query("SELECT * FROM student WHERE studentName = ?",
                BeanPropertyRowMapper.newInstance(Student.class), studentName);
    }

    public List<Student> getByTerm(int term) {
        return jdbcTemplate.query("SELECT * FROM student WHERE term = ?",
                BeanPropertyRowMapper.newInstance(Student.class), term);
    }

    public int save(List<Student> students) {
        students.forEach(student -> jdbcTemplate
                .update("INSERT INTO student(studentName, term) VALUES(?, ?)",
                        student.getStudentName(),
                        student.getTerm()
                ));
        return 1;

    }

    public int update(Student student) {
        return jdbcTemplate.update("UPDATE student SET studentName=?, term=? WHERE idStudent=?",
                student.getStudentName(),
                student.getTerm(),
                student.getIdStudent()
        );
    }

    public int delete(int idStudent) {
        return jdbcTemplate.update("DELETE FROM student WHERE idStudent=?", idStudent);
    }
}
