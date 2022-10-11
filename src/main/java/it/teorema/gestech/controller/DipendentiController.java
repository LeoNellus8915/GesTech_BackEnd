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
import it.teorema.gestech.model.AziendeDipendenti;
import it.teorema.gestech.model.Dipendenti;
import it.teorema.gestech.model.RuoliPersona;
import it.teorema.gestech.model.mapper.AllDipendenti;
import it.teorema.gestech.service.AuthService;
import it.teorema.gestech.service.AziendeDipendentiService;
import it.teorema.gestech.service.CandidatiService;
import it.teorema.gestech.service.DettagliDipendentiService;
import it.teorema.gestech.service.PersoneService;
import it.teorema.gestech.service.RuoliDipendentiService;

@Controller
public class DipendentiController {
	
	@Autowired
	DettagliDipendentiService dettagliDipendentiService;
	@Autowired
	PersoneService dipendentiService;
	@Autowired
	CandidatiService candidatiService;
	@Autowired
	AuthService authService;
	@Autowired
	RuoliDipendentiService ruoliDipendentiService;
	@Autowired
	AziendeDipendentiService aziendeDipendentiService;
	
	@RequestMapping("/all-dipendenti")
	public ResponseEntity<List<AllDipendenti>> allDipendenti() {
		return new ResponseEntity<>(dettagliDipendentiService.allDipendenti(), HttpStatus.OK);
	}
	
	@RequestMapping("/get-dipendenti")
	public ResponseEntity<String[]> getDipendenti() {
		return new ResponseEntity<> (dipendentiService.getDipendenti(), HttpStatus.OK);
	}
	
	@RequestMapping("/salva-utente")
	public ResponseEntity<Integer> salvaUtente(@RequestBody JSONObject formUtente) {
		if (candidatiService.existsByEmail((String) formUtente.get("email")) != null ||
				dipendentiService.existsByEmail((String) formUtente.get("email")) != null)
			return new ResponseEntity<>(0, HttpStatus.OK);
		else
		{
			Dipendenti dipendente = new Dipendenti();
			Auth auth = new Auth();
			
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate now = LocalDate.now(); 
			
			dipendente.setNomeCognome((String) formUtente.get("nomeCognome"));
			dipendente.setEmail((String) formUtente.get("email"));
			
			dipendentiService.save(dipendente);
			
			int idDipendente = dipendentiService.findIdByEmail((String) formUtente.get("email"));
	        
			auth.setPassword((String)formUtente.get("password"));
			auth.setIdDipendente(idDipendente);
			auth.setData(LocalDate.parse(format.format(now), format));
			
			authService.save(auth);
			
			if ((String)formUtente.get("ruolo") != "") {
				List<RuoliPersona> ruoli = new ArrayList<RuoliPersona>();
				RuoliPersona ruoloDipendente = new RuoliPersona();
				
				ruoloDipendente.setIdDipendente(idDipendente);
				ruoloDipendente.setIdRuolo(7);
				ruoli.add(ruoloDipendente);
				
				RuoliPersona ruoloAlternativo = new RuoliPersona();
				
				ruoloAlternativo.setIdDipendente(idDipendente);
				ruoloAlternativo.setIdRuolo(Integer.parseInt((String) formUtente.get("ruolo")));
				ruoli.add(ruoloAlternativo);
			
				ruoliDipendentiService.saveAll(ruoli);
				
			}
			else {
				RuoliPersona ruoliRisorse = new RuoliPersona();
				ruoliRisorse.setIdDipendente(idDipendente);
				ruoliRisorse.setIdRuolo(4);
				
				ruoliDipendentiService.save(ruoliRisorse);
			}
			
			AziendeDipendenti aziendeDipendenti = new AziendeDipendenti();
			
			aziendeDipendenti.setIdDipendente(idDipendente);
			aziendeDipendenti.setIdAzienda(Integer.parseInt((String) formUtente.get("azienda")));
			
			aziendeDipendentiService.save(aziendeDipendenti);
			
			return new ResponseEntity<>(1, HttpStatus.OK);
		}
	}
}
