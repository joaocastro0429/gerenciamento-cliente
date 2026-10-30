package br.com.joaocastro.gerenciamentocliente.Service;


import br.com.joaocastro.gerenciamentocliente.infra.entity.Client;
import br.com.joaocastro.gerenciamentocliente.infra.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Client createClient(Client client){
        return clientRepository.save(client);
    }

    public Client findById(Long id){
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o id: " + id));

    }


    public Client updateClient(Long id, Client dados) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o id: " + id));

        client.setName(dados.getName());
        client.setEmail(dados.getEmail());
        client.setPhone(dados.getPhone());
        client.setAddress(dados.getAddress());

        return clientRepository.save(client);

    }

    public void deletaClient(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Venda não encontrada"));

        clientRepository.delete(client);
    }


}
