package com.hitema.jee.services;

import com.hitema.jee.entities.City;
import com.hitema.jee.entities.Country;

import java.util.List;

public interface CityService {

    City create(City city);

    City read(Long id);

    List<City> readAll();

    City update(City city);

    void delete(Long id);

}
