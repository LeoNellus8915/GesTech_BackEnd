package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;

import it.teorema.gestech.model.ProfiliDettagliCandidati;

public interface ProfiliDettagliCandidatiService extends JpaRepository <ProfiliDettagliCandidati, Integer> {
}