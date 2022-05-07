package com.example.registercomplete.repository;

import com.example.registercomplete.model.Cliente;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends ReactiveSortingRepository<Cliente,Long> {
}
