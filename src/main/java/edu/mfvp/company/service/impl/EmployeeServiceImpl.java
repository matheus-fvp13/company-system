package edu.mfvp.company.service.impl;

import edu.mfvp.company.domain.model.Employee;
import edu.mfvp.company.domain.model.Role;
import edu.mfvp.company.domain.repository.EmployeeRepository;
import edu.mfvp.company.domain.repository.RoleRepository;
import edu.mfvp.company.dtos.EmployeeDtoRecord;
import edu.mfvp.company.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private RoleRepository roleRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, RoleRepository roleRepository) {
        this.employeeRepository = employeeRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public EmployeeDtoRecord create(EmployeeDtoRecord employeeDtoRecord) {
        if(!roleRepository.existsByName(employeeDtoRecord.roleName()))
            throw new NoSuchElementException("the role assigned to the employee does not exists.");
        Employee employee = employeeDtoRecord.toEntity();
        employee.setRole(roleRepository.findByName(employeeDtoRecord.roleName()));
        return EmployeeDtoRecord.toEmployeeDto(employeeRepository.save(employee));
    }

    @Override
    public List<EmployeeDtoRecord> findAll() {
        return employeeRepository.findAll().stream().map(EmployeeDtoRecord::toEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDtoRecord findById(Long id) {
        if(!employeeRepository.existsById(id)) throw new NoSuchElementException("There is no a client with ID " + id);
        Employee employee = employeeRepository.findById(id).get();
        return EmployeeDtoRecord.toEmployeeDto(employee);
    }

    @Override
    public EmployeeDtoRecord update(Long id, EmployeeDtoRecord employeeDtoRecord) {
        if(!roleRepository.existsByName(employeeDtoRecord.roleName()))
            throw new NoSuchElementException("the role assigned to the employee does not exists.");
        if(!employeeRepository.existsById(id))
            throw new NoSuchElementException("There is no a client with ID " + id);

        Employee employee = employeeDtoRecord.toEntity();
        employee.setId(id);
        employee.setRole(roleRepository.findByName(employeeDtoRecord.roleName()));
        return EmployeeDtoRecord.toEmployeeDto(employeeRepository.save(employee));
    }

    @Override
    public void delete(Long id) {
        if(!employeeRepository.existsById(id)) throw new NoSuchElementException("There is no a client with ID " + id);
        employeeRepository.deleteById(id);
    }
}
