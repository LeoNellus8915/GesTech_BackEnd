package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;

import it.teorema.gestech.model.Clienti;

public interface ClientiService extends JpaRepository <Clienti, Integer> {
}