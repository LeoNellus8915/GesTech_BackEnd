package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.DettagliDipendenti;

public interface DettagliDipendentiService extends JpaRepository <DettagliDipendenti, Integer> {
	@Query("select d.id, d.nomeCognome, a.nome "
			+ "from Dipendenti d, AziendeDipendenti ad, Aziende a "
			+ "where d.id = ad.idDipendente and a.id = ad.idAzienda ")
	List<Object> allDipendenti();
}