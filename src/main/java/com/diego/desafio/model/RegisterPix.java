package com.diego.desafio.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.diego.desafio.enums.EnumTipoDeChave;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_registro_chavepix")
public class RegisterPix implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O campo não pode estar em branco")
	private String nomeCliente;

	@NotBlank(message = "O campo não pode estar em branco")
	private String nomeBanco;

	@NotBlank(message = "O campo não pode estar em branco")
	private Long chavePix;

	@NotBlank(message = "O campo não pode estar em branco")
	private EnumTipoDeChave tipoDeChave;

}
