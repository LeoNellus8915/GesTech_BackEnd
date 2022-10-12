package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;

import it.teorema.gestech.model.Cv;

public interface CvService extends JpaRepository <Cv, Integer> {
}