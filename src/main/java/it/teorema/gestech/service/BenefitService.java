package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;

import it.teorema.gestech.model.Benefit;

public interface BenefitService extends JpaRepository <Benefit, Integer> {
}