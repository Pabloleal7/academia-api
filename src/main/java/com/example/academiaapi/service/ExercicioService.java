package com.example.academiaapi.service;

import com.example.academiaapi.entity.ExercicioEntity;
import com.example.academiaapi.repository.ExercicioRepository;
import com.example.academiaapi.service.exceptions.DatabaseException;
import com.example.academiaapi.service.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExercicioService {

    private final ExercicioRepository exercicioRepository;

    public ExercicioService(ExercicioRepository exercicioRepository) {
        this.exercicioRepository = exercicioRepository;
    }

    public Page<ExercicioEntity> findAllPaged(Pageable pageable) {
        return exercicioRepository.findAll(pageable);
    }

    public ExercicioEntity findById(Long id) {
        Optional<ExercicioEntity> exercicioEntity = exercicioRepository.findById(id);
        return exercicioEntity.orElseThrow(() -> new ResourceNotFoundException("Exercicio não encontrado"));
    }


    public ExercicioEntity insert(ExercicioEntity exercicioEntity) {
        exercicioEntity.setId(null);
        return exercicioRepository.save(exercicioEntity);
    }

    public ExercicioEntity update(Long id, ExercicioEntity exercicioEntity) {

        Optional<ExercicioEntity> entity = exercicioRepository.findById(id);

        entity.ifPresent(exercicio -> exercicio.setNome(exercicioEntity.getNome()));

        return exercicioRepository.save(entity.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado " + id)));


    }

    public void deleteById(Long id) {
        try {
            exercicioRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id " + id + " não encontrado ");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integridade violada, existe entidades utilizando o exercicio");
        }
    }
}
