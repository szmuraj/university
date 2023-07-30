package com.szmuraj.university.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentFieldSpecialization {


    public int idStudentFieldSpecialization;

    public int idStudent;

    public int idField;

    public int idSpecialization;
}
