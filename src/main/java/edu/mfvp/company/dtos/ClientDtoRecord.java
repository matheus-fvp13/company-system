package edu.mfvp.company.dtos;

import edu.mfvp.company.domain.model.Address;
import edu.mfvp.company.domain.model.Client;

import java.time.LocalDate;

public record ClientDtoRecord(String name, String cpf, String phone, String email, LocalDate birthDate, Address address) {

    public Client toClient() {
        Client client = new Client();
        client.setName(this.name());
        client.setCpf(this.cpf());
        client.setPhone(this.phone());
        client.setEmail(this.email());
        client.setBirthDate(this.birthDate());
        client.setAddress(address);
        return client;
    }

    public static ClientDtoRecord toClientDto(Client client) {
        return new ClientDtoRecord(client.getName(), client.getCpf(), client.getPhone(), client.getEmail(), client.getBirthDate(), client.getAddress());
    }

}
