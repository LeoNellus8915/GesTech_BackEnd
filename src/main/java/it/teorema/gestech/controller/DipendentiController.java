package it.teorema.gestech.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import it.teorema.gestech.model.Auth;
import it.teorema.gestech.model.Contratti;
import it.teorema.gestech.model.Persone;
import it.teorema.gestech.model.RuoliPersone;
import it.teorema.gestech.model.mapper.AllDipendenti;
import it.teorema.gestech.service.AuthService;
import it.teorema.gestech.service.ContrattiService;
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
	@Autowired
	ContrattiService contrattiService;
	@Autowired
	SecurityController securityController;

	@RequestMapping("/salva-utente")
	public ResponseEntity<Integer> salvaUtente(@RequestBody JSONObject formUtente, HttpServletRequest request) {
		if (securityController.controlloToken(request.getHeader("App-Key")) == false)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else {
			if (personeService.existsByEmail((String) formUtente.get("email")) != null
					|| personeService.existsByEmail((String) formUtente.get("email")) != null)
				return new ResponseEntity<>(0, HttpStatus.OK);
			else {
				Persone persona = new Persone();
				Auth auth = new Auth();

				DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate now = LocalDate.now();

				persona.setNome((String) formUtente.get("nome"));
				persona.setCognome((String) formUtente.get("cognome"));
				persona.setEmail((String) formUtente.get("email"));

				personeService.save(persona);

				int idPersona = personeService.findIdByEmail((String) formUtente.get("email"));

				auth.setPassword((String) formUtente.get("password"));
				auth.setIdPersona(idPersona);
				auth.setData(LocalDate.parse(format.format(now), format));

				authService.save(auth);

				if ((String) formUtente.get("ruolo") != "") {
					List<RuoliPersone> ruoli = new ArrayList<RuoliPersone>();
					RuoliPersone ruoloPersona = new RuoliPersone();

					RuoliPersone ruoloAlternativo = new RuoliPersone();

					ruoloAlternativo.setIdPersona(idPersona);
					ruoloAlternativo.setIdRuolo(Integer.parseInt((String) formUtente.get("ruolo")));
					ruoli.add(ruoloAlternativo);

					ruoloPersona.setIdPersona(idPersona);
					ruoloPersona.setIdRuolo(ruoliDipendentiService.getIdRuoloDipendente());
					ruoli.add(ruoloPersona);

					ruoliDipendentiService.saveAll(ruoli);

				} else {
					RuoliPersone ruoliRisorse = new RuoliPersone();
					ruoliRisorse.setIdPersona(idPersona);
					ruoliRisorse.setIdRuolo(4);

					ruoliDipendentiService.save(ruoliRisorse);

				}
				Contratti newContract = new Contratti();

				newContract.setIdPersona(idPersona);
				newContract.setIdAzienda(Integer.parseInt((String) formUtente.get("azienda")));

				contrattiService.save(newContract);

				return new ResponseEntity<>(1, HttpStatus.OK);
			}
		}

	}

	@RequestMapping("/all-dipendenti")
	public ResponseEntity<List<AllDipendenti>> allDipendenti(HttpServletRequest request) {
		if (securityController.controlloToken(request.getHeader("App-Key")) == false)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else {
			List<AllDipendenti> dipendenti = personeService.getAllDipendenti();
			return new ResponseEntity<>(dipendenti, HttpStatus.OK);
		}
	}
//	@RequestMapping("/get-dipendenti")
//	public ResponseEntity<AllDipendenti> getDipendenti() {
//		return new ResponseEntity<> (personeService.getDipendenti(), HttpStatus.OK);
//	}
}
