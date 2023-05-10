package com.hitema.jee.repositories;

import com.hitema.jee.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> readCitiesByCityContainingIgnoreCase(String str);
    List<City> readCitiesByCapitalTrue();
}
