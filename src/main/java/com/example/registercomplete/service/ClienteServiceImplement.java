package com.example.registercomplete.service;

import com.example.registercomplete.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteServiceImplement implements ClienteService {
    private final ClienteRepository clienteRepository;

}
