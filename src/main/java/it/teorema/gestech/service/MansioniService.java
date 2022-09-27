package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;

import it.teorema.gestech.model.Mansioni;

public interface MansioniService extends JpaRepository <Mansioni, Integer> {
}