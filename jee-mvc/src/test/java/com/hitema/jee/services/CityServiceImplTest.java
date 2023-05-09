package com.hitema.jee.services;

import com.hitema.jee.entities.City;
import com.hitema.jee.entities.Country;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CityServiceImplTest {

    @Autowired
    private CityServiceImpl service;
    private static final Logger log = LoggerFactory.getLogger(CityServiceImpl.class);
    private static City city;

    @BeforeAll
    static void beforeAll() {
        log.trace("<<<<<Before All>>>>>");
        city = new City();
        city.setCity("Chelles");
        city.setLastUpdate(LocalDateTime.now());
    }
    @BeforeEach
    void setUp(){
        log.trace("<<<<<<Before Each>>>>>>");
        assertNotNull(service, "ERROR Service country not injected !");
    }

    @Test
    @Order(1)
    void create() {
        city = new City();
        city.setCity("Riga");
        city.setLastUpdate(LocalDateTime.now());
        city.setId(601L);
        assertNotNull(city, "ERROR");
        log.trace("Nouvelle ville crée: {}", service.create(city));
    }

    @Test
    @Order(2)
    void read() {
        assertNotNull(service, "ERROR");
        City c = service.read(601L);
        assertNotNull(c, "City not FOund");
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
        assertNotNull(city, "ERROR");
        city.setCity("Vilnius");
        log.trace("VIlle après update: {}",service.update(city));
    }

    @Test
    @Order(4)
    void delete() {
        service.delete(601L);
        log.trace("La taille de la base est de {}", service.readAll().size());
    }
}