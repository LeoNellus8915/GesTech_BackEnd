package it.teorema.gestech.service;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Cv;

public interface CvService extends JpaRepository <Cv, Integer> {
	@Modifying
	@Transactional
	@Query("delete from Cv where idPersona = :idCandidato")
	void deleteByIdCandidato(int idCandidato);

	@Query("select cvBase64 "
			+ "from Cv where idPersona = :idCandidato")
	String getCv(int idCandidato);
}