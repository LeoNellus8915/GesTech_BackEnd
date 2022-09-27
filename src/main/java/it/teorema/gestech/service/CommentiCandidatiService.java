package it.teorema.gestech.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.CommentiCandidati;

public interface CommentiCandidatiService extends JpaRepository <CommentiCandidati, Integer> {
	@Query("select cc.data, d.nomeCognome, cc.note "
			+ "from CommentiCandidati cc, Dipendenti d "
			+ "where d.id = cc.idDipendente and cc.idCandidato = :idCandidato "
			+ "order by cc.data desc")
	List<Object> findByIdCandidato(int idCandidato);
	
	@Modifying
	@Transactional
	@Query("delete from CommentiCandidati where idCandidato = :idCandidato")
	void deleteByIdCandidato(int idCandidato);
} 