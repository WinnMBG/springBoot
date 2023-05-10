package com.hitema.jee.services;

import com.hitema.jee.entities.Country;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class CountryServiceImplTest {

    @Autowired
    private CountryService service;
    private static final Logger log = LoggerFactory.getLogger(CountryServiceImpl.class);
    private static Country country;
    @BeforeAll
    static void beforeAll() {
        log.trace("<<<<<Before All>>>>>");
    }
    @BeforeEach
    void setUp(){
        log.trace("<<<<<<Before Each>>>>>>");
        assertNotNull(service, "ERROR Service country not injected !");
    }
    @Test
    @Order(1)
    void create() {
        country = new Country();
        country.setCountry("Kosovo");
        country.setLastUpdate(LocalDateTime.now());
        country.setId(111L);
        assertNotNull(country, "ERROR");
        log.trace("Nouveau pays crée: {}", service.create(country));
    }

    @Test
    @Order(2)
    void read() {
        assertNotNull(service, "ERROR");
        Country c = service.read(111L);
        assertNotNull(c, "Country not Found");
        log.trace("Lecture : {}", c);
    }

    @Test
    @Order(5)
    void readAll() {
        assertNotNull(service, "Error");
        service.readAll().forEach(c -> log.trace("{}", c));
    }

    @Test
    @Order(3)
    void update() {
        assertNotNull(country, "ERROR");
        country.setCountry("Albania");
        log.trace("Pays après update: {}",service.update(country));
    }

    @Test
    @Order(4)
    void delete() {
        service.delete(111L);
        log.trace("La taille de la base est de {}", service.readAll().size());
    }
}