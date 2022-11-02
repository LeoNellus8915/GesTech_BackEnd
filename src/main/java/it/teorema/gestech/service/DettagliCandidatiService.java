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
import it.teorema.gestech.model.mapper.InfoDettaglioCandidato;

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
			+ "from Persone p, DettagliCandidati dc, EsitiColloquio ec "
			+ "where p.id = dc.idPersona and dc.idEsitoColloquio = ec.id ")
	List<AllCandidati> allCandidati();
	
	@Query("from DettagliCandidati where idPersona = :idPersona")
	DettagliCandidati findByIdCandidato(int idPersona);
	
	@Query("select dc.profiloLinkedin as profiloLinkedin, dc.idEsitoColloquio as idEsitoColloquio, "
			+ "ec.nome as esitoColloquio, ec.colore as coloreEsitoColloquio, dc.dataInserimento as dataInserimento, "
			+ "dc.competenzaPrincipale as competenzaPrincipale, dc.dataColloquio as dataColloquio, "
			+ "dc.annoColloquio as annoColloquio, dc.fonteReperimento as fonteReperimento, "
			+ "dc.costoGiornaliero as costoGiornaliero, dc.possibilitaLavorativa as possibilitaLavorativa, "
			+ "dc.competenzeTotali as competenzeTotali, dc.certificazioni as certificazioni "
			+ "from DettagliCandidati dc, EsitiColloquio ec "
			+ "where dc.idPersona = :idCandidato and dc.idEsitoColloquio = ec.id")
	InfoDettaglioCandidato getInfoDettaglioCandidato(int idCandidato);
	
	@Modifying
	@Transactional
	@Query("update DettagliCandidati "
			+ "set idEsitoColloquio = :idEsitoColloquio, dataColloquio = :dataColloquio, "
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

	@Modifying
	@Transactional
	@Query("update DettagliCandidati "
			+ "set idEsitoColloquio = :#{#dc.idEsitoColloquio}, dataColloquio = :#{#dc.dataColloquio}, "
			+ "annoColloquio = :#{#dc.annoColloquio}, fonteReperimento = :#{#dc.fonteReperimento}, "
			+ "competenzaPrincipale = :#{#dc.competenzaPrincipale}, profiloLinkedin = :#{#dc.profiloLinkedin}, "
			+ "costoGiornaliero = :#{#dc.costoGiornaliero}, possibilitaLavorativa = :#{#dc.possibilitaLavorativa}, "
			+ "competenzeTotali = :#{#dc.competenzeTotali}, certificazioni = :#{#dc.certificazioni} "
			+ "where idPersona = :idCandidato")
	void updateInfoDettaglioCandidato(DettagliCandidati dc, int idCandidato);
}























