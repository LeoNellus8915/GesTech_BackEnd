package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;

import it.teorema.gestech.model.CCNL;

public interface CCNLService extends JpaRepository <CCNL, Integer> {
}