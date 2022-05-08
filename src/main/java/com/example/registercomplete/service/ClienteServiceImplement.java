package com.example.registercomplete.service;

import com.example.registercomplete.model.Cliente;
import com.example.registercomplete.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Subscription;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.function.Consumer;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class ClienteServiceImplement implements ClienteService {
    private final ClienteRepository clienteRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Mono<Boolean> register(@Valid  Cliente cliente) {

        return this.clienteRepository.findByEmail(cliente.getEmail()).flatMap((Function<Boolean, Mono<Boolean>>) value -> {
            cliente.setPassword(bCryptPasswordEncoder.encode(cliente.getPassword()));
            Mono<Cliente> save = clienteRepository.save(cliente);
        });


    }

}

