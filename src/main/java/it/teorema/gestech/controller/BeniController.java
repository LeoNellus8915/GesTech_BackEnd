package it.teorema.gestech.controller;

import java.util.ArrayList;
import java.util.List;

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
	public ResponseEntity<List<Beni>> allBeni() {
		return new ResponseEntity<>(beniService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping("/salva-bene")
	public ResponseEntity<?> salvaBene(@RequestBody Beni bene) {
		beniService.save(bene);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping("/get-bene-visualizza/{idBene}")
	public ResponseEntity<Beni> getBeneVisualizza(@PathVariable("idBene") int idBene) {
		return new ResponseEntity<>(beniService.getBene(idBene), HttpStatus.OK);
	}
	
	@RequestMapping("/get-bene-modifica/{idBene}")
	public ResponseEntity<List<Object>> getBeneModifica(@PathVariable("idBene") int idBene) {
		List<Object> lista = new ArrayList<>();
		Beni bene = beniService.getBene(idBene);
		lista.add(bene);
		lista.add(risorseService.findAllException(bene.getDipendente()));
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@RequestMapping("/modifica-bene")
	public ResponseEntity<?> modificaBene(@RequestBody Beni bene) {
		System.out.println(bene.getId());
		beniService.modificaBene(bene.getId(), bene.getDispositivo(), bene.getMarca(), bene.getModello(), 
				bene.getNumeroSeriale(), bene.getPassword(), bene.getDipendente(), bene.getSocieta(), 
				bene.getDataConsegna(), bene.getDataRestituzione(), bene.getNote());
		return new ResponseEntity<>(HttpStatus.OK);
	}
}