package net.lashar.ovpnum.controller;

import net.lashar.ovpnum.entity.State;
import net.lashar.ovpnum.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/state")
public class StateController {
    @Autowired
    private StateService stateService;

    @GetMapping(value = {"", "/"})
    public List<State> getAll() {
        return stateService.getAll();
    }
}
