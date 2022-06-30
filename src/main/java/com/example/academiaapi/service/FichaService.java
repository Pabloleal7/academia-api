package com.example.academiaapi.service;

import com.example.academiaapi.entity.FichaEntity;
import com.example.academiaapi.repository.FichaRepository;
import com.example.academiaapi.service.exceptions.DatabaseException;
import com.example.academiaapi.service.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class FichaService {
    private final FichaRepository fichaRepository;

    public FichaService(FichaRepository fichaRepository) {
        this.fichaRepository = fichaRepository;
    }


    public Page<FichaEntity> findAllPaged(Pageable pageable) {
        return fichaRepository.findAll(pageable);
    }

    public FichaEntity findById(Long id) {
        Optional<FichaEntity> fichaEntity = fichaRepository.findById(id);
        return fichaEntity.orElseThrow(() -> new ResourceNotFoundException("Exercicio não encontrado"));
    }


    public FichaEntity insert(FichaEntity fichaEntity) {
        fichaEntity.setId(null);
        return fichaRepository.save(fichaEntity);
    }

    public FichaEntity update(Long id, FichaEntity fichaEntity) {

        Optional<FichaEntity> entity = fichaRepository.findById(id);

        entity.ifPresent(ficha -> {
            ficha.setDia(fichaEntity.getDia());
            ficha.setExercicios(fichaEntity.getExercicios());
            ficha.setOrdem(fichaEntity.getOrdem());

        });
        return fichaRepository.save(entity.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado " + id)));
    }

    public void deleteById(Long id) {
        try {
            fichaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id " + id + " não encontrado ");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integridade violada, existe entidades utilizando o exercicio");
        }
    }
    
    
}
