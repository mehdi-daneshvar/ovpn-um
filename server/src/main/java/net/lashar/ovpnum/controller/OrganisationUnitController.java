package net.lashar.ovpnum.controller;

import net.lashar.ovpnum.entity.City;
import net.lashar.ovpnum.entity.OrganisationUnit;
import net.lashar.ovpnum.error.exception.CityNotExistsException;
import net.lashar.ovpnum.error.exception.OrganisationUnitNameExistsException;
import net.lashar.ovpnum.error.exception.OrganisationUnitNameNullException;
import net.lashar.ovpnum.error.exception.OrganisationUnitParentNotExistsException;
import net.lashar.ovpnum.model.OrganisationUnitModel;
import net.lashar.ovpnum.service.CityService;
import net.lashar.ovpnum.service.MessageService;
import net.lashar.ovpnum.service.OrganisationUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/organisation-unit")
public class OrganisationUnitController {
    @Autowired
    private OrganisationUnitService organisationUnitService;
    @Autowired
    private CityService cityService;
    @Autowired
    private MessageService messageService;

    @GetMapping(value = {"", "/"})
    public List<OrganisationUnit> getAll() {
        return organisationUnitService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add
            (@RequestBody OrganisationUnitModel organisationUnitModel)
            throws
            OrganisationUnitNameNullException,
            CityNotExistsException,
            OrganisationUnitParentNotExistsException,
            OrganisationUnitNameExistsException {
        if (organisationUnitModel.getName() == null) {
            throw new OrganisationUnitNameNullException("نام واحد سازمانی خالی است.");
        } else if (organisationUnitModel.getName().isEmpty()) {
            throw new OrganisationUnitNameNullException("نام واحد سازمانی خالی است.");
        } else {
            OrganisationUnit organisationUnit = new OrganisationUnit();
            organisationUnit.setName(organisationUnitModel.getName());
            City city = cityService.getCity(organisationUnitModel.getCity()).orElse(null);
            if (city == null) {
                throw new CityNotExistsException(
                        "کد شهرستان %d پیدا نشد.".formatted(organisationUnitModel.getCity())
                );
            }
            organisationUnit.setCity(city);
            if (organisationUnitModel.getParent() != null) {
                OrganisationUnit parent = organisationUnitService.getParent(organisationUnitModel.getParent()).orElse(null);
                if (parent == null) {
                    throw new OrganisationUnitParentNotExistsException(
                            "واحد سازمانی %s زیرمجموعه هیچ سازمانی قرار نگرفت.".formatted(organisationUnitModel.getName())
                    );
                } else organisationUnit.setParent(parent);
            }
            organisationUnitService.addOrganisationUnit(organisationUnit);
            String message = "واحد سازمانی %s اضافه شد.".formatted(organisationUnitModel.getName());
            return messageService.ok(message);
        }
    }
}
