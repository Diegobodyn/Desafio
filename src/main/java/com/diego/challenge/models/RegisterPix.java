package com.diego.challenge.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.diego.challenge.enums.EnumTypeOfKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_record_key_pix")
public class RegisterPix implements Serializable {

	private static final long serialVersionUID = 6344370382319666676L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String clientName;

	private String bankName;

	private Long keyPix;

	@Enumerated(EnumType.STRING)
	private EnumTypeOfKey typeOfKey;

}
