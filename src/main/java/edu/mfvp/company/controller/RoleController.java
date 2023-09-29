package edu.mfvp.company.controller;

import edu.mfvp.company.dtos.RoleDtoRecord;
import edu.mfvp.company.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<RoleDtoRecord> create(@RequestBody RoleDtoRecord roleDtoRecord) {
        return new ResponseEntity<>(roleService.create(roleDtoRecord), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RoleDtoRecord>> findAll() {
        return ResponseEntity.ok().body(roleService.findAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity<RoleDtoRecord> findByName(@PathVariable String name) {
        return ResponseEntity.ok().body(roleService.findByName(name));
    }

    @PatchMapping("/{name}")
    public ResponseEntity<RoleDtoRecord> updateByName(@PathVariable String name, @RequestBody RoleDtoRecord roleDtoRecord) {
        return ResponseEntity.ok().body(roleService.updateByName(name, roleDtoRecord));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> delete(@PathVariable String name) {
        roleService.deleteByName(name);
        return ResponseEntity.noContent().build();
    }

}
