package it.teorema.gestech.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import it.teorema.gestech.model.Persone;

public interface PersoneService extends JpaRepository<Persone, Integer>{
//	@Query("select d.nomeCognome "
//			+ "from Dipendenti d, RuoliDipendenti rd "
//			+ "where d.id = rd.idDipendente group by d.nomeCognome")
//	String[] getDipendenti();
//	
//	@Query("select id "
//			+ "from Dipendenti "
//			+ "where nomeCognome = :nomeCognome")
//	Integer findByName(String nomeCognome);
	
	@Query("select p.nome, p.cognome "
			+ "from Persone p, RuoliPersone rp, Ruoli ru "
			+ "where p.id = rp.idPersona and rp.idRuolo = ru.id and ru.nome like 'Recruiter'")
	List<Persone> getNomiRecruiter();
	
	@Query("from Persone where email = :email")
	Persone existsByEmail(String email);
	
	@Query("select id from Persone where email = :email")
	Integer findIdByEmail(String email);
	
	@Query("select p.nome, p.cognome "
			+ "from Persone p, RuoliPersone rp "
			+ "where p.id = rp.idPersona and p.nome != :nome and p.cognome != :cognome group by p.nome,p.cognome")
	String[] findAllException(String nome,String cognome);
	
	
	@Modifying
	@Transactional
	@Query("update Persone set nome = :nome, cognome = :cognome, cellulare = :cellulare, email = :email, cittaDiResidenza = :cittaDiResidenza "
			+ "where id = :idPersona")
	void updatePersona(int idPersona, String nome, String cognome, String cellulare, String email, String cittaDiResidenza);
	
	@Query("from Persone where id = :idPersona")
	Persone findByIdPersona(int idPersona);
	
	@Query("select p.id "
			+ "from Persone p, DettagliCandidati dc "
			+ "where p.id = dc.idPersona")
	List<Integer> getIdPersone();
}