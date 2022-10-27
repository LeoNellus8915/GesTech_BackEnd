package it.teorema.gestech.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.DettagliCandidati;

import it.teorema.gestech.model.mapper.AllCandidati;
import it.teorema.gestech.model.mapper.GetProfili;

public interface DettagliCandidatiService extends JpaRepository <DettagliCandidati, Integer> {
	
	@Query("select dc.id "
			+ "from DettagliCandidati dc, Persone p "
			+ "where dc.idPersona = p.id and p.id = :idPersona")
	int getIdDettaglioCandidato(int idPersona);
	
	@Query("select dataInserimento from DettagliCandidati where idPersona = :idPersona")
	LocalDateTime getDataInserimento(int idPersona);
	
	@Query("from DettagliCandidati "
			+ "where idPersona = :idPersona")
	DettagliCandidati getDettagliCandidato(int idPersona);
	
	@Query("select p.id as id, dc.dataInserimento as dataInserimento, p.nome as nome, "
			+ "p.cognome as cognome, dc.competenzaPrincipale as competenzaPrincipale, "
			+ "ec.nome as esitoNome, p.cittaDiResidenza as citta "
			+"from Persone p, DettagliCandidati dc, EsitiColloquio ec "
			+"where p.id = dc.idPersona and dc.idEsitoColloquio = ec.id ")
	List<AllCandidati> allCandidati();
	
	@Query("from DettagliCandidati where idPersona = :idPersona")
	DettagliCandidati findByIdCandidato(int idPersona);
	
	@Modifying
	@Transactional
	@Query("update DettagliCandidati set idEsitoColloquio = :idEsitoColloquio, dataColloquio = :dataColloquio, "
			+ "annoColloquio = :annoColloquio, fonteReperimento = :fonteReperimento, "
			+ "competenzaPrincipale = :competenzaPrincipale, profiloLinkedin = :profiloLinkedin, "
			+ "costoGiornaliero = :costoGiornaliero, possibilitaLavorativa = :possibilitaLavorativa, "
			+ "competenzeTotali = :competenzeTotali, certificazioni = :certificazioni "
			+ "where idPersona = :idCandidato")
	void updateCandidato(int idCandidato, int idEsitoColloquio, LocalDate dataColloquio, Integer annoColloquio, String fonteReperimento, 
			String competenzaPrincipale, double costoGiornaliero, String possibilitaLavorativa,
			String competenzeTotali, String certificazioni, String profiloLinkedin);
	
	@Modifying
	@Transactional
	@Query("delete "
			+ "from DettagliCandidati "
			+ "where idPersona = :idPersona")
	void deleteByIdCandidato(int idPersona);
	
	@Query("select p.nome as nomeProfilo, l.nome as nomeLinguaggio, liv.nome as nomeLivello, pdc.descrizione as descrizione "
			+ "from DettagliCandidati dc, ProfiliDettagliCandidati pdc, Profili p, Linguaggi l, Livelli liv "
			+ "where dc.idPersona = :idCandidato and pdc.idDettaglioCandidato = dc.id and pdc.idProfilo = p.id and "
			+ "pdc.idLinguaggio = l.id and pdc.idLivello = liv.id")
	List<GetProfili> findGetProfili(int idCandidato);
}























