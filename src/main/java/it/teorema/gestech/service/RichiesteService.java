package it.teorema.gestech.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Richieste;

public interface RichiesteService extends JpaRepository <Richieste, Integer> {
	@Query("select ri.id, ri.data, ri.cliente, ri.citta, ri.costo, ri.note, li.nome, pro.nome, liv.nome, sr.nome "
			+ "from Richieste ri, Linguaggi li, Profili pro, Livelli liv, StatiRichiesta sr "
			+ "where ri.idLivello = liv.id and ri.idLinguaggio = li.id and ri.idProfilo = pro.id and ri.idStato = sr.id "
			+ "and sr.nome != 'Chiusa' "
			+ "order by ri.data desc")
	List<Object> stampaCardAperte();
	
	@Query("select ri.id, ri.data, ri.cliente, ri.citta, ri.costo, ri.note, li.nome, pro.nome, liv.nome, sr.nome, ri.recruiter, dr.visualizzato "
			+ "from Richieste ri, Linguaggi li, Profili pro, Livelli liv, StatiRichiesta sr, DipendentiRichieste dr "
			+ "where ri.idLivello = liv.id and ri.idLinguaggio = li.id and ri.idProfilo = pro.id and ri.idStato = sr.id and ri.id = dr.idRichiesta "
			+ "and (ri.recruiter like '%Tutti%' or ri.recruiter like %:nomeCognome%) and dr.idDipendente = :idDipendente "
			+ "and sr.nome != 'Chiusa' "
			+ "order by ri.data desc")
	List<Object> stampaCardByNameAperte(String nomeCognome, int idDipendente);
	
	@Query("select ri.id, ri.data, ri.cliente, ri.citta, ri.costo, ri.note, li.nome, pro.nome, liv.nome, sr.nome, ri.recruiter "
			+ "from Richieste ri, Linguaggi li, Profili pro, Livelli liv, StatiRichiesta sr "
			+ "where ri.idLivello = liv.id and ri.idLinguaggio = li.id and ri.idProfilo = pro.id and ri.idStato = sr.id "
			+ "and sr.nome = 'Chiusa' "
			+ "order by ri.data desc")
	List<Object> stampaCardChiuse();
	
	@Query("select ri.id, ri.data, ri.cliente, ri.citta, ri.costo, ri.note, li.nome, pro.nome, liv.nome, sr.nome, ri.recruiter, dr.visualizzato "
			+ "from Richieste ri, Linguaggi li, Profili pro, Livelli liv, StatiRichiesta sr, DipendentiRichieste dr "
			+ "where ri.idLivello = liv.id and ri.idLinguaggio = li.id and ri.idProfilo = pro.id and ri.idStato = sr.id and ri.id = dr.idRichiesta "
			+ "and (ri.recruiter like '%Tutti%' or ri.recruiter like %:nomeCognome%) and dr.idDipendente = :idDipendente "
			+ "and sr.nome = 'Chiusa' "
			+ "order by ri.data desc")
	List<Object> stampaCardByNameChiuse(String nomeCognome, int idDipendente);
	
	@Query("select ri.id, ri.data, ri.cliente, ri.citta, ri.costo, ri.note, li.nome, pro.nome, liv.nome, sr.nome, ri.recruiter "
			+ "from Richieste ri, Linguaggi li, Profili pro, Livelli liv, StatiRichiesta sr "
			+ "where ri.idLivello = liv.id and ri.idLinguaggio = li.id and ri.idProfilo = pro.id and ri.idStato = sr.id "
			+ "and ri.id = :idRichiesta")
	Object visualizzaRichiesta(int idRichiesta);
	
	@Modifying
	@Transactional
	@Query("update Richieste set idStato = :idStato where id = :idRichiesta")
	void updateStato(int idStato, int idRichiesta);

	@Query("select max(id) from Richieste")
	Integer findLastId();
	
	@Query("select r.id "
			+ "from Richieste r, StatiRichiesta sr "
			+ "where r.idStato = sr.id "
			+ "and sr.nome != 'Chiusa' "
			+ "order by r.data desc")
	List<Integer> getIdRichiesteAperte();
	
	@Query("select r.id "
			+ "from Richieste r, StatiRichiesta sr "
			+ "where r.idStato = sr.id "
			+ "and sr.nome = 'Chiusa' "
			+ "order by r.data desc")
	List<Integer> getIdRichiesteChiuse();

	@Query("select max(id) "
			+ " from Richieste")
	Integer getLastId();
}