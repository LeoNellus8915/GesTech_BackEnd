package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;

import it.teorema.gestech.model.PeriodiDiPreavviso;

public interface PeriodiDiPreavvisoService extends JpaRepository <PeriodiDiPreavviso, Integer> {
}