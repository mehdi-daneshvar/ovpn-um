package net.lashar.ovpnum.repository;

import net.lashar.ovpnum.entity.OrganisationUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganisationUnitRepository extends JpaRepository<OrganisationUnit, Long> {
    Optional<OrganisationUnit> findByName(String name);
}
