package edu.mfvp.company.service.impl;

import edu.mfvp.company.domain.model.Role;
import edu.mfvp.company.domain.repository.RoleRepository;
import edu.mfvp.company.dtos.RoleDtoRecord;
import edu.mfvp.company.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleDtoRecord create(RoleDtoRecord roleDtoRecord) {
        Role role = roleRepository.save(roleDtoRecord.toEntity());
        return RoleDtoRecord.toDto(role);
    }

    @Override
    public List<RoleDtoRecord> findAll() {
        return roleRepository.findAll().stream().map(RoleDtoRecord::toDto).collect(Collectors.toList());
    }

    @Override
    public RoleDtoRecord findByName(String name) {
        if(!roleRepository.existsByName(name)) throw new NoSuchElementException("There is no a role with name " + name);
        return RoleDtoRecord.toDto(roleRepository.findByName(name));
    }

    @Override
    public RoleDtoRecord updateByName(String name, RoleDtoRecord roleDtoRecord) {
        if(!roleRepository.existsByName(name)) throw new NoSuchElementException("There is no a role with name " + name);
        Role role = roleRepository.findByName(name);
        Role role2 = roleDtoRecord.toEntity();
        role2.setId(role.getId());
        return RoleDtoRecord.toDto(roleRepository.save(role2));
    }

    @Override
    public void deleteByName(String name) {
        if(!roleRepository.existsByName(name)) throw new NoSuchElementException("There is no a role with name " + name);
        roleRepository.delete(roleRepository.findByName(name));
    }

}
