package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.RuoliPersone;

public interface RuoliPersoneService extends JpaRepository <RuoliPersone, Integer>{
	
	@Query("select r.nome "
			+ "from RuoliPersone rp, Ruoli r "
			+ "where rp.idRuolo = r.id and rp.idPersona = :idPersona")
	List<String> getRuoloByIdPersona(int idPersona);
	
	@Query("select r.nome "
			+ "from RuoliPersone rp, Ruoli r "
			+ "where rp.idRuolo = r.id and rp.idPersona = :idPersona and r.nome != 'Dipendente'")
	String getSecondoRuoloByIdPersona(int idPersona);
	
	@Query("select rl.id "
			+"from Ruoli rl "
			+"where rl.nome like '%Dipendente%' ")
	int getIdRuoloDipendente();
}