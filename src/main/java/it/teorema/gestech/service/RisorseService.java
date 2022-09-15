package it.teorema.gestech.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Risorse;

public interface RisorseService extends JpaRepository<Risorse, Integer>{
	@Query("select nomeCognome from Risorse where id = :idRisorsa")
	String getNomeCognome(int idRisorsa);
	
	@Query("select id from Risorse where email = :email")
	Integer findIdByEmail(String email);
	
	@Query("from Risorse where id = :idRisorsa")
	Risorse findByIdRisorsa(int idRisorsa);
	
	@Modifying
	@Transactional
	@Query("update Risorse set nomeCognome = :nomeCognome, recapito = :recapito, email = :email, profiloLinkedin = :profiloLinkedin, citta = :citta, "
			+ "dataColloquio = :dataColloquio, annoColloquio = :annoColloquio, fonteReperimento = :fonteReperimento, "
			+ "competenzaPrincipale = :competenzaPrincipale, costoGiornaliero = :costoGiornaliero, possibilitaLavorativa = :possibilitaLavorativa, "
			+ "skillCampoLibero = :skillCampoLibero, competenzeTotali = :competenzeTotali, certificazioni = :certificazioni where id = :idCandidato")
	void updateCandidato(int idCandidato, String nomeCognome, String recapito, String email, String profiloLinkedin, String citta, LocalDate dataColloquio, 
			Integer annoColloquio, String fonteReperimento, String competenzaPrincipale, double costoGiornaliero, String possibilitaLavorativa, 
			String skillCampoLibero, String competenzeTotali, String certificazioni);
	
	@Query("select r.nomeCognome "
			+ "from Risorse r, RuoliRisorse rr, Ruoli ru "
			+ "where r.id = rr.idRisorsa and rr.idRuolo = ru.id and ru.nome like 'Recruiter'")
	List<String> getNomiRecruiter();

	@Query("select id "
			+ "from Risorse "
			+ "where nomeCognome = :nomeCognome")
	Integer findByName(String nomeCognome);

	@Query("from Risorse where email = :email")
	Risorse existsByEmail(String email);

	@Query("select r.nomeCognome "
			+ "from Risorse r, RuoliRisorse rr "
			+ "where r.id = rr.idRisorsa")
	String[] getDipendenti();
	
	@Query("select r.nomeCognome "
			+ "from Risorse r, RuoliRisorse rr "
			+ "where r.id = rr.idRisorsa and r.nomeCognome != :dipendente ")
	String[] findAllException(String dipendente);
}