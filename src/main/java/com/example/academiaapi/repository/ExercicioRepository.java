package com.example.academiaapi.repository;

import com.example.academiaapi.entity.ExercicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercicioRepository extends JpaRepository<ExercicioEntity,Long> {
}
