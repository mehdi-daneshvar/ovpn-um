package net.lashar.ovpnum.controller;

import net.lashar.ovpnum.entity.State;
import net.lashar.ovpnum.error.exception.StateNameExistsException;
import net.lashar.ovpnum.error.exception.StateNameNullException;
import net.lashar.ovpnum.model.StateModel;
import net.lashar.ovpnum.service.MessageService;
import net.lashar.ovpnum.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/state")
public class StateController {
    @Autowired
    private StateService stateService;

    @Autowired
    private MessageService messageService;

    @GetMapping(value = {"", "/"})
    public List<State> getAll() {
        return stateService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody StateModel stateModel) throws StateNameExistsException, StateNameNullException {
        if (stateModel.getName() == null) {
            throw new StateNameNullException("نام استان خالی است.");
        } else if (stateModel.getName().isEmpty()) {
            throw new StateNameNullException("نام استان خالی است.");
        } else {
            State state = new State();
            state.setName(stateModel.getName());
            stateService.addState(state);
            String message = "استان %s اضافه شد.".formatted(state.getName());
            return messageService.ok(message);
        }
    }
}
