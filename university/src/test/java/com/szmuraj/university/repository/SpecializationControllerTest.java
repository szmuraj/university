package com.szmuraj.university.repository;

import com.szmuraj.university.domain.Specialization;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SpecializationControllerTest {

    @Autowired
    private SpecializationRepository specializationRepository;

    @Test
    void testGetSpecializationById() {
        //Given
        Specialization specialization1 = new Specialization();
        specialization1.setSpecializationName("testName");

        List<Specialization> specializations = new ArrayList<>();
        specializations.add(specialization1);

        specializationRepository.save(specializations);

        //When & Then
        Assertions.assertEquals(specializationRepository.getByName("testName").get(0).getIdSpecialization(), specializationRepository.getById(specializationRepository.getByName("testName").get(0).getIdSpecialization()).getIdSpecialization());

        //Clean
        specializationRepository.delete(specializationRepository.getByName("testName").get(0).getIdSpecialization());
    }

    @Test
    void testGetSpecializationByName() {
        //Given
        Specialization specialization1 = new Specialization();
        specialization1.setSpecializationName("testName");

        List<Specialization> specializations = new ArrayList<>();
        specializations.add(specialization1);

        specializationRepository.save(specializations);

        //When & Then
        Assertions.assertEquals("testName", specializationRepository.getByName("testName").get(0).getSpecializationName());

        //Clean
        specializationRepository.delete(specializationRepository.getByName("testName").get(0).getIdSpecialization());
    }

    @Test
    void testPostSpecialization() {
        //Given
        Specialization specialization1 = new Specialization();
        specialization1.setSpecializationName("testName");

        List<Specialization> specializations = new ArrayList<>();
        specializations.add(specialization1);

        specializationRepository.save(specializations);

        //When & Then
        Assertions.assertEquals("testName", specializationRepository.getByName("testName").get(0).getSpecializationName());

        //Clean
        specializationRepository.delete(specializationRepository.getByName("testName").get(0).getIdSpecialization());
    }

    @Test
    void testPutSpecialization() {
        //Given
        Specialization specialization1 = new Specialization();
        specialization1.setSpecializationName("testName");

        List<Specialization> specializations = new ArrayList<>();
        specializations.add(specialization1);
        specializationRepository.save(specializations);

        int idSpecialization1 = specializationRepository.getByName("testName").get(0).getIdSpecialization();

        //When
        Specialization specialization2 = new Specialization();
        specialization2.setSpecializationName("updatedName");
        specialization2.setIdSpecialization(idSpecialization1);

        specializationRepository.update(specialization2);


        // Then
        Assertions.assertEquals(idSpecialization1, specializationRepository.getByName("updatedName").get(0).getIdSpecialization());

        //Clean
        specializationRepository.delete(idSpecialization1);
    }

    @Test
    void testPatchSpecialization() {
        //Given
        Specialization specialization1 = new Specialization();
        specialization1.setSpecializationName("testName");

        List<Specialization> specializations = new ArrayList<>();
        specializations.add(specialization1);
        specializationRepository.save(specializations);

        int idSpecialization1 = specializationRepository.getByName("testName").get(0).getIdSpecialization();

        //When
        Specialization specialization2 = new Specialization();
        specialization2.setSpecializationName("updatedName");
        specialization2.setIdSpecialization(idSpecialization1);

        specializationRepository.update(specialization2);


        // Then
        Assertions.assertEquals(idSpecialization1, specializationRepository.getByName("updatedName").get(0).getIdSpecialization());

        //Clean
        specializationRepository.delete(idSpecialization1);
    }

    @Test
    void testDeleteSpecialization() {
        //Given
        Specialization specialization1 = new Specialization();
        specialization1.setSpecializationName("testName");

        Specialization specialization2 = new Specialization();
        specialization2.setSpecializationName("testName");

        List<Specialization> specializations = new ArrayList<>();
        specializations.add(specialization1);
        specializations.add(specialization2);

        specializationRepository.save(specializations);

        //When & Then
        Assertions.assertEquals(2, specializationRepository.getByName("testName").toArray().length);
        specializationRepository.delete(specializationRepository.getByName("testName").get(0).getIdSpecialization());

        Assertions.assertEquals(1, specializationRepository.getByName("testName").toArray().length);

        //Clean
        specializationRepository.delete(specializationRepository.getByName("testName").get(0).getIdSpecialization());
    }
}
