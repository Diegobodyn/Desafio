package com.diego.desafio.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diego.desafio.model.RegisterPix;
import com.diego.desafio.repository.RegisterPixRepository;

@RestController
@RequestMapping(value = "/api")
public class RegisterPixResource {

	@Autowired
	RegisterPixRepository registerPixRepository;

	@GetMapping("/registros")
	public List<RegisterPix> lista() {
		return registerPixRepository.findAll();
	}

	@GetMapping("/registros/{id}")
	public Optional<RegisterPix> listaRegisterPixUnico(@PathVariable(value = "id") Long id) {
		return registerPixRepository.findById(id);
	}

	@PostMapping("/registros")
	public RegisterPix salvaRegisterPix(@RequestBody RegisterPix registerPix) {
		return registerPixRepository.save(registerPix);
	}

	@DeleteMapping("/registros")
	public void deletaRegisterPix(@RequestBody RegisterPix registerPix) {
		registerPixRepository.delete(registerPix);
	}

	@PutMapping("/registros")
	public RegisterPix atualizaRegisterPix(@RequestBody RegisterPix registerPix) {
		return registerPixRepository.save(registerPix);
	}

}
