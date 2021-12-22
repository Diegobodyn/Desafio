package com.diego.desafio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diego.desafio.model.RegisterPix;

public interface RegisterPixRepository extends JpaRepository<RegisterPix, Long> {

	Optional<RegisterPix> findById(Long id);
}
