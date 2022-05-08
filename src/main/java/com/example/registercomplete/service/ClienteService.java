package com.example.registercomplete.service;

import com.example.registercomplete.model.Cliente;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetailsService;
import reactor.core.publisher.Mono;

public interface ClienteService {
    Mono<Boolean> register(Cliente cliente);

}
