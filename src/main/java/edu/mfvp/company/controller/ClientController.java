package edu.mfvp.company.controller;

import edu.mfvp.company.dtos.ClientDtoRecord;
import edu.mfvp.company.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientDtoRecord> create(@RequestBody ClientDtoRecord clientDtoRecord) {
        return  new ResponseEntity<>(clientService.create(clientDtoRecord), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClientDtoRecord>> findAll() {
        return ResponseEntity.ok().body(clientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDtoRecord> findById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ClientDtoRecord> update(@PathVariable Long id, @RequestBody ClientDtoRecord clientDtoRecord) {
        return ResponseEntity.ok(clientService.update(id, clientDtoRecord));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
