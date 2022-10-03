package it.teorema.gestech.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Beni;

public interface BeniService extends JpaRepository <Beni, Integer> {
	@Query("from Beni where id = :idBene")
	Beni getBene (int idBene);
	
	@Query("from Beni where dataRestituzione IS NULL")
	List<Beni> findBeni ();
	
	@Query("from Beni where dataRestituzione IS NOT NULL")
	List<Beni> findStoricoBeni ();
	
	@Modifying
	@Transactional
	@Query("update Beni set dispositivo = :dispositivo, marca = :marca, modello = :modello, numeroSeriale = :numeroSeriale, "
			+ "password = :password, dipendente = :dipendente, societa = :societa, dataConsegna = :dataConsegna, "
			+ "dataRestituzione = :dataRestituzione, note = :note where id = :idBene")
	void modificaBene(int idBene, String dispositivo, String marca, String modello, String numeroSeriale, String password,
			String dipendente, String societa, LocalDate dataConsegna, LocalDate dataRestituzione, String note);

	@Query("select id "
			+ "from Beni ")
	List<Integer> getIdBeni();

	@Query("select max(id) from Beni")
	Integer getLastId();
}