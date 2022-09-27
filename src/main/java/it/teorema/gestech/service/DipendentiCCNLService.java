package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;

import it.teorema.gestech.model.DipendentiCCNL;

public interface DipendentiCCNLService extends JpaRepository <DipendentiCCNL, Integer> {
}