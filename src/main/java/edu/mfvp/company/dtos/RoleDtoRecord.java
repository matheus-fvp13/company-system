package edu.mfvp.company.dtos;

import edu.mfvp.company.domain.model.Role;

public record RoleDtoRecord(String name) {

    public Role toEntity() {
        Role role = new Role();
        role.setName(this.name());
        return role;
    }

    public static RoleDtoRecord toDto(Role role) {
        return new RoleDtoRecord(role.getName());
    }

}
