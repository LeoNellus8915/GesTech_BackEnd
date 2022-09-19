package it.teorema.gestech.controller;

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
import it.teorema.gestech.service.AziendeRisorseService;
import it.teorema.gestech.service.RisorseRichiesteService;
import it.teorema.gestech.service.RisorseService;
import it.teorema.gestech.service.RuoliRisorseService;
import it.teorema.gestech.session.LocalSession;

@Controller
public class LoginController {
	@Autowired
	RisorseService risorseService;
	@Autowired
	AuthService authService;
	@Autowired
	RuoliRisorseService ruoliRisorseService;
	@Autowired
	AziendeRisorseService aziendeRisorseService;
	@Autowired
	RisorseRichiesteService risorseRichiesteService;
	
	@RequestMapping("/login")
	public ResponseEntity<?> login(@RequestBody JSONObject formLogin){
        
        List<Integer> idRisorsa = authService.login((String)formLogin.get("email"), (String)formLogin.get("password"));
        
		if (idRisorsa.size() == 0)
			return new ResponseEntity<>(null, HttpStatus.OK);
		else {
			LocalSession localSession = new LocalSession();
	        localSession.setIdRisorsa(idRisorsa.get(0));
	        localSession.setNomeCognome(risorseService.getNomeCognome(idRisorsa.get(0)));
	        localSession.setNumeroRichieste(risorseRichiesteService.getNumeroRichieste(idRisorsa.get(0)));
	        localSession.setRuolo(ruoliRisorseService.getRuoloByIdRisorsa(idRisorsa.get(0)));
	        localSession.setAzienda(aziendeRisorseService.getAziendaByIdRisorsa(idRisorsa.get(0)));
	        return new ResponseEntity<>(localSession, HttpStatus.OK);
		}
	}
}