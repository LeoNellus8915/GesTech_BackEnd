package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.StatiRichiesta;

public interface StatiRichiestaService extends JpaRepository <StatiRichiesta, Integer> {
	@Query("from StatiRichiesta "
			+ "where nome != :statiRichiesta")
	List<StatiRichiesta> findAllException(String statiRichiesta);

	@Query("select s.nome "
			+ "from StatiRichiesta s, Richieste r "
			+ "where s.id = r.idStato and r.id = :idRichiesta")
	String getStatoRichiesta(int idRichiesta);

	@Query("select id "
			+ "from StatiRichiesta "
			+ "where nome = :nomeStatoRichiesta")
	Integer getIdStatoRichiesta(String nomeStatoRichiesta);
}
