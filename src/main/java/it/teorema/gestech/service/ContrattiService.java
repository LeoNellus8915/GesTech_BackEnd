package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;

import it.teorema.gestech.model.Contratti;

public interface ContrattiService extends JpaRepository <Contratti, Integer> {
}