package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.CCNL;

public interface CCNLService extends JpaRepository <CCNL, Integer> {
	
	@Query("select cc.ccnl "
			+ "from CCNL cc, AziendeRisorse ar, Risorse r "
			+ "where cc.idAzienda = ar.idAzienda and r.id = ar.idRisorsa and r.id = :idRisorsa and not exists "
			+ "(select id from RisorseCCNL where idRisorsa = :idRisorsa)")
	String controlloDownload(int idRisorsa);
}