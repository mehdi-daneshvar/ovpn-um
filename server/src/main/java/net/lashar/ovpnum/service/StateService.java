package net.lashar.ovpnum.service;

import net.lashar.ovpnum.entity.State;
import net.lashar.ovpnum.error.exception.StateNameExistsException;

import java.util.List;

public interface StateService {
    List<State> getAll();

    void addState(State state) throws StateNameExistsException;
}
