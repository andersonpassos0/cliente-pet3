package br.com.petz.clientepet.cliente.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.petz.clientepet.cliente.domain.Cliente;

public interface clienteSpringDataJPARepository extends JpaRepository<Cliente, UUID>{

}
