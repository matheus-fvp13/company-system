package edu.mfvp.company.controller;

import edu.mfvp.company.dtos.EmployeeDtoRecord;
import edu.mfvp.company.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeDtoRecord> create(@RequestBody EmployeeDtoRecord employeeDtoRecord) {
        return  new ResponseEntity<>(employeeService.create(employeeDtoRecord), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDtoRecord>> findAll() {
        return ResponseEntity.ok().body(employeeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDtoRecord> findById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EmployeeDtoRecord> update(@PathVariable Long id, @RequestBody EmployeeDtoRecord employeeDtoRecord) {
        return ResponseEntity.ok(employeeService.update(id, employeeDtoRecord));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
