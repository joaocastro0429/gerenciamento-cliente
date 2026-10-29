package br.com.joaocastro.gerenciamentocliente.Service;


import br.com.joaocastro.gerenciamentocliente.infra.entity.Client;
import br.com.joaocastro.gerenciamentocliente.infra.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> client(){
        return clientRepository.findAll();
    }
}
