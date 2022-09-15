package it.teorema.gestech.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.CommentiRisorse;

public interface CommentiRisorseService extends JpaRepository <CommentiRisorse, Integer> {
	@Query("select c.data, r.nomeCognome, c.note "
			+ "from CommentiRisorse c, Risorse r "
			+ "where r.id = c.idMittente and c.idDestinatario = :idDestinatario "
			+ "order by c.data desc")
	List<Object> findByIdRisorsa(int idDestinatario);
	
	@Modifying
	@Transactional
	@Query("delete from CommentiRisorse where idDestinatario = :idCandidato")
	void deleteByIdCandidato(int idCandidato);
} 