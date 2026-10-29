package br.com.joaocastro.gerenciamentocliente.controller;

import br.com.joaocastro.gerenciamentocliente.Service.ClientService;
import br.com.joaocastro.gerenciamentocliente.infra.entity.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private  final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
     @GetMapping
    public List<Client> findAll(){
        return clientService.findAll();
    }
}
