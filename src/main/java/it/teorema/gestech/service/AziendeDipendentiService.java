package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.AziendeDipendenti;

public interface AziendeDipendentiService extends JpaRepository <AziendeDipendenti, Integer> {
	@Query("select a.nome "
			+ "from AziendeDipendenti ad, Aziende a "
			+ "where ad.idAzienda = a.id and ad.idDipendente = :idDipendente")
	String getAziendaByIdDipendente(int idDipendente);
}