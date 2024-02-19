package net.lashar.ovpnum.service;

import net.lashar.ovpnum.entity.City;
import net.lashar.ovpnum.error.exception.CityNameExistsException;

import java.util.List;
import java.util.Optional;

public interface CityService {
    List<City> getAll();

    void addCity(City city) throws CityNameExistsException;

    Optional<City> getCity(Long id);
}
