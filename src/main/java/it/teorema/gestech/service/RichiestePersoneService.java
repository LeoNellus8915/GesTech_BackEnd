package it.teorema.gestech.service;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.RichiestePersone;

public interface RichiestePersoneService extends JpaRepository <RichiestePersone, Integer> {
	
	@Query("select count(rp.id) "
			+ "from RichiestePersone rp, Richieste r "
			+ "where rp.idRichiesta = r.id and rp.idPersona = :idPersona and "
			+ "rp.visualizzato = 0 and r.idStato != 3")
	Integer getNumeroRichieste(int idPersona);

	@Modifying
	@Transactional
	@Query("update RichiestePersone "
			+ "set visualizzato = 1 "
			+ "where idRichiesta = :idRichiesta and idPersona = :idPersona")
	void setVisualizzato(int idRichiesta, int idPersona);
	
	@Modifying
	@Transactional
	@Query("update RichiestePersone "
			+ "set visualizzato = 1 "
			+ "where idRichiesta = :idRichiesta")
	void setVisualizzato(int idRichiesta);

	@Modifying
	@Transactional
	@Query("delete from RichiestePersone where idRichiesta = :idRichiesta")
	void deleteDipendenteRichiesta(int idRichiesta);
}
