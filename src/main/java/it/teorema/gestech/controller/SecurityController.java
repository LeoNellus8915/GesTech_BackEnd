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
import org.springframework.web.bind.annotation.RequestMapping;

import it.teorema.gestech.service.BeniService;
import it.teorema.gestech.service.RichiesteService;
import it.teorema.gestech.service.CandidatiService;

@Controller
public class SecurityController {
	
	@Autowired
	CandidatiService candidatiService;
	@Autowired
	RichiesteService richiesteService;
	@Autowired
	BeniService beniService;
	
	private static List<JSONObject> listaCodiciCandidati;
	private static List<JSONObject> listaCodiciRichiesteAperte;
	private static List<JSONObject> listaCodiciRichiesteChiuse;
	private static List<JSONObject> listaCodiciBeni;

	@SuppressWarnings("unchecked")
	@RequestMapping("/get-codici-candidati")
	public ResponseEntity<?> getCodiciCandidati() {
		List<JSONObject> listaCodici = new ArrayList<JSONObject>();
		List<Integer> listaId = candidatiService.getIdCandidati();
		for (Integer id : listaId) {
			JSONObject oggetto = new JSONObject();
			UUID codice = UUID.randomUUID();
			oggetto.put("id", id);
			oggetto.put("codice", codice.toString().replaceAll("-", ""));
			listaCodici.add(oggetto);
			//controllo sul se esce uguale
		}
		listaCodiciCandidati = listaCodici;
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	public static List<JSONObject> getListaCodiciCandidati() {
		return listaCodiciCandidati;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/get-codici-richieste-aperte")
	public ResponseEntity<?> getCodiciRichiesteAperte() {
		List<JSONObject> listaCodici = new ArrayList<JSONObject>();
		List<Integer> listaId = richiesteService.getIdRichiesteAperte();
		for (Integer id : listaId) {
			JSONObject oggetto = new JSONObject();
			UUID codice = UUID.randomUUID();
			oggetto.put("id", id);
			oggetto.put("codice", codice.toString().replaceAll("-", ""));
			listaCodici.add(oggetto);
			//controllo sul se esce uguale
		}
		listaCodiciRichiesteAperte = listaCodici;
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	public static List<JSONObject> getListaCodiciRichiesteAperte() {
		return listaCodiciRichiesteAperte;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/get-codici-richieste-chiuse")
	public ResponseEntity<?> getCodiciRichiesteChiuse() {
		List<JSONObject> listaCodici = new ArrayList<JSONObject>();
		List<Integer> listaId = richiesteService.getIdRichiesteChiuse();
		for (Integer id : listaId) {
			JSONObject oggetto = new JSONObject();
			UUID codice = UUID.randomUUID();
			oggetto.put("id", id);
			oggetto.put("codice", codice.toString().replaceAll("-", ""));
			listaCodici.add(oggetto);
			//controllo sul se esce uguale
		}
		listaCodiciRichiesteChiuse = listaCodici;
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	public static List<JSONObject> getListaCodiciRichiesteChiuse() {
		return listaCodiciRichiesteChiuse;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/get-codici-beni")
	public ResponseEntity<?> getCodiciBeni() {
		List<JSONObject> listaCodici = new ArrayList<JSONObject>();
		List<Integer> listaId = beniService.getIdBeni();
		for (Integer id : listaId) {
			JSONObject oggetto = new JSONObject();
			UUID codice = UUID.randomUUID();
			oggetto.put("id", id);
			oggetto.put("codice", codice.toString().replaceAll("-", ""));
			listaCodici.add(oggetto);
			//controllo sul se esce uguale
		}
		listaCodiciBeni = listaCodici;
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	public static List<JSONObject> getListaCodiciBeni() {
		return listaCodiciBeni;
	}
}