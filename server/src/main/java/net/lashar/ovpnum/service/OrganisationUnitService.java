package net.lashar.ovpnum.service;

import net.lashar.ovpnum.entity.OrganisationUnit;
import net.lashar.ovpnum.error.exception.OrganisationUnitNameExistsException;

import java.util.List;
import java.util.Optional;

public interface OrganisationUnitService {
    List<OrganisationUnit> getAll();

    Optional<OrganisationUnit> getParent(Long id);

    void addOrganisationUnit(OrganisationUnit organisationUnit) throws OrganisationUnitNameExistsException;
}
