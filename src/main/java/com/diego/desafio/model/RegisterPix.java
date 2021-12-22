package com.diego.desafio.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.diego.desafio.enums.EnumTipoDeChave;

@Entity
@Table(name = "TB_REGISTRO_CHAVEPIX")
public class RegisterPix implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String nomeCliente;
	private String nomeBanco;
	private Long chavePix;
	private EnumTipoDeChave tipoDeChave;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public Long getChavePix() {
		return chavePix;
	}

	public void setChavePix(Long chavePix) {
		this.chavePix = chavePix;
	}

	public EnumTipoDeChave getTipoDeChave() {
		return tipoDeChave;
	}

	public void setTipoDeChave(EnumTipoDeChave tipoDeChave) {
		this.tipoDeChave = tipoDeChave;
	}

}
