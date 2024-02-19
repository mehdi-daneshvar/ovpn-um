package net.lashar.ovpnum.service;

import net.lashar.ovpnum.entity.OrganisationUnit;
import net.lashar.ovpnum.error.exception.OrganisationUnitNameExistsException;
import net.lashar.ovpnum.repository.OrganisationUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganisationUnitServiceImpl implements OrganisationUnitService {
    @Autowired
    private OrganisationUnitRepository organisationUnitRepository;

    @Override
    public List<OrganisationUnit> getAll() {
        return organisationUnitRepository.findAll();
    }

    @Override
    public Optional<OrganisationUnit> getParent(Long id) {
        return organisationUnitRepository.findById(id);
    }

    @Override
    public void addOrganisationUnit(OrganisationUnit organisationUnit) throws OrganisationUnitNameExistsException {
        OrganisationUnit existingOrganisationUnit =
                organisationUnitRepository.findByName(organisationUnit.getName())
                        .orElse(null);
        if (existingOrganisationUnit == null) {
            organisationUnitRepository.save(organisationUnit);
        } else
            throw new OrganisationUnitNameExistsException(
                    "واحد سازمانی %s از قبل وجود دارد.".formatted(existingOrganisationUnit.getName())
            );
    }
}
