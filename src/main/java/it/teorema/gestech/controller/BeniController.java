package it.teorema.gestech.controller;

import java.time.LocalDate;
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

import it.teorema.gestech.model.Beni;
import it.teorema.gestech.service.BeniService;
import it.teorema.gestech.service.RisorseService;

@Controller
public class BeniController {
	@Autowired
	BeniService beniService;
	@Autowired
	RisorseService risorseService;
	
	@RequestMapping("/all-beni")
	public ResponseEntity<List<Object>> allBeni() {
		List<Object> lista = new ArrayList<>();
		lista.add(beniService.findAll());
		lista.add(SecurityController.getListaCodiciBeni());
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@RequestMapping("/salva-bene")
	public ResponseEntity<?> salvaBene(@RequestBody Beni bene) {
		beniService.save(bene);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping("/get-bene-visualizza/{codiceBene}")
	public ResponseEntity<Beni> getBeneVisualizza(@PathVariable("codiceBene") String codiceBene) {
		int idBene = 0;
		List<JSONObject> listaCodici = SecurityController.getListaCodiciBeni();
		
		for (JSONObject codice : listaCodici)
			if (((String)codice.get(("codice"))).equals(codiceBene))
				idBene = (Integer)codice.get("id");
		
		return new ResponseEntity<>(beniService.getBene(idBene), HttpStatus.OK);
	}
	
	@RequestMapping("/get-bene-modifica/{codiceBene}")
	public ResponseEntity<List<Object>> getBeneModifica(@PathVariable("codiceBene") String codiceBene) {
		List<Object> lista = new ArrayList<>();
		
		int idBene = 0;
		List<JSONObject> listaCodici = SecurityController.getListaCodiciBeni();
		
		for (JSONObject codice : listaCodici)
			if (((String)codice.get(("codice"))).equals(codiceBene))
				idBene = (Integer)codice.get("id");
		
		Beni bene = beniService.getBene(idBene);
		lista.add(bene);
		lista.add(risorseService.findAllException(bene.getDipendente()));
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@RequestMapping("/modifica-bene")
	public ResponseEntity<?> modificaBene(@RequestBody JSONObject bene) {
		int idBene = 0;
		List<JSONObject> listaCodici = SecurityController.getListaCodiciBeni();
		
		for (JSONObject codice : listaCodici)
			if (((String)codice.get(("codice"))).equals((String)bene.get("id")))
				idBene = (Integer)codice.get("id");
		
		beniService.modificaBene(idBene, (String)bene.get("dispositivo"), (String)bene.get("marca"), (String)bene.get("modello"), 
				(String)bene.get("numeroSeriale"), (String)bene.get("password"), (String)bene.get("dipendente"), (String)bene.get("societa"), 
				LocalDate.parse((String)bene.get("dataConsegna")), LocalDate.parse((String)bene.get("dataRestituzione")), 
				(String)bene.get("note"));
		return new ResponseEntity<>(HttpStatus.OK);
	}
}