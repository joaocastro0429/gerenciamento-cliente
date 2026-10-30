package br.com.joaocastro.gerenciamentocliente.infra.repository;

import br.com.joaocastro.gerenciamentocliente.infra.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByEmail(String email);
    Optional<Client> findByPhone(String phone);
}
