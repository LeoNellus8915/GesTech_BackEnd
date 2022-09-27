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
	@Query("update Auth set password = :password where idDipendente = :idDipendente")
	void changePassword(String password, int idDipendente);
	
	@Query("select d.id "
			+ "from Dipendenti d, Auth a, RuoliDipendenti rd "
			+ "where d.id = a.idDipendente and d.id = rd.idDipendente and d.email = :email and a.password = :password")
	List<Integer> login(String email, String password);
}