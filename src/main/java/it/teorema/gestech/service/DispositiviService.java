package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;

import it.teorema.gestech.model.Dispositivi;

public interface DispositiviService extends JpaRepository <Dispositivi, Integer> {
}