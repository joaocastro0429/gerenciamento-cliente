package br.com.joaocastro.gerenciamentocliente.controller;

import br.com.joaocastro.gerenciamentocliente.Service.ClientService;
import br.com.joaocastro.gerenciamentocliente.infra.entity.Client;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Client createClient(@RequestBody Client client){
        return clientService.createClient(client);

    }

    @GetMapping("/{id}")
    public Client findById(@RequestParam("id") Long id){
        return clientService.findById(id);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable("id") Long id, @RequestBody Client client){
        return clientService.updateClient(id, client);
    }

@DeleteMapping("/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void deletaClient(@PathVariable("id") Long id) {
    clientService.deletaClient(id);
}


}
