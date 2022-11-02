package it.teorema.gestech.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.ProfiliDettagliCandidati;
import it.teorema.gestech.model.mapper.InfoProfili;
import it.teorema.gestech.model.mapper.GetProfili;

public interface ProfiliDettagliCandidatiService extends JpaRepository <ProfiliDettagliCandidati, Integer> {

	@Query("select p.nome as nomeProfilo, l.nome as nomeLinguaggio, liv.nome as nomeLivello, "
			+ "pdc.descrizione as descrizione "
			+ "from DettagliCandidati dc, ProfiliDettagliCandidati pdc, Profili p, Linguaggi l, Livelli liv "
			+ "where dc.id = pdc.idDettaglioCandidato and pdc.idProfilo = p.id and pdc.idLinguaggio = l.id "
			+ "and pdc.idLivello = liv.id "
			+ "and dc.idPersona = :idCandidato")
	List<GetProfili> getProfili(int idCandidato);
	
	@Query("select p.id as idProfilo, p.nome as nomeProfilo, l.id as idLinguaggio, l.nome as nomeLinguaggio, "
			+ "liv.id as idLivello, liv.nome as nomeLivello, pdc.descrizione as descrizione "
			+ "from DettagliCandidati dc, ProfiliDettagliCandidati pdc, Profili p, Linguaggi l, Livelli liv "
			+ "where dc.idPersona = :idCandidato and pdc.idDettaglioCandidato = dc.id and pdc.idProfilo = p.id and "
			+ "pdc.idLinguaggio = l.id and pdc.idLivello = liv.id")
	List<InfoProfili> getInfoProfili(int idCandidato);
	
	@Modifying
	@Transactional
	@Query("delete "
			+ "from ProfiliDettagliCandidati pdc "
			+ "where pdc.idDettaglioCandidato = :idDettaglioCandidato")
	void deleteByIdDettaglioCandidato(int idDettaglioCandidato);
}