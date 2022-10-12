package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;

import it.teorema.gestech.model.RichiesteDettagliCandidati;

public interface RichiesteDettagliCandidatiService extends JpaRepository <RichiesteDettagliCandidati, Integer> {
}