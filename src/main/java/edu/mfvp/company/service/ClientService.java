package edu.mfvp.company.service;

import edu.mfvp.company.dtos.ClientDtoRecord;

import java.util.List;

public interface ClientService {

    ClientDtoRecord create(ClientDtoRecord clientDtoRecord);
    List<ClientDtoRecord> findAll();
    ClientDtoRecord findById(Long id);
    ClientDtoRecord update(Long id, ClientDtoRecord clientDtoRecord);
    void delete(Long id);

}
