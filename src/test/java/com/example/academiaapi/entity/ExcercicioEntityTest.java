package com.example.academiaapi.entity;

import com.example.academiaapi.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExcercicioEntityTest {

    @BeforeEach
    void setUp(){
      //  ExcercicioEntity excercicioEntity = new ExcercicioEntity(1L,"Supino Reto");



    }

    @Test
    void getIdShouldReturnId() {
        Long id = 1L;
        ExercicioEntity excercicioEntity = Factory.createExcercicioEntity();
        excercicioEntity.setId(id);

        Assertions.assertEquals(id,excercicioEntity.getId());


    }

    @Test
    void getNome() {
    }

    @Test
    void setIdShouldSetId() {
        Long id = 5L;
        ExercicioEntity excercicioEntity = Factory.createExcercicioEntity();
        excercicioEntity.setId(id);
        Assertions.assertEquals(5L,excercicioEntity.getId());
    }

    @Test
    void setNome() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void canEqual() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testToString() {
    }
}