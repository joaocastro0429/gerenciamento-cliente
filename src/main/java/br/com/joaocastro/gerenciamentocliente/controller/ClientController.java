package br.com.joaocastro.gerenciamentocliente.controller;

import br.com.joaocastro.gerenciamentocliente.Service.ClientService;
import br.com.joaocastro.gerenciamentocliente.dto.ClientDto;
import br.com.joaocastro.gerenciamentocliente.infra.entity.Client;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> findAll(){
        return clientService.findAll();
    }

    @PostMapping
    public Client createClient(@RequestBody @Valid ClientDto clientDto){
        return clientService.createClient(clientDto);
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable("id") Long id){
        return clientService.findById(id);
    }

    @GetMapping("/email/{email}")
    public Client findByEmail(@PathVariable("email") String email){
        return clientService.findByEmail(email);
    }

    @GetMapping("/phone/{phone}")
    public Client findByPhone(@PathVariable("phone") String phone){
        return clientService.findByPhone(phone);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable("id") Long id, @RequestBody @Valid ClientDto clientDto){
        return clientService.updateClient(id, clientDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable("id") Long id) {
        clientService.deletaClient(id);
    }
}
