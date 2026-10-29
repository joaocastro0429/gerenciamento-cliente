package br.com.joaocastro.gerenciamentocliente.infra.repository;

import br.com.joaocastro.gerenciamentocliente.infra.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
