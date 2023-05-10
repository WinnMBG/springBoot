package com.hitema.jee.services;

import com.hitema.jee.entities.City;
import com.hitema.jee.entities.Country;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class CityServiceImplTest {

    @Autowired
    private CityService service;
    private static final Logger log = LoggerFactory.getLogger(CityServiceImpl.class);
    private static City city;

    @BeforeAll
    static void beforeAll() {
        log.trace("<<<<<Before All>>>>>");
        city = new City();
        city.setCity("Chelles");
        city.setLastUpdate(LocalDateTime.now());
        city.setId(601L);
    }
    @BeforeEach
    void setUp(){
        log.trace("<<<<<<Before Each>>>>>>");
        assertNotNull(service, "ERROR Service country not injected !");
    }

    @Test
    @Order(1)
    void create() {
        City c = new City();
        c.setCity("Vienne");
        c.setLastUpdate(LocalDateTime.now());
        Country coun = new Country();
        coun.setId(9L);
        c.setCountry(coun);
        service.create(c);
        assertNotNull(c.getId(), "ERROR");
        log.trace("Nouvelle ville crée: {}", c);
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

    @Test
    void searchByName() {
        assertNotNull(service, "Error");
        String str = "az";
        var cities = service.readByName(str);
        log.trace("Nombre de villes trouvées : {}", cities.size());
        cities.forEach(cy -> log.trace("Nouvelle city : {}", cy) );
    }

    @Test
    void findCapital() {
        assertNotNull(service, "Error");
        var cities = service.findCitiesWithCapitals();
        log.trace("Nombre de capitales trouvées : {}", cities.size());
        cities.forEach(cy -> log.trace("City : {}", cy) );
    }
}