package com.hitema.jee.services;

import com.hitema.jee.entities.City;
import com.hitema.jee.entities.Country;
import com.hitema.jee.repositories.CityRepository;
import com.hitema.jee.repositories.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CityServiceImpl implements CityService{

    private CityRepository repository;

    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }

    private static final Logger log = LoggerFactory.getLogger(CityServiceImpl.class);
    @Override
    public City create(City city) {
        return repository.save(city);
    }

    @Override
    public City read(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<City> readAll() {
        return repository.findAll();
    }

    @Override
    public City update(City city) {
        City cityDB = repository.findById(city.getId()).get();
        cityDB.setCity(city.getCity());
        cityDB.setCountry(city.getCountry());
        cityDB.setLastUpdate(city.getLastUpdate());
        return repository.save(cityDB);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
