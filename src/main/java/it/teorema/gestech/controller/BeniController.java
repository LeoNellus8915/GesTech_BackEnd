package it.teorema.gestech.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
import it.teorema.gestech.service.DipendentiService;

@Controller
public class BeniController {
	@Autowired
	BeniService beniService;
	@Autowired
	DipendentiService dipendentiService;
	
	@RequestMapping("/all-beni")
	public ResponseEntity<List<Object>> allBeni() {
		List<Object> lista = new ArrayList<>();
		lista.add(beniService.findBeni());
		lista.add(SecurityController.getListaCodiciBeni());
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/salva-bene")
	public ResponseEntity<?> salvaBene(@RequestBody Beni bene) {
		beniService.save(bene);
		List<JSONObject> listaCodici = SecurityController.getListaCodiciBeni();
		JSONObject oggetto = new JSONObject();
		UUID codice = UUID.randomUUID();
		oggetto.put("id", beniService.getLastId());
		oggetto.put("codice", codice.toString().replaceAll("-", ""));
		listaCodici.add(oggetto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping("/get-bene-visualizza/{codiceBene}")
	public ResponseEntity<List<Object>> getBeneVisualizza(@PathVariable("codiceBene") String codiceBene) {
		List<Object> lista = new ArrayList<>();
		int idBene = 0;
		List<JSONObject> listaCodici = SecurityController.getListaCodiciBeni();
		
		for (JSONObject codice : listaCodici)
			if (((String)codice.get(("codice"))).equals(codiceBene))
				idBene = (Integer)codice.get("id");
		
		lista.add(beniService.getBene(idBene));
		lista.add(beniService.findStoricoBeni());
		
		return new ResponseEntity<>(lista, HttpStatus.OK);
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
		lista.add(dipendentiService.findAllException(bene.getDipendente()));
		lista.add(beniService.findStoricoBeni());
		
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@RequestMapping("/modifica-bene/{codiceBene}")
	public ResponseEntity<?> modificaBene(@RequestBody Beni bene, @PathVariable("codiceBene") String codiceBene) {
		int idBene = 0;
		List<JSONObject> listaCodici = SecurityController.getListaCodiciBeni();
		
		for (JSONObject codice : listaCodici)
			if (((String)codice.get(("codice"))).equals(codiceBene))
				idBene = (Integer)codice.get("id");
		
		if(bene.getDataRestituzione() != null) {
			beniService.modificaBeneRestituito(idBene, bene.getDispositivo(), bene.getMarca(), bene.getModello(), 
					bene.getNumeroSeriale(), bene.getPassword(), bene.getSocieta(), bene.getNote());
			
			Beni copia = new Beni(bene.getDispositivo(), bene.getMarca(), bene.getModello(), 
				bene.getNumeroSeriale(), bene.getPassword(), bene.getDipendente(), bene.getSocieta(), 
				bene.getDataConsegna(), bene.getDataRestituzione(), bene.getNote());
			
			beniService.save(copia);
		}
		else {
			beniService.modificaBene(idBene, bene.getDispositivo(), bene.getMarca(), bene.getModello(), 
					bene.getNumeroSeriale(), bene.getPassword(), bene.getDipendente(), bene.getSocieta(), 
					bene.getDataConsegna(), bene.getNote());
		}
		
		
		
		
		/*beniService.modificaBene(idBene, bene.getDispositivo(), bene.getMarca(), bene.getModello(), 
				bene.getNumeroSeriale(), bene.getPassword(), bene.getDipendente(), bene.getSocieta(), 
				bene.getDataConsegna(), bene.getDataRestituzione(), bene.getNote());*/
		
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}