package it.teorema.gestech.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import it.teorema.gestech.model.Persone;
import it.teorema.gestech.service.AuthService;
import it.teorema.gestech.service.ContrattiService;
import it.teorema.gestech.service.RichiestePersoneService;
import it.teorema.gestech.service.PersoneService;
import it.teorema.gestech.service.RuoliPersoneService;
import it.teorema.gestech.session.LocalSession;

@Controller
public class LoginController {
	@Autowired
	PersoneService personeService;
	@Autowired
	AuthService authService;
	@Autowired
	RuoliPersoneService ruoliDipendentiService;
	@Autowired
	RichiestePersoneService dipendentiRichiesteService;
	@Autowired
	ContrattiService contrattiService;
	
	@RequestMapping("/login")
	public ResponseEntity<?> login(@RequestBody JSONObject formLogin){
        
        Integer idDipendente = authService.login((String)formLogin.get("email"), (String)formLogin.get("password"));
        
		if (idDipendente == null)
			return new ResponseEntity<>(null, HttpStatus.OK);
		else {
			LocalSession localSession = new LocalSession();
	        localSession.setIdDipendente(idDipendente);
	        Persone persona = personeService.findByIdPersona(idDipendente);
	        localSession.setNome(persona.getNome());
	        localSession.setCognome(persona.getCognome());
	        localSession.setNumeroRichieste(dipendentiRichiesteService.getNumeroRichieste(idDipendente));
	        localSession.setRuolo(ruoliDipendentiService.getRuoloByIdPersona(idDipendente));
	        localSession.setAzienda(contrattiService.getAziendaByIdPersona(idDipendente));
	        return new ResponseEntity<>(localSession, HttpStatus.OK);
		}
	}
}