package it.teorema.gestech.service;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.RisorseRichieste;

public interface RisorseRichiesteService extends JpaRepository <RisorseRichieste, Integer> {
	@Query("select count(rr.id) "
			+ "from RisorseRichieste rr, Richieste r "
			+ "where rr.idRichiesta = r.id and rr.idRisorsa = :idRisorsa and rr.visualizzato = 0 and r.idStato != 3")
	Integer getNumeroRichieste(int idRisorsa);

	@Modifying
	@Transactional
	@Query("update RisorseRichieste "
			+ "set visualizzato = 1 "
			+ "where idRichiesta = :idRichiesta and idRisorsa = :idRisorsa")
	void setVisualizzato(int idRichiesta, int idRisorsa);
	
	@Modifying
	@Transactional
	@Query("update RisorseRichieste "
			+ "set visualizzato = 1 "
			+ "where idRichiesta = :idRichiesta")
	void setVisualizzato(int idRichiesta);

	@Modifying
	@Transactional
	@Query("delete from RisorseRichieste where idRichiesta = :idRichiesta")
	void deleteRisorsaRichiesta(int idRichiesta);
}
