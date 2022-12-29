package br.com.petz.clientepet.cliente.application.api;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ClienteResponse {
	private UUID idCliente;
	private String nomeCompleto;
	private String email;
	private String celular;
	private String telefone;

}
