package com.example.academiaapi.repository;

import com.example.academiaapi.entity.TreinoPagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TreinoPagoRepository extends JpaRepository<TreinoPagoEntity,Long> {



}
