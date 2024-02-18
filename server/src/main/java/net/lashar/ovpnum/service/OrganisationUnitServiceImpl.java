package net.lashar.ovpnum.service;

import net.lashar.ovpnum.entity.OrganisationUnit;
import net.lashar.ovpnum.repository.OrganisationUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganisationUnitServiceImpl implements OrganisationUnitService {
    @Autowired
    private OrganisationUnitRepository organisationUnitRepository;

    @Override
    public List<OrganisationUnit> getAll() {
        return organisationUnitRepository.findAll();
    }
}
