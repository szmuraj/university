package com.szmuraj.university.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {


    public int idSubject;

    public String subjectName;

    public int subjectGroup;
}
