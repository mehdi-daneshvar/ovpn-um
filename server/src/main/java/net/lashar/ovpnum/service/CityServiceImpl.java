package net.lashar.ovpnum.service;

import net.lashar.ovpnum.entity.City;
import net.lashar.ovpnum.error.exception.CityNameExistsException;
import net.lashar.ovpnum.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public void addCity(City city) throws CityNameExistsException {
        City existingCity =
                cityRepository.findByName(city.getName())
                        .orElse(null);
        if (existingCity == null) {
            cityRepository.save(city);
        } else
            throw new CityNameExistsException(
                    "شهرستان %s از قبل وجود دارد.".formatted(city.getName())
            );
    }
}
