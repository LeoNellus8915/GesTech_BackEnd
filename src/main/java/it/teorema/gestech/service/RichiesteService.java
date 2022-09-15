package it.teorema.gestech.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Richieste;

public interface RichiesteService extends JpaRepository <Richieste, Integer> {
	@Query("select ri.id, ri.data, ri.cliente, ri.citta, ri.costo, ri.note, li.nome, pro.nome, liv.nome, sr.nome, ri.recruiter, rr.visualizzato "
			+ "from Richieste ri, Linguaggi li, Profili pro, Livelli liv, StatiRichiesta sr, RisorseRichieste rr "
			+ "where ri.idSeniority = liv.id and ri.idSkill = li.id and ri.idProfilo = pro.id and ri.idStato = sr.id and ri.id = rr.idRichiesta "
			+ "and sr.nome != 'Chiusa' "
			+ "group by rr.idRichiesta order by ri.data desc")
	List<Object> stampaCardAperte();
	
	@Query("select ri.id, ri.data, ri.cliente, ri.citta, ri.costo, ri.note, li.nome, pro.nome, liv.nome, sr.nome, ri.recruiter, rr.visualizzato "
			+ "from Richieste ri, Linguaggi li, Profili pro, Livelli liv, StatiRichiesta sr, RisorseRichieste rr "
			+ "where ri.idSeniority = liv.id and ri.idSkill = li.id and ri.idProfilo = pro.id and ri.idStato = sr.id and ri.id = rr.idRichiesta "
			+ "and (ri.recruiter like '%Tutti%' or ri.recruiter like %:nomeCognome%) and rr.idRisorsa = :idRisorsa "
			+ "and sr.nome != 'Chiusa' "
			+ "order by ri.data desc")
	List<Object> stampaCardByNameAperte(String nomeCognome, int idRisorsa);
	
	@Query("select ri.id, ri.data, ri.cliente, ri.citta, ri.costo, ri.note, li.nome, pro.nome, liv.nome, sr.nome, ri.recruiter, rr.visualizzato "
			+ "from Richieste ri, Linguaggi li, Profili pro, Livelli liv, StatiRichiesta sr, RisorseRichieste rr "
			+ "where ri.idSeniority = liv.id and ri.idSkill = li.id and ri.idProfilo = pro.id and ri.idStato = sr.id and ri.id = rr.idRichiesta "
			+ "and sr.nome = 'Chiusa' "
			+ "group by rr.idRichiesta order by ri.data desc")
	List<Object> stampaCardChiuse();
	
	@Query("select ri.id, ri.data, ri.cliente, ri.citta, ri.costo, ri.note, li.nome, pro.nome, liv.nome, sr.nome, ri.recruiter, rr.visualizzato "
			+ "from Richieste ri, Linguaggi li, Profili pro, Livelli liv, StatiRichiesta sr, RisorseRichieste rr "
			+ "where ri.idSeniority = liv.id and ri.idSkill = li.id and ri.idProfilo = pro.id and ri.idStato = sr.id and ri.id = rr.idRichiesta "
			+ "and (ri.recruiter like '%Tutti%' or ri.recruiter like %:nomeCognome%) and rr.idRisorsa = :idRisorsa "
			+ "and sr.nome = 'Chiusa' "
			+ "order by ri.data desc")
	List<Object> stampaCardByNameChiuse(String nomeCognome, int idRisorsa);
	
	@Query("select ri.id, ri.data, ri.cliente, ri.citta, ri.costo, ri.note, li.nome, pro.nome, liv.nome, sr.nome, ri.recruiter "
			+ "from Richieste ri, Linguaggi li, Profili pro, Livelli liv, StatiRichiesta sr "
			+ "where ri.idSeniority = liv.id and ri.idSkill = li.id and ri.idProfilo = pro.id and ri.idStato = sr.id "
			+ "and ri.id = :idRichiesta")
	Object visualizzaRichiesta(int idRichiesta);
	
	@Modifying
	@Transactional
	@Query("update Richieste set idStato = :idStato where id = :idDestinatario")
	void updateStato(int idStato, int idDestinatario);

	@Query("select max(id) from Richieste")
	Integer findLastId();
}