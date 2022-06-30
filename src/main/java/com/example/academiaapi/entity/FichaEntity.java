package com.example.academiaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FichaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private DayOfWeek dia;

    private Integer ordem;


    @ManyToMany(fetch =  FetchType.EAGER)
    private List<ExercicioInfoEntity> exercicios;
}
