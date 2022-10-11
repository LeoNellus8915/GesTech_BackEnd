package it.teorema.gestech.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import it.teorema.gestech.service.AuthService;
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
	
	@RequestMapping("/login")
	public ResponseEntity<?> login(@RequestBody JSONObject formLogin){
        
        List<Integer> listaIdDipendente = authService.login((String)formLogin.get("email"), (String)formLogin.get("password"));
        
		if (listaIdDipendente.size() == 0)
			return new ResponseEntity<>(null, HttpStatus.OK);
		else {
			LocalSession localSession = new LocalSession();
	        localSession.setIdDipendente(listaIdDipendente.get(0));
	        localSession.setNome(personeService.getNomeCognome(listaIdDipendente.get(0)).getNome());
	        localSession.setCognome(personeService.getNomeCognome(listaIdDipendente.get(0)).getCognome());
	        localSession.setNumeroRichieste(dipendentiRichiesteService.getNumeroRichieste(listaIdDipendente.get(0)));
	        localSession.setRuolo(ruoliDipendentiService.getRuoloByIdPersona(listaIdDipendente.get(0)));
	        return new ResponseEntity<>(localSession, HttpStatus.OK);
		}
	}
}