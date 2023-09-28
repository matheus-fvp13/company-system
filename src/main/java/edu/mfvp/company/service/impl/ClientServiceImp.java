package edu.mfvp.company.service.impl;

import edu.mfvp.company.domain.model.Client;
import edu.mfvp.company.domain.repository.ClientRepository;
import edu.mfvp.company.dtos.ClientDtoRecord;
import edu.mfvp.company.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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
        return clientRepository.findAll().stream().map(ClientDtoRecord::toClientDto).collect(Collectors.toList());
    }

    @Override
    public ClientDtoRecord findById(Long id) {
        if(!clientRepository.existsById(id)) throw new NoSuchElementException("There is no a client with ID " + id);
        Client client = clientRepository.findById(id).get();
        return ClientDtoRecord.toClientDto(client);
    }

    @Override
    public ClientDtoRecord update(Long id, ClientDtoRecord clientDtoRecord) {
        if(!clientRepository.existsById(id)) throw new NoSuchElementException("There is no a client with ID " + id);

        Client client = clientDtoRecord.toClient();
        client.setId(id);
        return ClientDtoRecord.toClientDto(clientRepository.save(client));
    }

    @Override
    public void delete(Long id) {
        if(!clientRepository.existsById(id)) throw new NoSuchElementException("There is no a client with ID " + id);
        clientRepository.deleteById(id);
    }
}
