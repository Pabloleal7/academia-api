package com.example.academiaapi.repository;

import com.example.academiaapi.entity.ExercicioInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercicioInfoRepository extends JpaRepository<ExercicioInfoEntity,Long> {
}
