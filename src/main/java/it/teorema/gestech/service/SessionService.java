package it.teorema.gestech.service;

import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Session;

public interface SessionService extends JpaRepository <Session, Integer> {	
	
	@Modifying
	@Transactional
	@Query("delete from Session where idPersona = :id_persona")
	void deleteTokenPersona(int id_persona);
	
	@Modifying
	@Transactional
	@Query("select data from Session where token = :token")
	Date getDateByToken(String token);
}