package it.teorema.gestech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import it.teorema.gestech.model.Auth;
import it.teorema.gestech.model.AziendeRisorse;
import it.teorema.gestech.model.Risorse;
import it.teorema.gestech.model.RuoliRisorse;
import it.teorema.gestech.service.AuthService;
import it.teorema.gestech.service.AziendeRisorseService;
import it.teorema.gestech.service.DettagliRisorseService;
import it.teorema.gestech.service.RisorseService;
import it.teorema.gestech.service.RuoliRisorseService;

@Controller
public class UtenteController {
	@Autowired
	RisorseService risorseService;
	@Autowired
	AuthService authService;
	@Autowired
	RuoliRisorseService ruoliRisorseService;
	@Autowired
	DettagliRisorseService dettagliRisorseService;
	@Autowired
	AziendeRisorseService aziendeRisorseService;
	
	@RequestMapping("/salva-utente")
	public ResponseEntity<Integer> salvaUtente(@RequestBody JSONObject formUtente) throws NoSuchAlgorithmException {
		if (risorseService.existsByEmail((String) formUtente.get("email")) != null)
			return new ResponseEntity<>(0, HttpStatus.OK);
		else
		{
			Risorse risorsa = new Risorse();
			Auth auth = new Auth();
			
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate now = LocalDate.now(); 
			
			risorsa.setNomeCognome((String) formUtente.get("nomeCognome"));
			risorsa.setEmail((String) formUtente.get("email"));
			
			risorseService.save(risorsa);
			
			int idRisorsa = risorseService.findIdByEmail((String) formUtente.get("email"));
	        
			auth.setPassword((String)formUtente.get("password"));
			auth.setIdRisorsa(idRisorsa);
			auth.setData(LocalDate.parse(format.format(now), format));
			
			authService.save(auth);
			
			if ((String)formUtente.get("ruolo") != "") {
				List<RuoliRisorse> ruoli = new ArrayList<RuoliRisorse>();
				RuoliRisorse ruoloDipendente = new RuoliRisorse();
				
				ruoloDipendente.setIdRisorsa(idRisorsa);
				ruoloDipendente.setIdRuolo(4);
				ruoli.add(ruoloDipendente);
				
				RuoliRisorse ruoloAlternativo = new RuoliRisorse();
				
				ruoloAlternativo.setIdRisorsa(idRisorsa);
				ruoloAlternativo.setIdRuolo(Integer.parseInt((String) formUtente.get("ruolo")));
				ruoli.add(ruoloAlternativo);
			
				ruoliRisorseService.saveAll(ruoli);
				
			}
			else {
				RuoliRisorse ruoliRisorse = new RuoliRisorse();
				ruoliRisorse.setIdRisorsa(idRisorsa);
				ruoliRisorse.setIdRuolo(4);
				
				ruoliRisorseService.save(ruoliRisorse);
			}
			
			AziendeRisorse aziendeRisorse = new AziendeRisorse();
			
			aziendeRisorse.setIdRisorsa(idRisorsa);
			aziendeRisorse.setIdAzienda(Integer.parseInt((String) formUtente.get("azienda")));
			
			aziendeRisorseService.save(aziendeRisorse);
			
			return new ResponseEntity<>(1, HttpStatus.OK);
		}
	}
}