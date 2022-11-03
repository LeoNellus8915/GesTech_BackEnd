package it.teorema.gestech.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.teorema.gestech.model.Richieste;
import it.teorema.gestech.model.mapper.AllCandidati;
import it.teorema.gestech.model.mapper.AllRichieste;
import it.teorema.gestech.model.mapper.AllRichiesteAperte;
import it.teorema.gestech.model.mapper.AllRichiesteChiuse;
import it.teorema.gestech.model.mapper.GetRichiesta;

public interface RichiesteService extends JpaRepository <Richieste, Integer> {
	
	@Query("select ri.id as id, ri.data as data, c.nome as cliente, ri.citta as citta , ri.costo as costo, "
			+ "ri.note as note , li.nome as linguaggiNome, pro.nome as profiliNome, liv.nome as livelliNome, "
			+ "sr.nome as statiRichiesteNome, ri.priorita as priorita, ri.recruiter as recruiters "
			+ "from Richieste ri, Linguaggi li, Profili pro, Livelli liv, StatiRichiesta sr, Clienti c "
			+ "where ri.idLivello = liv.id and ri.idLinguaggio = li.id and ri.idProfilo = pro.id and ri.idStato = sr.id "
			+ "and ri.idCliente = c.id and sr.nome != 'Chiusa' "
			+ "order by ri.priorita, ri.data desc")
	List<AllRichieste> stampaCardAperteAdmin();
	
	@Query("select ri.id as id, ri.data as data, c.nome as cliente, ri.citta as citta , ri.costo as costo, "
			+ "ri.note as note , li.nome as linguaggiNome, pro.nome as profiliNome, liv.nome as livelliNome, "
			+ "sr.nome as statiRichiesteNome, ri.priorita as priorita, ri.recruiter as recruiters "
			+ "from Richieste ri, Linguaggi li, Profili pro, Livelli liv, StatiRichiesta sr, Persone p, Clienti c "
			+ "where ri.idLivello = liv.id and ri.idLinguaggio = li.id and ri.idProfilo = pro.id and ri.idStato = sr.id "
			+ "and ri.idCliente = c.id and sr.nome != 'Chiusa' and ri.idPersona = p.id and p.id = :idPersona "
			+ "order by ri.data desc")
	List<AllRichieste> stampaCardAperteAccount(int idPersona);
	
	@Query("select ri.id as id, ri.data as data, c.nome as cliente, ri.citta as citta , ri.costo as costo, "
			+ "ri.note as note , li.nome as linguaggiNome, pro.nome as profiliNome, liv.nome as livelliNome, "
			+ "sr.nome as statiRichiesteNome, ri.priorita as priorita, ri.recruiter as recruiters "
			+ "from Richieste ri, Linguaggi li, Profili pro, Livelli liv, StatiRichiesta sr, Clienti c "
			+ "where ri.idLivello = liv.id and ri.idLinguaggio = li.id and ri.idProfilo = pro.id and ri.idStato = sr.id "
			+ "and ri.idCliente = c.id and sr.nome != 'Chiusa' "
			+ "order by ri.priorita, ri.data desc")
	List<AllRichieste> stampaCardAperteCommerciale();
	
	@Query("select ri.id as id, ri.data as data, c.nome as cliente, ri.citta as citta , ri.costo as costo, "
			+ "ri.note as note , li.nome as linguaggiNome, pro.nome as profiliNome, liv.nome as livelliNome, "
			+ "sr.nome as statiRichiesteNome, ri.priorita as priorita, ri.recruiter as recruiters "
			+ "from Richieste ri, Linguaggi li, Profili pro, Livelli liv, StatiRichiesta sr, Clienti c "
			+ "where ri.idLivello = liv.id and ri.idLinguaggio = li.id and ri.idProfilo = pro.id and ri.idStato = sr.id "
			+ "and ri.idCliente = c.id and sr.nome != 'Chiusa' and ri.priorita > 0 "
			+ "order by ri.priorita, ri.data desc")
	List<AllRichieste> stampaCardAperteRecruiter();
	
	/*@Query("select ri.id as id, ri.data as data, c.nome as cliente, ri.citta as citta, ri.costo as costo, "
			+ "ri.note as note, li.nome as linguaggiNome, pro.nome as profiliNome, liv.nome as livelliNome, "
			+ "sr.nome as statiRichiesteNome, ri.priorita as priorita, rp.visualizzato as visualizzato "
			+ "from Richieste ri, Linguaggi li, Profili pro, Livelli liv, StatiRichiesta sr, "
			+ "RichiestePersone rp, Clienti c "
			+ "where ri.idLivello = liv.id and ri.idLinguaggio = li.id and ri.idProfilo = pro.id and "
			+ "ri.idStato = sr.id and ri.id = rp.idRichiesta "
			+ "and ri.idCliente = c.id and sr.nome != 'Chiusa' and rp.idPersona = :idPersona "
			+ "and (ri.recruiter like %:nomeCognome% or ri.recruiter like '%Tutti%') "
			+ "order by ri.priorita, ri.data desc")
	List<AllRichiesteAperte> stampaCardAperte(String nomeCognome, int idPersona);*/  //quella vecchia
	
	@Query("select ri.id as id, ri.data as data, c.nome as cliente, ri.citta as citta, ri.costo as costo, "
			+ "ri.note as note, li.nome as linguaggiNome, pro.nome as profiliNome, liv.nome as livelliNome, "
			+ "sr.nome as statiRichiesteNome, ri.priorita as priorita, rp.visualizzato as visualizzato "
			+ "from Richieste ri, Linguaggi li, Profili pro, Livelli liv, StatiRichiesta sr, "
			+ "RichiestePersone rp, Clienti c "
			+ "where ri.idLivello = liv.id and ri.idLinguaggio = li.id and ri.idProfilo = pro.id and "
			+ "ri.idStato = sr.id and ri.id = rp.idRichiesta "
			+ "and ri.idCliente = c.id and sr.nome != 'Chiusa' and rp.idPersona = :idPersona "
			+ "and ri.recruiter like %:nomeCognome% "
			+ "order by ri.priorita, ri.data desc")
	List<AllRichiesteAperte> stampaCardAperte(String nomeCognome, int idPersona);
	
	@Query("select ri.id as id, ri.data as data, c.nome as cliente, ri.citta as citta, ri.costo as costo, "
			+ "ri.note as note, li.nome as linguaggiNome, pro.nome as profiliNome, liv.nome as livelliNome, "
			+ "sr.nome as statiRichiesteNome, ri.recruiter as recruiter "
			+ "from Richieste ri, Linguaggi li, Profili pro, Livelli liv, StatiRichiesta sr, Clienti c "
			+ "where ri.idLivello = liv.id and ri.idLinguaggio = li.id and ri.idProfilo = pro.id and ri.idStato = sr.id "
			+ "and ri.idCliente = c.id and sr.nome = 'Chiusa' "
			+ "order by ri.data desc")
	List<AllRichiesteChiuse> stampaCardChiuse();
	
	@Query("select r.id "
			+ "from Richieste r, StatiRichiesta sr "
			+ "where r.idStato = sr.id "
			+ "and sr.nome != 'Chiusa' "
			+ "order by r.priorita, r.data desc")
	List<Integer> getIdRichiesteAperteAdmin();
	
	@Query("select r.id "
			+ "from Richieste r, StatiRichiesta sr, Persone p "
			+ "where r.idStato = sr.id and r.idPersona = p.id "
			+ "and sr.nome != 'Chiusa' and r.idPersona = :idDipendente "
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
			+ "and (r.recruiter like %:cognomeNome% or r.recruiter like '%Tutti%') "
			+ "order by r.priorita, r.data desc")
	List<Integer> getIdRichiesteAperte(String cognomeNome);
	
	@Query("select r.id "
			+ "from Richieste r, StatiRichiesta sr "
			+ "where r.idStato = sr.id "
			+ "and sr.nome = 'Chiusa' "
			+ "order by r.data desc")
	List<Integer> getIdRichiesteChiuse();
	
	@Query("select max(id) "
			+ "from Richieste")
	Integer getLastId();
	
	@Query("select ri.id as id, ri.data as data, ri.idCliente as cliente, ri.citta as citta , ri.costo as costo, "
			+ "ri.note as note , li.nome as linguaggiNome, pro.nome as profiliNome, liv.nome as livelliNome, "
			+ "sr.nome as statiRichiesteNome, ri.recruiter as recruiter, ri.priorita as priorita "
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
	@Query("update Richieste "
			+ "set idStato = 3 "
			+ "where id = :idRichiesta")
	void setStato(int idRichiesta);
	
	//da ottimizzare con classe mapper quando decidimo i campi dei candidati da stampare
	//nella tabella della richiesta
	
	@Query("select p.id as id, dc.dataInserimento as dataInserimento, p.nome as nome, p.cognome as cognome, "
			+ "pf.nome as profiloNome, dc.competenzaPrincipale as competenzaPrincipale, ec.nome as esitoNome, "
			+ "p.cittaDiResidenza as citta "
			+ "from Persone p, DettagliCandidati dc, Profili pf, EsitiColloquio ec, "
			+ "RichiesteDettagliCandidati rdc "
			+ "where p.id = dc.idPersona and "
			+ "dc.idEsitoColloquio = ec.id and rdc.idDettaglioCandidato = dc.id and rdc.idRichiesta = :idRichiesta "
			+ "group by p.id")
	List<AllCandidati> getCandidatiSelezionati(int idRichiesta);
	
	@Modifying
	@Transactional
	@Query("update Richieste "
			+ "set idStato = :#{#richiesta.idStato}, recruiter = :#{#richiesta.recruiter}, priorita = :#{#richiesta.priorita} "
			+ "where id = :#{#richiesta.id}")
	void updateRichiesta(@Param("richiesta") Richieste richiesta);

	

	/*@Modifying
	@Transactional
	@Query("update Richieste set candidati = :listaCandidati where id = :idRichiesta")
	void assegnaCandidati(String listaCandidati, int idRichiesta);*/
}