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

import it.teorema.gestech.model.DipendentiCCNL;
import it.teorema.gestech.service.AuthService;
import it.teorema.gestech.service.AziendeDipendentiService;
import it.teorema.gestech.service.CCNLService;
import it.teorema.gestech.service.DipendentiCCNLService;
import it.teorema.gestech.service.DipendentiRichiesteService;
import it.teorema.gestech.service.DipendentiService;
import it.teorema.gestech.service.RuoliDipendentiService;
import it.teorema.gestech.session.LocalSession;

@Controller
public class LoginController {
	@Autowired
	DipendentiService dipendentiService;
	@Autowired
	AuthService authService;
	@Autowired
	RuoliDipendentiService ruoliDipendentiService;
	@Autowired
	AziendeDipendentiService aziendeDipendentiService;
	@Autowired
	DipendentiRichiesteService dipendentiRichiesteService;
	@Autowired
	CCNLService ccnlService;
	@Autowired
	DipendentiCCNLService dipendentiCCNLService;
	
	@RequestMapping("/login")
	public ResponseEntity<?> login(@RequestBody JSONObject formLogin){
        
        List<Integer> idDipendente = authService.login((String)formLogin.get("email"), (String)formLogin.get("password"));
        
		if (idDipendente.size() == 0)
			return new ResponseEntity<>(null, HttpStatus.OK);
		else {
			LocalSession localSession = new LocalSession();
	        localSession.setIdDipendente(idDipendente.get(0));
	        localSession.setNomeCognome(dipendentiService.getNomeCognome(idDipendente.get(0)));
	        localSession.setNumeroRichieste(dipendentiRichiesteService.getNumeroRichieste(idDipendente.get(0)));
	        localSession.setRuolo(ruoliDipendentiService.getRuoloByIdDipendente(idDipendente.get(0)));
	        localSession.setAzienda(aziendeDipendentiService.getAziendaByIdDipendente(idDipendente.get(0)));
	        return new ResponseEntity<>(localSession, HttpStatus.OK);
		}
	}
	
	@RequestMapping("/controllo-download/{idDipendente}")
	public ResponseEntity<List<String>> controlloDownload(@PathVariable("idDipendente") int idDipendente) {
		List<String> lista = new ArrayList<String>();
		lista.add(ccnlService.controlloDownload(idDipendente));
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@RequestMapping("/download/{idDipendente}")
	public ResponseEntity<?> download(@PathVariable("idDipendente") int idDipendente) {
		DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
		LocalDateTime now = LocalDateTime.now();  
		LocalDateTime data = LocalDateTime.parse(format1.format(now), format1);	
		
		DipendentiCCNL dipendentiCCNL = new DipendentiCCNL();
		dipendentiCCNL.setIdDipendente(idDipendente);
		dipendentiCCNL.setDataDownload(data);
		
		dipendentiCCNLService.save(dipendentiCCNL);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}