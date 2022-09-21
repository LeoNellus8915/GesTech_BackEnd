package it.teorema.gestech.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import it.teorema.gestech.service.RisorseService;

@Controller
public class SecurityController {
	
	@Autowired
	RisorseService risorseService;
	
	private static List<JSONObject> listaCodiciCandidati;

	@SuppressWarnings("unchecked")
	@RequestMapping("/get-codici-candidati")
	public ResponseEntity<?> getCodiciCandidati(HttpServletRequest request) {
		List<JSONObject> listaCodici = new ArrayList<JSONObject>();
		List<Integer> listaId = risorseService.getIdCandidati();
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
	
	public static List<JSONObject> getCodiciCandidati() {
		return listaCodiciCandidati;
	}
}