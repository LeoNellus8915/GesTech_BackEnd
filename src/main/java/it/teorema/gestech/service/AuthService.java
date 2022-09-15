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
	@Query("update Auth set password = :password where idRisorsa = :idRisorsa")
	void changePassword(String password, int idRisorsa);
	
	@Query("select r.id "
			+ "from Risorse r, Auth a, RuoliRisorse rr "
			+ "where r.id = a.idRisorsa and r.id = rr.idRisorsa and r.email = :email and a.password = :password")
	List<Integer> login(String email, String password);
}