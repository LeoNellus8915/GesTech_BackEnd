 package it.teorema.gestech.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Auth;

public interface AuthService extends JpaRepository <Auth, Integer> {
	@Modifying
	@Transactional
	@Query("update Auth set password = :password where idPersona = :idPersona")
	void changePassword(String password, int idPersona);
	
	@Query("select p.id "
			+ "from Persone p, Auth a, RuoliPersone rp "
			+ "where p.id = a.idPersona and p.id = rp.idPersona and p.email = :email and a.password = :password")
	List<Integer> login(String email, String password);
}