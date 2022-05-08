package com.example.registercomplete.repository;

import com.example.registercomplete.model.Cliente;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ClienteRepository extends ReactiveSortingRepository<Cliente,Long> {

    @Query("select exists (select * from cliente where email=$1)")
    Mono<Boolean> findByEmail(String email);

}

