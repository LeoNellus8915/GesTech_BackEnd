package it.teorema.gestech.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Hardware;

public interface HardwareService extends JpaRepository <Hardware, Integer> {
	@Query("from Hardware where id = :idHardware")
	Hardware getHardware (int idHardware);
	
	@Query("from Hardware where dataRestituzione IS NULL")
	List<Hardware> findHardware ();
	
	@Query("from Hardware where dataRestituzione IS NOT NULL")
	List<Hardware> findStoricoHardware ();
	
	@Modifying
	@Transactional
	@Query("update Hardware set idDispositivo = :idDispositivo, marca = :marca, modello = :modello, numeroSeriale = :numeroSeriale, "
			+ "password = :password, idPersona = :idPersona, societa = :societa, dataConsegna = :dataConsegna, "
			+ "note = :note where id = :idHardware")
	void modificaHardware(int idHardware, int idDispositivo, String marca, String modello, String numeroSeriale,
			int idPersona, LocalDate dataConsegna, String note);
	
	@Modifying
	@Transactional
	@Query("update Hardware set idDispositivo = :idDispositivo, marca = :marca, modello = :modello, numeroSeriale = :numeroSeriale, "
			+ "password = :password, idPersona = NULL, societa = :societa, dataConsegna = NULL, "
			+ "dataRestituzione = null, note = :note where id = :idHardware")
	void modificaHardwareRestituito(int idHardware, int idDispositivo, String marca, String modello, 
			String numeroSeriale, String societa, String note);

	@Query("select id "
			+ "from Hardware ")
	List<Integer> getListaIdHardware();

	@Query("select max(id) from Hardware")
	Integer getLastHardwareId();
}