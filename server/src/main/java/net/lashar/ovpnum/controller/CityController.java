package net.lashar.ovpnum.controller;

import net.lashar.ovpnum.entity.City;
import net.lashar.ovpnum.entity.State;
import net.lashar.ovpnum.error.exception.CityNameExistsException;
import net.lashar.ovpnum.error.exception.CityNameNullException;
import net.lashar.ovpnum.error.exception.StateNotExistsException;
import net.lashar.ovpnum.model.CityModel;
import net.lashar.ovpnum.service.CityService;
import net.lashar.ovpnum.service.MessageService;
import net.lashar.ovpnum.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @Autowired
    private StateService stateService;

    @Autowired
    private MessageService messageService;

    @GetMapping(value = {"", "/"})
    public List<City> getAll() {
        return cityService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody CityModel cityModel) throws CityNameExistsException, CityNameNullException, StateNotExistsException {
        if (cityModel.getName() == null) {
            throw new CityNameNullException("نام شهرستان خالی است.");
        } else if (cityModel.getName().isEmpty()) {
            throw new CityNameNullException("نام شهرستان خالی است.");
        } else {
            City city = new City();
            city.setName(cityModel.getName());
            State state = stateService.getState(cityModel.getState()).orElse(null);
            if (state == null) {
                throw new StateNotExistsException(
                        "کداستان %d پیدا نشد.".formatted(cityModel.getState())
                );
            } else city.setState(state);
            cityService.addCity(city);
            String message = "شهرستان %s اضافه شد.".formatted(city.getName());
            return messageService.ok(message);
        }
    }
}
