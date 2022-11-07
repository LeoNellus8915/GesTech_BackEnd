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
import it.teorema.gestech.service.AuthService;
import it.teorema.gestech.service.ContrattiService;
import it.teorema.gestech.service.PersoneService;
import it.teorema.gestech.service.RuoliPersoneService;
import it.teorema.gestech.utils.ResponseHttp;

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
	public ResponseEntity<ResponseHttp> salvaUtente(@RequestBody JSONObject formUtente, HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			responseHttp.setCode("1");
			
			if (personeService.existsByEmail((String) formUtente.get("email")) != null
					|| personeService.existsByEmail((String) formUtente.get("email")) != null) {
				responseHttp.setDataSource(0);
				return new ResponseEntity<> (responseHttp, HttpStatus.OK); 
			}
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

				responseHttp.setDataSource(1);
				return new ResponseEntity<> (responseHttp, HttpStatus.OK); 
			}
		}

	}

	@RequestMapping("/all-dipendenti")
	public ResponseEntity<ResponseHttp> allDipendenti(HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			responseHttp.setDataSource(personeService.getAllDipendenti());
			responseHttp.setCodeSession("1");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
	}
//	@RequestMapping("/get-dipendenti")
//	public ResponseEntity<AllDipendenti> getDipendenti() {
//		return new ResponseEntity<> (personeService.getDipendenti(), HttpStatus.OK);
//	}
}
