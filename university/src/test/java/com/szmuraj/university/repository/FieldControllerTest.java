package com.szmuraj.university.repository;

import com.szmuraj.university.domain.Field;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class FieldControllerTest {

    @Autowired
    private FieldRepository fieldRepository;

    @Test
    void testGetFieldById() {
        //Given
        Field field1 = new Field();
        field1.setFieldName("testName");

        List<Field> fields = new ArrayList<>();
        fields.add(field1);

        fieldRepository.save(fields);

        //When & Then
        Assertions.assertEquals(fieldRepository.getByName("testName").get(0).getIdField(), fieldRepository.getById(fieldRepository.getByName("testName").get(0).getIdField()).getIdField());

        //Clean
        fieldRepository.delete(fieldRepository.getByName("testName").get(0).getIdField());
    }

    @Test
    void testGetFieldByName() {
        //Given
        Field field1 = new Field();
        field1.setFieldName("testName");

        List<Field> fields = new ArrayList<>();
        fields.add(field1);

        fieldRepository.save(fields);

        //When & Then
        Assertions.assertEquals("testName", fieldRepository.getByName("testName").get(0).getFieldName());

        //Clean
        fieldRepository.delete(fieldRepository.getByName("testName").get(0).getIdField());
    }

    @Test
    void testPostField() {
        //Given
        Field field1 = new Field();
        field1.setFieldName("testName");

        List<Field> fields = new ArrayList<>();
        fields.add(field1);

        fieldRepository.save(fields);

        //When & Then
        Assertions.assertEquals("testName", fieldRepository.getByName("testName").get(0).getFieldName());

        //Clean
        fieldRepository.delete(fieldRepository.getByName("testName").get(0).getIdField());
    }

    @Test
    void testPutField() {
        //Given
        Field field1 = new Field();
        field1.setFieldName("testName");

        List<Field> fields = new ArrayList<>();
        fields.add(field1);
        fieldRepository.save(fields);

        int idField1 = fieldRepository.getByName("testName").get(0).getIdField();

        //When
        Field field2 = new Field();
        field2.setFieldName("updatedName");
        field2.setIdField(idField1);

        fieldRepository.update(field2);


        // Then
        Assertions.assertEquals(idField1, fieldRepository.getByName("updatedName").get(0).getIdField());

        //Clean
        fieldRepository.delete(idField1);
    }

    @Test
    void testPatchField() {
        //Given
        Field field1 = new Field();
        field1.setFieldName("testName");

        List<Field> fields = new ArrayList<>();
        fields.add(field1);
        fieldRepository.save(fields);

        int idField1 = fieldRepository.getByName("testName").get(0).getIdField();

        //When
        Field field2 = new Field();
        field2.setFieldName("updatedName");
        field2.setIdField(idField1);

        fieldRepository.update(field2);


        // Then
        Assertions.assertEquals(idField1, fieldRepository.getByName("updatedName").get(0).getIdField());

        //Clean
        fieldRepository.delete(idField1);
    }

    @Test
    void testDeleteField() {
        //Given
        Field field1 = new Field();
        field1.setFieldName("testName");

        Field field2 = new Field();
        field2.setFieldName("testName");

        List<Field> fields = new ArrayList<>();
        fields.add(field1);
        fields.add(field2);

        fieldRepository.save(fields);

        //When & Then
        Assertions.assertEquals(2, fieldRepository.getByName("testName").toArray().length);
        fieldRepository.delete(fieldRepository.getByName("testName").get(0).getIdField());

        Assertions.assertEquals(1, fieldRepository.getByName("testName").toArray().length);

        //Clean
        fieldRepository.delete(fieldRepository.getByName("testName").get(0).getIdField());
    }
}
