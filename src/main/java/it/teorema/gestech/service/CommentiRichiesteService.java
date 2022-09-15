package it.teorema.gestech.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.CommentiRichieste;

public interface CommentiRichiesteService extends JpaRepository <CommentiRichieste, Integer> {
	@Query("select c.data, r.nomeCognome, c.note "
			+ "from CommentiRichieste c, Risorse r "
			+ "where c.idDestinatario = :idRichiesta and c.idRisorsa = r.id "
			+ "order by c.data desc")
	List<Object> findById(int idRichiesta);

	@Modifying
	@Transactional
	@Query("delete from CommentiRichieste "
			+ "where idDestinatario = :idRichiesta")
	void deleteCommento(int idRichiesta);
}
