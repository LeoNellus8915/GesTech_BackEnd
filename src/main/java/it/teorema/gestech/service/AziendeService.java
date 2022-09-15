package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;

import it.teorema.gestech.model.Aziende;

public interface AziendeService extends JpaRepository <Aziende, Integer> {
}