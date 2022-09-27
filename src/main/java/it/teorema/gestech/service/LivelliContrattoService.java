package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;

import it.teorema.gestech.model.LivelliContratto;

public interface LivelliContrattoService extends JpaRepository <LivelliContratto, Integer> {
}