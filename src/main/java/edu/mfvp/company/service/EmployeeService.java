package edu.mfvp.company.service;

import edu.mfvp.company.dtos.EmployeeDtoRecord;

import java.util.List;

public interface EmployeeService {

    EmployeeDtoRecord create(EmployeeDtoRecord employeeDtoRecord);
    List<EmployeeDtoRecord> findAll();
    EmployeeDtoRecord findById(Long id);
    EmployeeDtoRecord update(Long id, EmployeeDtoRecord employeeDtoRecord);
    void delete(Long id);

}
