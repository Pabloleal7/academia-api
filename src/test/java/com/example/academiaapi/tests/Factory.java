package com.example.academiaapi.tests;

import com.example.academiaapi.entity.ExercicioEntity;
import com.example.academiaapi.entity.Role;
import com.example.academiaapi.entity.UserEntity;
import com.example.academiaapi.enums.MetodoDeTreino;

import java.util.Set;

public class Factory {

    public static ExercicioEntity createExcercicioEntity() {
        ExercicioEntity excercicioEntity = new ExercicioEntity(1L, "Supino Reto");

        return excercicioEntity;
    }

    public static UserEntity createUserEntity() {
        UserEntity user = new UserEntity(1L, "pablo", "21/01/1993", "75-991651422", "pabloleal7@hotmail.com", "123456", null, null, MetodoDeTreino.DIA, null);

            return user;

    }
}
