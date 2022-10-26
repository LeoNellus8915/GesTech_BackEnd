package it.teorema.gestech.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Session;

public interface SessionService extends JpaRepository <Session, Integer> {

	@Transactional
	@Modifying
	@Query("delete from Session where idPersona = :idDipendente")
	void deleteTokensById(Integer idDipendente);

	@Transactional
	@Modifying
	@Query("delete from Session where datediff(:data, data) > 7")
	void deleteAllOldToken(LocalDateTime data);

	@Query("select data "
			+ "from Session "
			+ "where token = :token")
	LocalDateTime getData(String token);

	@Transactional
	@Modifying
	@Query("update Session set data = :data where token = :token")
	void updateData(LocalDateTime data, String token);	
}