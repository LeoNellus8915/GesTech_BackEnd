package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;

import it.teorema.gestech.model.Hardware;

public interface HardwareService extends JpaRepository <Hardware, Integer> {
}