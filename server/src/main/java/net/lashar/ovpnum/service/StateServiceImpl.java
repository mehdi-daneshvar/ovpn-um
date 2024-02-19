package net.lashar.ovpnum.service;

import net.lashar.ovpnum.entity.State;
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
}
