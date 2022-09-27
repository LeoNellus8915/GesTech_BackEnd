package it.teorema.gestech.service;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.DipendentiRichieste;

public interface DipendentiRichiesteService extends JpaRepository <DipendentiRichieste, Integer> {
	@Query("select count(dr.id) "
			+ "from DipendentiRichieste dr, Richieste r "
			+ "where dr.idRichiesta = r.id and dr.idDipendente = :idDipendente and dr.visualizzato = 0 and r.idStato != 3")
	Integer getNumeroRichieste(int idDipendente);

	@Modifying
	@Transactional
	@Query("update DipendentiRichieste "
			+ "set visualizzato = 1 "
			+ "where idRichiesta = :idRichiesta and idDipendente = :idDipendente")
	void setVisualizzato(int idRichiesta, int idDipendente);
	
	@Modifying
	@Transactional
	@Query("update DipendentiRichieste "
			+ "set visualizzato = 1 "
			+ "where idRichiesta = :idRichiesta")
	void setVisualizzato(int idRichiesta);

	@Modifying
	@Transactional
	@Query("delete from DipendentiRichieste where idRichiesta = :idRichiesta")
	void deleteDipendenteRichiesta(int idRichiesta);
}
