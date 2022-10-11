package it.teorema.gestech.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import it.teorema.gestech.model.Auth;
import it.teorema.gestech.model.Persone;
import it.teorema.gestech.model.RuoliPersone;
import it.teorema.gestech.service.AuthService;
import it.teorema.gestech.service.PersoneService;
import it.teorema.gestech.service.RuoliPersoneService;

@Controller
public class DipendentiController {
	
	@Autowired
	PersoneService personeService;
	@Autowired
	AuthService authService;
	@Autowired
	RuoliPersoneService ruoliDipendentiService;
	
	@RequestMapping("/salva-utente")
	public ResponseEntity<Integer> salvaUtente(@RequestBody JSONObject formUtente) {
		if (personeService.existsByEmail((String) formUtente.get("email")) != null ||
				personeService.existsByEmail((String) formUtente.get("email")) != null)
			return new ResponseEntity<>(0, HttpStatus.OK);
		else
		{
			Persone persona = new Persone();
			Auth auth = new Auth();
			
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate now = LocalDate.now(); 
			
			persona.setNome((String) formUtente.get("nome"));
			persona.setCognome((String) formUtente.get("cognome"));
			persona.setEmail((String) formUtente.get("email"));
			
			personeService.save(persona);
			
			int idPersona = personeService.findIdByEmail((String) formUtente.get("email"));
	        
			auth.setPassword((String)formUtente.get("password"));
			auth.setIdPersona(idPersona);
			auth.setData(LocalDate.parse(format.format(now), format));
			
			authService.save(auth);
			
			if ((String)formUtente.get("ruolo") != "") {
				List<RuoliPersone> ruoli = new ArrayList<RuoliPersone>();
				RuoliPersone ruoloPersona = new RuoliPersone();
				
				ruoloPersona.setIdPersona(idPersona);
				ruoloPersona.setIdRuolo(7);
				ruoli.add(ruoloPersona);
				
				RuoliPersone ruoloAlternativo = new RuoliPersone();
				
				ruoloAlternativo.setIdPersona(idPersona);
				ruoloAlternativo.setIdRuolo(Integer.parseInt((String) formUtente.get("ruolo")));
				ruoli.add(ruoloAlternativo);
			
				ruoliDipendentiService.saveAll(ruoli);
				
			}
			else {
				RuoliPersone ruoliRisorse = new RuoliPersone();
				ruoliRisorse.setIdPersona(idPersona);
				ruoliRisorse.setIdRuolo(4);
				
				ruoliDipendentiService.save(ruoliRisorse);
			}			
			return new ResponseEntity<>(1, HttpStatus.OK);
		}
	}
}
