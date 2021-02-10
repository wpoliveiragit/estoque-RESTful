package br.com.wellington.estoque.models.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class ProdutoDTO {

	@NotBlank(message = "O campo nome e obrigatorio.")
	@Column(name = "nome")
	private String nome;

	@NotBlank(message = "O campo nome e obrigatorio.")
	@Column(name = "valor")
	private BigDecimal valor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
