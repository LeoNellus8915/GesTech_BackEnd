package it.teorema.gestech.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Richieste;
import it.teorema.gestech.model.mapper.AllRichieste;
import it.teorema.gestech.model.mapper.AllRichiesteAperte;
import it.teorema.gestech.model.mapper.AllRichiesteChiuse;
import it.teorema.gestech.model.mapper.GetRichiesta;

public interface RichiesteService extends JpaRepository <Richieste, Integer> {
	@Query("select ri.id as id, ri.data as data, ri.cliente as cliente, ri.citta as citta , ri.costo as costo, "
			+ "ri.note as note , li.nome as linguaggiNome, pro.nome as profiliNome, liv.nome as livelliNome, "
			+ "sr.nome as statiRichiesteNome, ri.priorita as priorita "
			+ "from Richieste ri, Linguaggi li, Profili pro, Livelli liv, StatiRichiesta sr "
			+ "where ri.idLivello = liv.id and ri.idLinguaggio = li.id and ri.idProfilo = pro.id and ri.idStato = sr.id "
			+ "and sr.nome != 'Chiusa' "
			+ "order by ri.priorita, ri.data desc")
	List<AllRichieste> stampaCardAperteAdmin();
	
	@Query("select ri.id as id, ri.data as data, ri.cliente as cliente, ri.citta as citta , ri.costo as costo, "
			+ "ri.note as note , li.nome as linguaggiNome, pro.nome as profiliNome, liv.nome as livelliNome, "
			+ "sr.nome as statiRichiesteNome, ri.priorita as priorita "
			+ "from Richieste ri, Linguaggi li, Profili pro, Livelli liv, StatiRichiesta sr, Dipendenti d "
			+ "where ri.idLivello = liv.id and ri.idLinguaggio = li.id and ri.idProfilo = pro.id and ri.idStato = sr.id "
			+ "and sr.nome != 'Chiusa' and ri.idDipendente = d.id and d.id = :idDipendente "
			+ "order by ri.data desc")
	List<AllRichieste> stampaCardAperteAccount(int idDipendente);
	
	@Query("select ri.id as id, ri.data as data, ri.cliente as cliente, ri.citta as citta , ri.costo as costo, "
			+ "ri.note as note , li.nome as linguaggiNome, pro.nome as profiliNome, liv.nome as livelliNome, "
			+ "sr.nome as statiRichiesteNome, ri.priorita as priorita "
			+ "from Richieste ri, Linguaggi li, Profili pro, Livelli liv, StatiRichiesta sr "
			+ "where ri.idLivello = liv.id and ri.idLinguaggio = li.id and ri.idProfilo = pro.id and ri.idStato = sr.id "
			+ "and sr.nome != 'Chiusa' "
			+ "order by ri.priorita, ri.data desc")
	List<AllRichieste> stampaCardAperteCommerciale();
	
	@Query("select ri.id as id, ri.data as data, ri.cliente as cliente, ri.citta as citta , ri.costo as costo, "
			+ "ri.note as note , li.nome as linguaggiNome, pro.nome as profiliNome, liv.nome as livelliNome, "
			+ "sr.nome as statiRichiesteNome, ri.priorita as priorita "
			+ "from Richieste ri, Linguaggi li, Profili pro, Livelli liv, StatiRichiesta sr "
			+ "where ri.idLivello = liv.id and ri.idLinguaggio = li.id and ri.idProfilo = pro.id and ri.idStato = sr.id "
			+ "and sr.nome != 'Chiusa' and ri.priorita > 0 "
			+ "order by ri.priorita, ri.data desc")
	List<AllRichieste> stampaCardAperteRecruiter();
	
	@Query("select ri.id as id, ri.data as data, ri.cliente as cliente, ri.citta as citta, ri.costo as costo, "
			+ "ri.note as note, li.nome as linguaggiNome, pro.nome as profiliNome, liv.nome as livelliNome, "
			+ "sr.nome as statiRichiestaNome, ri.priorita as priorita, dr.visualizzato as visualizzato "
			+ "from Richieste ri, Linguaggi li, Profili pro, Livelli liv, StatiRichiesta sr, DipendentiRichieste dr "
			+ "where ri.idLivello = liv.id and ri.idLinguaggio = li.id and ri.idProfilo = pro.id and ri.idStato = sr.id and ri.id = dr.idRichiesta "
			+ "and sr.nome != 'Chiusa' and dr.idDipendente = :idDipendente "
			+ "and (ri.recruiter like %:nomeCognome% or ri.recruiter like '%Tutti%') "
			+ "order by ri.priorita, ri.data desc")
	List<AllRichiesteAperte> stampaCardAperte(String nomeCognome, int idDipendente);
	
	@Query("select ri.id as id, ri.data as data, ri.cliente as cliente, ri.citta as citta, ri.costo as costo, "
			+ "ri.note as note, li.nome as linguaggiNome, pro.nome as profiliNome, liv.nome as livelliNome, "
			+ "sr.nome as statiRichiestaNome, ri.recruiter as recruiter "
			+ "from Richieste ri, Linguaggi li, Profili pro, Livelli liv, StatiRichiesta sr "
			+ "where ri.idLivello = liv.id and ri.idLinguaggio = li.id and ri.idProfilo = pro.id and ri.idStato = sr.id "
			+ "and sr.nome = 'Chiusa' "
			+ "order by ri.data desc")
	List<AllRichiesteChiuse> stampaCardChiuse();
	
	@Query("select r.id "
			+ "from Richieste r, StatiRichiesta sr "
			+ "where r.idStato = sr.id "
			+ "and sr.nome != 'Chiusa' "
			+ "order by r.priorita, r.data desc")
	List<Integer> getIdRichiesteAperteAdmin();
	
	@Query("select r.id "
			+ "from Richieste r, StatiRichiesta sr, Dipendenti d "
			+ "where r.idStato = sr.id and r.idDipendente = d.id "
			+ "and sr.nome != 'Chiusa' and r.idDipendente = :idDipendente "
			+ "order by r.data desc")
	List<Integer> getIdRichiesteAperteAccount(int idDipendente);
	
	@Query("select r.id "
			+ "from Richieste r, StatiRichiesta sr "
			+ "where r.idStato = sr.id "
			+ "and sr.nome != 'Chiusa' "
			+ "order by r.priorita, r.data desc")
	List<Integer> getIdRichiesteAperteCommerciale();
	
	@Query("select r.id "
			+ "from Richieste r, StatiRichiesta sr "
			+ "where r.idStato = sr.id "
			+ "and sr.nome != 'Chiusa' and r.priorita > 0 "
			+ "order by r.priorita, r.data desc")
	List<Integer> getIdRichiesteAperteRecruiter();
	
	@Query("select r.id "
			+ "from Richieste r, StatiRichiesta sr "
			+ "where r.idStato = sr.id "
			+ "and sr.nome != 'Chiusa' "
			+ "and (r.recruiter like %:nomeCognome% or r.recruiter like '%Tutti%') "
			+ "order by r.priorita, r.data desc")
	List<Integer> getIdRichiesteAperte(String nomeCognome);
	
	@Query("select r.id "
			+ "from Richieste r, StatiRichiesta sr "
			+ "where r.idStato = sr.id "
			+ "and sr.nome = 'Chiusa' "
			+ "order by r.data desc")
	List<Integer> getIdRichiesteChiuse();
	
	@Query("select max(id) "
			+ " from Richieste")
	Integer getLastId();
	
	@Query("select ri.id as id, ri.data as data, ri.cliente as cliente, ri.citta as citta , ri.costo as costo, "
			+ "ri.note as note , li.nome as linguaggiNome, pro.nome as profiliNome, liv.nome as livelliNome, "
			+ "sr.nome as statiRichiesteNome, ri.recruiter as recruiter, ri.candidati as candidati, ri.priorita as priorita "
			+ "from Richieste ri, Linguaggi li, Profili pro, Livelli liv, StatiRichiesta sr "
			+ "where ri.idLivello = liv.id and ri.idLinguaggio = li.id and ri.idProfilo = pro.id and ri.idStato = sr.id "
			+ "and ri.id = :idRichiesta")
	GetRichiesta visualizzaRichiesta(int idRichiesta);

	@Modifying
	@Transactional
	@Query("update Richieste set priorita = :priorita "
			+ "where id = :idRichiesta")
	void setPriorita(int idRichiesta, int priorita);
	
	@Modifying
	@Transactional
	@Query("update Richieste set idStato = :idStato, priorita = :priorita, recruiter = :recruiter where id = :idRichiesta")
	void updateRichiesta(int idStato, int idRichiesta, int priorita, String recruiter);

	@Modifying
	@Transactional
	@Query("update Richieste set candidati = :listaCandidati where id = :idRichiesta")
	void assegnaCandidati(String listaCandidati, int idRichiesta);
	
	/*@Query("select ri.id, ri.data, ri.cliente, ri.citta, ri.costo, ri.note, li.nome, pro.nome, liv.nome, sr.nome "
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
	Integer getLastId();*/
}