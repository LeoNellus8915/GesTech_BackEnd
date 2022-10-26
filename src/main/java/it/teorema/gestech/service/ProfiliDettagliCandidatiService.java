package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.ProfiliDettagliCandidati;
import it.teorema.gestech.model.mapper.GetProfili;

public interface ProfiliDettagliCandidatiService extends JpaRepository <ProfiliDettagliCandidati, Integer> {

	@Query("select p.nome as nomeProfilo, l.nome as nomeLinguaggio, liv.nome as nomeLivello, "
			+ "pdc.descrizione as descrizione "
			+ "from DettagliCandidati dc, ProfiliDettagliCandidati pdc, Profili p, Linguaggi l, Livelli liv "
			+ "where dc.id = pdc.idDettaglioCandidato and pdc.idProfilo = p.id and pdc.idLinguaggio = l.id "
			+ "and pdc.idLivello = liv.id "
			+ "and dc.idPersona = :idCandidato")
	List<GetProfili> getProfili(int idCandidato);
}