package net.lashar.ovpnum.controller;

import net.lashar.ovpnum.entity.OrganisationUnit;
import net.lashar.ovpnum.service.OrganisationUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/organisation-unit")
public class OrganisationUnitController {
    @Autowired
    private OrganisationUnitService organisationUnitService;

    @GetMapping(value = {"", "/"})
    public List<OrganisationUnit> getAll() {
        return organisationUnitService.getAll();
    }
}
