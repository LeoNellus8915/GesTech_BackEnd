package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Dipendenti;

public interface DipendentiService extends JpaRepository<Dipendenti, Integer>{
	@Query("select d.nomeCognome "
			+ "from Dipendenti d, RuoliDipendenti rd "
			+ "where d.id = rd.idDipendente group by d.nomeCognome")
	String[] getDipendenti();
	
	@Query("select nomeCognome from Dipendenti where id = :idDipendente")
	String getNomeCognome(int idDipendente);
	
	@Query("select id "
			+ "from Dipendenti "
			+ "where nomeCognome = :nomeCognome")
	Integer findByName(String nomeCognome);
	
	@Query("select d.nomeCognome "
			+ "from Dipendenti d, RuoliDipendenti rd, Ruoli ru "
			+ "where d.id = rd.idDipendente and rd.idRuolo = ru.id and ru.nome like 'Recruiter'")
	List<String> getNomiRecruiter();
	
	@Query("from Dipendenti where email = :email")
	Dipendenti existsByEmail(String email);
	
	@Query("select id from Dipendenti where email = :email")
	Integer findIdByEmail(String email);
	
	@Query("select d.nomeCognome "
			+ "from Dipendenti d, RuoliDipendenti rd "
			+ "where d.id = rd.idDipendente and d.nomeCognome != :dipendente group by d.nomeCognome")
	String[] findAllException(String dipendente);
}
