package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;

import it.teorema.gestech.model.LingueDettagliCandidati;

public interface LingueDettagliCandidatiService extends JpaRepository <LingueDettagliCandidati, Integer> {
}