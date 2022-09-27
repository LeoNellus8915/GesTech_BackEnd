package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.CCNL;

public interface CCNLService extends JpaRepository <CCNL, Integer> {
	
	@Query("select cc.ccnl "
			+ "from CCNL cc, AziendeDipendenti ad, Dipendenti d "
			+ "where cc.idAzienda = ad.idAzienda and d.id = ad.idDipendente and d.id = :idDipendente and not exists "
			+ "(select id from DipendentiCCNL where idDipendente = :idDipendente)")
	String controlloDownload(int idDipendente);
}