package net.lashar.ovpnum.service;

import net.lashar.ovpnum.entity.State;
import net.lashar.ovpnum.error.exception.StateNameExistsException;
import net.lashar.ovpnum.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImpl implements StateService{
    @Autowired
    private StateRepository stateRepository;

    @Override
    public List<State> getAll() {
        return stateRepository.findAll();
    }

    @Override
    public void addState(State state) throws StateNameExistsException{
        State existingState =
                stateRepository.findByName(state.getName())
                        .orElse(null);
        if (existingState == null) {
            stateRepository.save(state);
        } else
            throw new StateNameExistsException(
                    "استان %s از قبل وجود دارد.".formatted(state.getName())
            );
    }
}
