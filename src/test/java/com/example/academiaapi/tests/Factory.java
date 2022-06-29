package com.example.academiaapi.tests;

import com.example.academiaapi.entity.ExercicioEntity;

public class Factory {

   public static ExercicioEntity createExcercicioEntity() {
   ExercicioEntity excercicioEntity = new ExercicioEntity(1L,"Supino Reto");

        return  excercicioEntity;
   }
}
