package edu.mfvp.company.controller;

import edu.mfvp.company.dtos.ClientDtoRecord;
import edu.mfvp.company.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
