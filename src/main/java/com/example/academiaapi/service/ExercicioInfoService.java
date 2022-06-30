package com.example.academiaapi.service;

import com.example.academiaapi.entity.ExercicioInfoEntity;

import com.example.academiaapi.repository.ExercicioInfoRepository;

import com.example.academiaapi.service.exceptions.DatabaseException;
import com.example.academiaapi.service.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class ExercicioInfoService {

    private final ExercicioInfoRepository exercicioInfoRepository;

    public ExercicioInfoService(ExercicioInfoRepository exercicioInfoRepository) {
        this.exercicioInfoRepository = exercicioInfoRepository;
    }


    public Page<ExercicioInfoEntity> findAllPaged(Pageable pageable) {
        return exercicioInfoRepository.findAll(pageable);
    }

    public ExercicioInfoEntity findById(Long id) {
        Optional<ExercicioInfoEntity> exercicioInfoEntity = exercicioInfoRepository.findById(id);
        return exercicioInfoEntity.orElseThrow(() -> new ResourceNotFoundException("Exercicio não encontrado"));
    }


    public ExercicioInfoEntity insert(ExercicioInfoEntity exercicioInfoEntity) {
        exercicioInfoEntity.setId(null);
        return exercicioInfoRepository.save(exercicioInfoEntity);
    }

    public ExercicioInfoEntity update(Long id, ExercicioInfoEntity exercicioInfoEntity) {

        Optional<ExercicioInfoEntity> entity = exercicioInfoRepository.findById(id);

        entity.ifPresent(exercicio -> {
            exercicio.setExercicioEntity(exercicioInfoEntity.getExercicioEntity());
            exercicio.setRepeticoes(exercicioInfoEntity.getRepeticoes());
            exercicio.setSeries(exercicioInfoEntity.getSeries());
            exercicio.setDescricao(exercicioInfoEntity.getDescricao());
        });
        return exercicioInfoRepository.save(entity.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado " + id)));
    }

    public void deleteById(Long id) {
        try {
            exercicioInfoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id " + id + " não encontrado ");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integridade violada, existe entidades utilizando o exercicio");
        }
    }
}
