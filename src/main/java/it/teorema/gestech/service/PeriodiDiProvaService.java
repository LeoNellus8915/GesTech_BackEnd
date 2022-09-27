package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;

import it.teorema.gestech.model.PeriodiDiProva;

public interface PeriodiDiProvaService extends JpaRepository <PeriodiDiProva, Integer> {
}