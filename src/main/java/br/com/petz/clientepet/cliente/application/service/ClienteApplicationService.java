package br.com.petz.clientepet.cliente.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.petz.clientepet.cliente.application.api.ClienteAlteracaoRequest;
import br.com.petz.clientepet.cliente.application.api.ClienteDetalhadoResponse;
import br.com.petz.clientepet.cliente.application.api.ClienteListResponse;
import br.com.petz.clientepet.cliente.application.api.ClienteRequest;
import br.com.petz.clientepet.cliente.application.api.ClienteResponse;
import br.com.petz.clientepet.cliente.application.repository.ClienteRepository;
import br.com.petz.clientepet.cliente.domain.Cliente;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {

	private final ClienteRepository clienteRepository;

	@Override
	public ClienteResponse criaCliente(ClienteRequest clienteRequest) {
		log.info("[start] ClienteApplicationService - criaCliente");
		Cliente cliente = clienteRepository.salva(new Cliente(clienteRequest));
		log.info("[finish] ClienteApplicationService - criaCliente");
		return ClienteResponse.builder()
				.idCliente(cliente.getIdCliente())
				.build();
	}

	@Override
	public List<ClienteListResponse> buscaTodosClientes() {
		log.info("[start] ClienteApplicationService - buscaTodosClientes");
		List<Cliente> clientes = clienteRepository.buscaTodosClientes();
		log.info("[finish] ClienteApplicationService - buscaTodosClientes");
		return ClienteListResponse.converte(clientes);
	}

	@Override
	public ClienteDetalhadoResponse buscaClienteAtravesId(UUID idCliente) {
		log.info("[start] ClienteApplicationService - buscaClienteAtravesId");
		Cliente cliente = clienteRepository.buscaClientAtravesId(idCliente);
		log.info("[finish] ClienteApplicationService - buscaClienteAtravesId");
		return new ClienteDetalhadoResponse (cliente);
	}

	@Override
	public void deletaClienteAtravesId(UUID idCliente) {
		log.info("[start] ClienteApplicationService - deletaClienteAtravesId");
		Cliente cliente = clienteRepository.buscaClientAtravesId(idCliente);
		clienteRepository.deletaCliente(cliente);
		log.info("[finish] ClienteApplicationService - deletaClienteAtravesId");
	}

	@Override
	public void patchAlteraCliente(UUID idCliente, @Valid ClienteAlteracaoRequest clienteAlteracaoRequest) {
		log.info("[start] ClienteApplicationService - patchAlteraCliente");
		Cliente cliente = clienteRepository.buscaClientAtravesId(idCliente);
		clienteRepository.altera(cliente);
		log.info("[finish] ClienteApplicationService - patchAlteraCliente");
	}
}
