package com.diego.challenge.dto;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

import com.diego.challenge.enums.EnumTypeOfKey;
import com.diego.challenge.models.RegisterPix;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterPixDTO {

	private Long id;

	@NotBlank(message = "Field cannot be blank")
	private String clientName;

	@NotBlank(message = "Field cannot be blank")
	private String bankName;

	@NotBlank(message = "Field cannot be blank")
	private Long keyPix;

	@Enumerated
	@NotBlank(message = "Field cannot be blank")
	private EnumTypeOfKey typeOfKey;

	public RegisterPixDTO(RegisterPix registerPix) {
		id = registerPix.getId();
		clientName = registerPix.getClientName();
		bankName = registerPix.getBankName();
		keyPix = registerPix.getKeyPix();
		typeOfKey = registerPix.getTypeOfKey();
	}

	public RegisterPix toEntity() {
		return new RegisterPix(id, clientName, bankName, keyPix, typeOfKey);
	}
}
