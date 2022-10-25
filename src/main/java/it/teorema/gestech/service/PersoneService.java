package it.teorema.gestech.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import it.teorema.gestech.model.Persone;
import it.teorema.gestech.model.mapper.AllDipendenti;
import it.teorema.gestech.model.mapper.GetDipendente;
import it.teorema.gestech.model.mapper.GetNomiRecruiter;

public interface PersoneService extends JpaRepository<Persone, Integer>{
//	@Query("select p.id as id, p.nome as nome, p.cognome as cognome,a.nome as azienda "
//			+ "from Persone p, Contratti c, Aziende a "
//			+ "where p.id = c.idPersona and c.idAzienda = a.id ")
//	List getDipendenti();
//	
	@Query("select p.id "			
			+ "from Persone p "
			+ "where p.nome = :nome and p.cognome = :cognome")
	Integer findByName(String nome, String cognome);
	
	@Query("select p.nome as nome, p.cognome as cognome "
			+ "from Persone p, RuoliPersone rp, Ruoli ru "
			+ "where rp.idPersona = p.id and rp.idRuolo = ru.id and ru.nome like 'Recruiter'")
	List<GetNomiRecruiter> getNomiRecruiter();
	
	@Query("from Persone where email = :email")
	Persone existsByEmail(String email);
	
	@Query("select id from Persone where email = :email")
	Integer findIdByEmail(String email);
	
	@Query("select p.nome, p.cognome "
			+ "from Persone p, RuoliPersone rp "
			+ "where p.id = rp.idPersona and p.nome != :nome and p.cognome != :cognome group by p.nome,p.cognome")
	String[] findAllException(String nome,String cognome);
	
	/*@Query("select p.nome as nome, p.cognome as cognome "
			+ "from Persone p, Contratti c, Hardware h "
			+ "where p.id = c.idPersona and p.id = h.idPersona and h.idPersona = :idPersona ")
	FindAllDipendentiException findAllDipendentiException(int idPersona);*/
	
	@Modifying
	@Transactional
	@Query("update Persone set nome = :nome, cognome = :cognome, cellulare = :cellulare, email = :email, cittaDiResidenza = :cittaDiResidenza "
			+ "where id = :idPersona")
	void updatePersona(int idPersona, String nome, String cognome, String cellulare, String email, String cittaDiResidenza);
	
	@Query("from Persone where id = :idCandidato")
	Persone findByIdPersona(int idCandidato);
	
	@Query("select p.id "
			+ "from Persone p, DettagliCandidati dc "
			+ "where p.id = dc.idPersona")
	List<Integer> getIdPersone();
	
	@Query("select p.id as id, p.nome as nome, p.cognome as cognome, a.nome as azienda "
			+ "from Persone p, Contratti c, Aziende a "
			+ "where c.idPersona = p.id and c.idAzienda = a.id")
	List<AllDipendenti> getAllDipendenti();
	
	@Query("select p.id as id, p.nome as nome, p.cognome as cognome "
			+ "from Persone p, Hardware h "
			+ "where p.id = h.idPersona and h.idPersona = :id "
			+ "group by p.id")
	GetDipendente getDipendente(int id);
}











