package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Dispositivi;

public interface DispositiviService extends JpaRepository <Dispositivi, Integer> {

	
	@Query("from Dispositivi d "
			+"where d.id != 5")
	List<Dispositivi> getDispositivi();
}