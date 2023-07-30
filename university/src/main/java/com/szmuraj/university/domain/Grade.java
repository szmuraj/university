package com.szmuraj.university.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grade {

    public int idGrade;
    public int idStudent;
    public int idProfessor;
    public int idSubject;
    public int idSpecialization;
    public double grade;
}
