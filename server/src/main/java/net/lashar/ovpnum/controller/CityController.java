package net.lashar.ovpnum.controller;

import net.lashar.ovpnum.entity.City;
import net.lashar.ovpnum.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/city")
public class CityController {
    @Autowired
    private CityService cityService;
    @GetMapping(value = {"", "/"})
    public List<City> getAll() {
        return cityService.getAll();
    }
}
