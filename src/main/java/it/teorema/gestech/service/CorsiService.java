package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;

import it.teorema.gestech.model.Corsi;

public interface CorsiService extends JpaRepository <Corsi, Integer> {
}