package com.diego.challenge.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.diego.challenge.dto.RegisterPixDTO;
import com.diego.challenge.services.RegisterPixService;

@RestController
@RequestMapping(value = "/pix")
public class RegisterPixResource {

	@Autowired
	RegisterPixService registerPixService;

	@GetMapping("/")
	public List<RegisterPixDTO> lista() {
		return registerPixService.findAll();
	}

	@GetMapping("/{id}")
	public RegisterPixDTO listaRegisterPixUnico(@PathVariable(value = "id") Long id) {
		return registerPixService.findById(id);
	}

	@PostMapping
	public ResponseEntity<RegisterPixDTO> insert(@RequestBody RegisterPixDTO dto) {
		dto = registerPixService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		registerPixService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<RegisterPixDTO> update(@PathVariable Long id, @RequestBody RegisterPixDTO obj) {
		obj = registerPixService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
