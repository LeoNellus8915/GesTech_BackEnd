package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;

import it.teorema.gestech.model.DettagliContratti;

public interface DettagliContrattiService extends JpaRepository <DettagliContratti, Integer> {
}