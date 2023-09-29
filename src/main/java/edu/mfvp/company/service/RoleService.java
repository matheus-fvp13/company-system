package edu.mfvp.company.service;

import edu.mfvp.company.dtos.RoleDtoRecord;

import java.util.List;

public interface RoleService {

    RoleDtoRecord create(RoleDtoRecord roleDtoRecord);
    List<RoleDtoRecord> findAll();
    RoleDtoRecord findByName(String name);
    RoleDtoRecord updateByName(String name, RoleDtoRecord roleDtoRecord);
    void deleteByName(String name);

}
