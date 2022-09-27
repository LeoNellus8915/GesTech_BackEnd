package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;

import it.teorema.gestech.model.Session;

public interface SessionService extends JpaRepository <Session, Integer> {	
}