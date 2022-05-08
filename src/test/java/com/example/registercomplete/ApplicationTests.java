package com.example.registercomplete;

import com.example.registercomplete.model.Cliente;
import com.example.registercomplete.model.ClienteRole;
import com.example.registercomplete.service.ClienteServiceImplement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private ClienteServiceImplement serviceImplement;

    @Test
    void contextLoads() {
        var cliente = new Cliente(
                "Jose", "Marques", "jose123", "joseMarques@gmail.com", ClienteRole.USER.name()
        );

        serviceImplement.register(cliente).subscribe(value -> {
            Assertions.assertEquals(true,value);
        });
    }

}
