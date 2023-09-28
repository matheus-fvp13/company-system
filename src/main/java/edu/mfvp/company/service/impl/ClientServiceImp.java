package edu.mfvp.company.service.impl;

import edu.mfvp.company.domain.model.Client;
import edu.mfvp.company.domain.repository.ClientRepository;
import edu.mfvp.company.dtos.ClientDtoRecord;
import edu.mfvp.company.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImp implements ClientService {

    private ClientRepository clientRepository;

    public ClientServiceImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDtoRecord create(ClientDtoRecord clientDtoRecord) {
        Client client = clientDtoRecord.toClient();
        return ClientDtoRecord.toClientDto(clientRepository.save(client));
    }

    @Override
    public List<ClientDtoRecord> findAll() {
        return null;
    }

    @Override
    public ClientDtoRecord findById(Long id) {
        return null;
    }

    @Override
    public ClientDtoRecord update(Long id, ClientDtoRecord clientDtoRecord) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
