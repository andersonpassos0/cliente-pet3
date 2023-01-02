package br.com.petz.clientepet.pet.application.api;

import java.time.LocalDate;

import br.com.petz.clientepet.pet.domain.Porte;
import br.com.petz.clientepet.pet.domain.TipoPet;
import br.com.petz.clientepet.pet.domain.sexoPet;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PetRequest {
	@NotBlank
	private String nomePet;
	private Porte porte;
	@NotNull
	private TipoPet tipo;
	private String microchip;
	@NotBlank
	private String raca;
	@NotNull
	private sexoPet sexo;
	private String pelagemCor;
	@NotNull
	private LocalDate dataNascimento;
	private String rga;
	private Integer peso;
}
