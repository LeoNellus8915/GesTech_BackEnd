package it.teorema.gestech.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.DettagliCandidati;

public interface DettagliCandidatiService extends JpaRepository <DettagliCandidati, Integer> {
	@Query("select c.id, dc.dataInserimento, c.nomeCognome, c.citta, p.nome, dc.competenzaPrincipale, e.nome "
			+ "from DettagliCandidati dc, Candidati c, EsitiColloquio e, Profili p "
			+ "where c.id = dc.idCandidato and e.id = dc.idEsitoColloquio and p.id = dc.idProfilo")
	List<Object> allCandidati();
	
	@Modifying
	@Transactional
	@Query("delete from DettagliCandidati where idCandidato = :idCandidato")
	void deleteByIdCandidato(int idCandidato);
	
	@Query("select dataInserimento from DettagliCandidati where idCandidato = :idCandidato")
	LocalDateTime getDataInserimento(int idCandidato);
	
	@Query("from DettagliCandidati "
			+ "where idCandidato = :idCandidato")
	DettagliCandidati getDettagliCandidato(int idCandidato);
	
	
	@Modifying
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
			String linguaggioCampoLibero, String competenzeTotali, String certificazioni);
	
	@Query("select fileBase64 from DettagliCandidati where idCandidato = :idCandidato")
	String getFile64(int idCandidato);

	@Query("from DettagliCandidati where idCandidato = :idCandidato")
	DettagliCandidati findByIdCandidato(int idCandidato);
}