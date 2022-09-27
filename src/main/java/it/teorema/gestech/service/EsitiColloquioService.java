package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.EsitiColloquio;

public interface EsitiColloquioService extends JpaRepository <EsitiColloquio, Integer> {	
	@Query("select e.nome "
			+ "from EsitiColloquio e, DettagliCandidati dc "
			+ "where e.id = dc.idEsitoColloquio and dc.idCandidato = :idCandidato")
	String getEsitoColloquio(int idCandidato);

	@Query("from EsitiColloquio "
			+ "where nome != :esitoColloquio")
	List<EsitiColloquio> findAllException(String esitoColloquio);

	@Query("select colore "
			+ "from EsitiColloquio where nome = :nome")
	int getColore(String nome);
}