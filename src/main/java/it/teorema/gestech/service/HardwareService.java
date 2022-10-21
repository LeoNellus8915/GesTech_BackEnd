package it.teorema.gestech.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Hardware;
import it.teorema.gestech.model.mapper.AllHardware;

public interface HardwareService extends JpaRepository <Hardware, Integer> {
	@Query("from Hardware where id = :idHardware")
	Hardware getHardware (int idHardware);
	
	@Query("from Hardware where dataRestituzione IS NULL")
	List<Hardware> findHardware ();
	
	@Query("select h.id as id, p.nome as nomePersona, p.cognome as cognomePersona, d.nome as nomeDispositivo, h.modello as modello, h.marca as marca, h.dataRestituzione as dataRestituzione, h.dataConsegna as dataConsegna "
			+"from Persone p, Dispositivi d, Hardware h "
			+"where p.id = h.idPersona and h.idDispositivo = d.id and h.dataRestituzione IS NULL")
	List<AllHardware> allHardware();
	
	@Query("select h.id as id, p.nome as nomePersona, p.cognome as cognomePersona, d.nome as nomeDispositivo, h.modello as modello, h.marca as marca, h.dataRestituzione as dataRestituzione, h.dataConsegna as dataConsegna, h.note as note, h.seriale as seriale "
			+"from Persone p, Dispositivi d, Hardware h "
			+"where p.id = h.idPersona and h.idDispositivo = d.id and h.id = :idHardware")
	AllHardware getMapperHardware(int idHardware);
	
	
	
	@Query("select h.id as id, p.nome as nomePersona, p.cognome as cognomePersona, d.nome as nomeDispositivo, h.modello as modello, h.marca as marca, h.dataRestituzione as dataRestituzione, h.dataConsegna as dataConsegna, h.note as note "
			+"from Persone p, Dispositivi d, Hardware h "
			+"where p.id = h.idPersona and h.idDispositivo = d.id and h.dataRestituzione IS NOT NULL")
	List<AllHardware> findStoricoHardware ();
	
	/*@Modifying
	@Transactional
	@Query("update Hardware set idDispositivo = :idDispositivo, marca = :marca, "
			+ "modello = :modello, seriale = :seriale, "
			+ "idPersona = :idPersona, dataConsegna = :dataConsegna, "
			+ "note = :note "
			+ "where id = :idHardware")
	void modificaHardware(int idHardware, int idDispositivo, String marca, String modello, String seriale,
			int idPersona, LocalDate dataConsegna, String note);*/
	
	/*@Modifying
	@Transactional
	@Query("update Hardware set idDispositivo = :idDispositivo, marca = :marca, modello = :modello, seriale = :seriale, "
			+ "idPersona = NULL, dataConsegna = NULL, "
			+ "dataRestituzione = null, note = :note where id = :idHardware")
	void modificaHardwareRestituito(int idHardware, int idDispositivo, String marca, String modello, 
			String seriale, String note);*/
	
	@Modifying
	@Transactional
	@Query("update Hardware "
			+ "set idPersona = :idDipendente, idDispositivo = :idDispositivo, "
			+ "marca = :marca, modello = :modello, seriale = :seriale, dataConsegna = :dataConsegna, "
			+ "dataRestituzione = :dataRestituzione, note = :note "
			+ "where id = :idHardware")
	void modificaHardware(int idHardware, int idDipendente, int idDispositivo, String marca, String modello, String seriale, LocalDate dataConsegna, LocalDate dataRestituzione, String note);

	@Query("select id "
			+ "from Hardware ")
	List<Integer> getListaIdHardware();

	@Query("select max(id) from Hardware")
	Integer getLastHardwareId();
}