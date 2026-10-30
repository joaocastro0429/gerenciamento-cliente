package br.com.joaocastro.gerenciamentocliente.Service;

import br.com.joaocastro.gerenciamentocliente.infra.entity.Client;
import br.com.joaocastro.gerenciamentocliente.infra.repository.ClientRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    @Test
    @DisplayName("Deve retornar um cliente quando o e-mail existir")
    public void deveBuscarClientePorEmailComSucesso() {
        // Arrange
        String emailBusca = "joao@email.com";
        Client clienteFake = new Client();
        clienteFake.setName("João Castro");
        clienteFake.setEmail(emailBusca);

        when(clientRepository.findByEmail(emailBusca)).thenReturn(Optional.of(clienteFake));

        // Act
        Client resultado = clientService.findByEmail(emailBusca);

        // Assert
        assertNotNull(resultado);
        assertEquals("João Castro", resultado.getName());
        assertEquals(emailBusca, resultado.getEmail());
        
        verify(clientRepository, times(1)).findByEmail(emailBusca);
    }

    @Test
    @DisplayName("Deve lançar exceção 404 quando o e-mail não existir")
    public void deveLancarErroQuandoEmailNaoExistir() {
        // Arrange
        String emailInexistente = "naoexisto@email.com";
        when(clientRepository.findByEmail(emailInexistente)).thenReturn(Optional.empty());

        // Act & Assert
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            clientService.findByEmail(emailInexistente);
        });

        assertEquals(404, exception.getStatusCode().value());
    }
}
