package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Contratti;

public interface ContrattiService extends JpaRepository <Contratti, Integer> {
	
	@Query("select a.nome "
			+ "from Contratti c, Aziende a "
			+ "where c.idAzienda = a.id and c.idPersona = :idPersona")
	String getAziendaByIdPersona(int idPersona);
}