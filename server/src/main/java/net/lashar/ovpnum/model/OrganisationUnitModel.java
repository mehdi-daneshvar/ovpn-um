package net.lashar.ovpnum.model;

import lombok.Data;

@Data
public class OrganisationUnitModel {
    private String name;
    private Long city;
    private Long parent;
}
