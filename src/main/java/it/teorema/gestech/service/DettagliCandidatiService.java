package it.teorema.gestech.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.DettagliCandidati;

import it.teorema.gestech.model.mapper.AllCandidati;

public interface DettagliCandidatiService extends JpaRepository <DettagliCandidati, Integer> {
	/*@Query("select c.id as id, dc.dataInserimento as dataInserimento, c.nomeCognome as nomeCognome, c.citta as citta, "
			+ "p.nome as profiloNome, dc.competenzaPrincipale as competenzaPrincipale, e.nome as esitoNome "
			+ "from DettagliCandidati dc, Persone p, EsitiColloquio e, Profili p "
			+ "where p.id = dc.idCandidato and e.id = dc.idEsitoColloquio and p.id = dc.idProfilo")
	List<AllCandidati> allCandidati();*/
	
	@Modifying
	@Transactional
	@Query("delete from DettagliCandidati where idPersona = :idPersona")
	void deleteByIdCandidato(int idPersona);
	
	@Query("select dataInserimento from DettagliCandidati where idPersona = :idPersona")
	LocalDateTime getDataInserimento(int idPersona);
	
	@Query("from DettagliCandidati "
			+ "where idPersona = :idPersona")
	DettagliCandidati getDettagliCandidato(int idPersona);
	
	@Query("select p.id as id, dc.dataInserimento as dataInserimento, p.nome as nome, p.cognome as cognome, dc.competenzaPrincipale as competenzaPrincipale, ec.nome as esitoNome, p.cittaDiResidenza as citta "
			+"from Persone p, DettagliCandidati dc, EsitiColloquio ec "
			+"where p.id = dc.idPersona and dc.idEsitoColloquio = ec.id ")
		List<AllCandidati> allCandidati();
	
	
	/*@Modifying
	@Transactional
	@Query("update DettagliCandidati set idEsitoColloquio = :idEsitoColloquio, idProfilo = :idProfilo, idLinguaggio1 = :idLinguaggio1, "
			+ "idLinguaggio2 = :idLinguaggio2, idLinguaggio3 = :idLinguaggio3, idLinguaggio4 = :idLinguaggio4, "
			+ "idLinguaggio5 = :idLinguaggio5, idLingua1 = :idLingua1, idLingua2 = :idLingua2, idLingua3 = :idLingua3, "
			+ "idLivello = :idLivello, dataColloquio = :dataColloquio, annoColloquio = :annoColloquio, fonteReperimento = :fonteReperimento, "
			+ "competenzaPrincipale = :competenzaPrincipale, costoGiornaliero = :costoGiornaliero, possibilitaLavorativa = :possibilitaLavorativa, "
			+ "linguaggioCampoLibero = :linguaggioCampoLibero, competenzeTotali = :competenzeTotali, certificazioni = :certificazioni where idCandidato = :idCandidato")
	void updateCandidato(int idCandidato, int idEsitoColloquio, int idProfilo, int idLinguaggio1, int idLinguaggio2, int idLinguaggio3, 
			int idLinguaggio4, int idLinguaggio5, int idLingua1, int idLingua2, int idLingua3, int idLivello, LocalDate dataColloquio, 
			Integer annoColloquio, String fonteReperimento, String competenzaPrincipale, double costoGiornaliero, String possibilitaLavorativa, 
			String linguaggioCampoLibero, String competenzeTotali, String certificazioni);*/

	@Query("from DettagliCandidati where idPersona = :idPersona")
	DettagliCandidati findByIdCandidato(int idPersona);
}