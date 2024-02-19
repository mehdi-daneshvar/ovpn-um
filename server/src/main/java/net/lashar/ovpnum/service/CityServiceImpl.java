package net.lashar.ovpnum.service;

import net.lashar.ovpnum.entity.City;
import net.lashar.ovpnum.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{
    @Autowired
    private CityRepository cityRepository;
    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }
}
