package it.teorema.gestech.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Candidati;

public interface CandidatiService extends JpaRepository<Candidati, Integer>{
	@Query("from Candidati where id = :idCandidato")
	Candidati findByIdCandidato(int idCandidato);
	
	@Modifying
	@Transactional
	@Query("update Candidati set nomeCognome = :nomeCognome, cellulare = :cellulare, email = :email, profiloLinkedin = :profiloLinkedin, citta = :citta "
			+ "where id = :idCandidato")
	void updateCandidato(int idCandidato, String nomeCognome, String cellulare, String email, String profiloLinkedin, String citta);

	@Query("from Candidati where email = :email")
	Candidati existsByEmail(String email);

	@Query("select c.id "
			+ "from Candidati c, DettagliCandidati dc "
			+ "where c.id = dc.idCandidato")
	List<Integer> getIdCandidati();
	
	@Query("select id from Candidati where email = :email")
	Integer findIdByEmail(String email);
}