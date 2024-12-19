package com.example.comanda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.comanda.model.Comanda;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Long> {
    
}
