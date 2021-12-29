package com.diego.challenge.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.diego.challenge.dto.RegisterPixDTO;
import com.diego.challenge.models.RegisterPix;
import com.diego.challenge.repositorys.RegisterPixRepository;
import com.diego.challenge.services.exceptions.DatabaseException;
import com.diego.challenge.services.exceptions.ResourceNotFoundException;

@Service
public class RegisterPixService {

	@Autowired
	private RegisterPixRepository registerPixRepository;
	
	public RegisterPixDTO findById(Long id) {
		RegisterPix entity = registerPixRepository.findById(id).get();
		RegisterPixDTO dto = new RegisterPixDTO(entity);
		return dto;
	}

	public List<RegisterPixDTO> findAll() {
		List<RegisterPix> list = registerPixRepository.findAll();
		return list.stream().map(e -> new RegisterPixDTO(e)).collect(Collectors.toList());
	}
	
	public RegisterPixDTO insert(RegisterPixDTO dto) {
		RegisterPix entity = dto.toEntity();
		entity = registerPixRepository.save(entity);
		return new RegisterPixDTO(entity);
	}
	
	public void delete(Long id) {
		try {
			registerPixRepository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	@Transactional
	public RegisterPixDTO update(Long id, RegisterPixDTO dto) {
		try {
			RegisterPix entity = registerPixRepository.getById(id);
			updateData(entity, dto);
			entity = registerPixRepository.save(entity);
			return new RegisterPixDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(RegisterPix entity, RegisterPixDTO dto) {
		entity.setId(dto.getId());
		entity.setClientName(dto.getClientName());
		entity.setBankName(dto.getBankName());
		entity.setKeyPix(dto.getKeyPix());
		entity.setTypeOfKey(dto.getTypeOfKey());
	}
	
}
