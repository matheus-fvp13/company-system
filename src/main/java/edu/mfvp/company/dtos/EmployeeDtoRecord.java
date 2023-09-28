package edu.mfvp.company.dtos;

import edu.mfvp.company.domain.model.Address;
import edu.mfvp.company.domain.model.Employee;

import java.time.LocalDate;

public record EmployeeDtoRecord(String name, String cpf, String phone, String email, LocalDate birthDate,
                                Address address, LocalDate hireDate, LocalDate terminationDate) {

    public Employee toEntity() {
        Employee employee = new Employee();
        employee.setName(this.name());
        employee.setCpf(this.cpf());
        employee.setPhone(this.phone());
        employee.setEmail(this.email());
        employee.setBirthDate(this.birthDate());
        employee.setAddress(this.address());
        employee.setHireDate(this.hireDate());
        employee.setTerminationDate(this.terminationDate());
        return employee;
    }

    public static EmployeeDtoRecord toEmployeeDto(Employee employee) {
        return new EmployeeDtoRecord(employee.getName(), employee.getCpf(), employee.getPhone(),
                employee.getEmail(), employee.getBirthDate(), employee.getAddress(), employee.getHireDate(), employee.getTerminationDate());
    }

}
