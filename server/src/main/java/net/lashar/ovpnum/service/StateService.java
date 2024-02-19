package net.lashar.ovpnum.service;

import net.lashar.ovpnum.entity.State;
import net.lashar.ovpnum.error.exception.StateNameExistsException;

import java.util.List;
import java.util.Optional;

public interface StateService {
    List<State> getAll();

    void addState(State state) throws StateNameExistsException;

    Optional<State> getState(Long id);
}
