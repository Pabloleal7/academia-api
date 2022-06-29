package com.example.academiaapi.repository;

import com.example.academiaapi.entity.FichaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichaRepository extends JpaRepository<FichaEntity,Long> {
}
