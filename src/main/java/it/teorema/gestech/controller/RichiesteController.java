package it.teorema.gestech.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
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

import it.teorema.gestech.model.CommentiRichieste;
import it.teorema.gestech.model.Richieste;
import it.teorema.gestech.model.RisorseRichieste;
import it.teorema.gestech.service.CommentiRichiesteService;
import it.teorema.gestech.service.RichiesteService;
import it.teorema.gestech.service.RisorseRichiesteService;
import it.teorema.gestech.service.RisorseService;
import it.teorema.gestech.service.StatiRichiestaService;

@Controller
public class RichiesteController {
	@Autowired
	RichiesteService richiesteService;
	@Autowired
	RisorseService risorseService;
	@Autowired
	CommentiRichiesteService commentiRichiesteService;
	@Autowired
	RisorseRichiesteService risorseRichiesteService;
	@Autowired
	StatiRichiestaService statiRichiestaService;
	

	@RequestMapping("/all-richieste-aperte/{ruolo}/{nomeCognome}/{idRisorsa}")
	public ResponseEntity<List<Object>> allRichiesteAperte(@PathVariable String ruolo, @PathVariable String nomeCognome, @PathVariable("idRisorsa") int idRisorsa) {
		List <Object> lista = new ArrayList<Object>();
		lista.add(SecurityController.getListaCodiciRichiesteAperte());
		if(ruolo.equals("Commerciale")
				|| ruolo.equals("Admin")) {
			lista.add(richiesteService.stampaCardAperte());
			return new ResponseEntity<>(lista, HttpStatus.OK); 
		}
		else {
			lista.add(richiesteService.stampaCardByNameAperte(nomeCognome, idRisorsa));
			return new ResponseEntity<>(lista, HttpStatus.OK);}
	}
	
	@RequestMapping("/all-richieste-chiuse/{ruolo}/{nomeCognome}/{idRisorsa}")
	public ResponseEntity<List<Object>> allRichiesteChiuse(@PathVariable String ruolo, @PathVariable String nomeCognome, @PathVariable("idRisorsa") int idRisorsa) {
		List <Object> lista = new ArrayList<Object>();
		lista.add(SecurityController.getListaCodiciRichiesteChiuse());
		if(ruolo.equals("Commerciale")
				|| ruolo.equals("Admin")) {
			lista.add(richiesteService.stampaCardChiuse());
			return new ResponseEntity<>(lista, HttpStatus.OK); 
		}
		else {
			lista.add(richiesteService.stampaCardByNameChiuse(nomeCognome, idRisorsa));
			return new ResponseEntity<>(lista, HttpStatus.OK);
		}
	}
	
	@RequestMapping("/get-nomi-recruiter")
	public ResponseEntity<List<String>> getNomiRecruiter() {
		return new ResponseEntity<>(risorseService.getNomiRecruiter(), HttpStatus.OK);
	}
	
	@RequestMapping("/get-richiesta/{codiceRichiesta}/{pagina}")
	public ResponseEntity<List<Object>> getRichiesta(@PathVariable("codiceRichiesta") String codiceRichiesta, @PathVariable("pagina") int pagina) {
		int idRichiesta = 0;
		
		if (pagina == 0) {
			List<JSONObject> listaCodici = SecurityController.getListaCodiciRichiesteAperte();
			for (JSONObject codice : listaCodici)
				if (((String)codice.get(("codice"))).equals(codiceRichiesta))
					idRichiesta = (Integer)codice.get("id");
		}
		else {
			List<JSONObject> listaCodici = SecurityController.getListaCodiciRichiesteChiuse();
			for (JSONObject codice : listaCodici)
				if (((String)codice.get(("codice"))).equals(codiceRichiesta))
					idRichiesta = (Integer)codice.get("id");
		}
		
		List<Object> dati = new ArrayList<Object>();
		String nomeStatoRichiesta = statiRichiestaService.getStatoRichiesta(idRichiesta);
		dati.add(richiesteService.visualizzaRichiesta(idRichiesta));
		dati.add(nomeStatoRichiesta);
		dati.add(statiRichiestaService.getIdStatoRichiesta(nomeStatoRichiesta).toString());
		dati.add(statiRichiestaService.findAllException(nomeStatoRichiesta));
		dati.add(commentiRichiesteService.findById(idRichiesta));
		return new ResponseEntity<>(dati, HttpStatus.OK);
	}
	
	@RequestMapping("/set-visualizzato/{codiceRichiesta}/{idRisorsa}")
	public ResponseEntity<?> setVisualizzato(@PathVariable("codiceRichiesta") String codiceRichiesta, @PathVariable("idRisorsa") int idRisorsa) {
		int idRichiesta = 0;
		
		List<JSONObject> listaCodici = SecurityController.getListaCodiciRichiesteAperte();
		for (JSONObject codice : listaCodici)
			if (((String)codice.get(("codice"))).equals(codiceRichiesta))
				idRichiesta = (Integer)codice.get("id");
		
		risorseRichiesteService.setVisualizzato(idRichiesta, idRisorsa);
		return new ResponseEntity<> (HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/salva-richiesta")
	public ResponseEntity<?> salvaRichiesta(@RequestBody JSONObject addForm) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		Richieste richiesta = new Richieste();
		richiesta.setIdRisorsa(Integer.parseInt((String)addForm.get("idRisorsa")));
		richiesta.setData(LocalDateTime.parse(dtf.format(now), dtf));
		richiesta.setIdSkill(Integer.parseInt((String)addForm.get("linguaggio")));
		richiesta.setIdProfilo(Integer.parseInt((String)addForm.get("profilo")));
		richiesta.setIdSeniority(Integer.parseInt((String)addForm.get("livello")));
		richiesta.setCliente((String)addForm.get("cliente"));
		richiesta.setCitta((String)addForm.get("citta"));
		richiesta.setCosto(Double.parseDouble((String)addForm.get("costo")));
		richiesta.setNote((String)addForm.get("note"));
		richiesta.setRecruiter((String)addForm.get("listaRecruiters").toString().replace(",", "").replace("[", "").replace("]", ""));
		richiesta.setIdStato(1);
		richiesteService.save(richiesta);
		
		List<JSONObject> listaCodici = SecurityController.getListaCodiciRichiesteAperte();
		JSONObject oggetto = new JSONObject();
		UUID codice = UUID.randomUUID();
		oggetto.put("id", richiesteService.getLastId());
		oggetto.put("codice", codice.toString().replaceAll("-", ""));
		Collections.reverse(listaCodici);
		listaCodici.add(oggetto);
		Collections.reverse(listaCodici);
		
		String[] recruiters = addForm.get("listaRecruiters").toString().replace("[", "").replace("]", "").split(", ");
		List<String> recruiter = new ArrayList<String>();
		int idRichiesta = richiesteService.findLastId();
		
		if (addForm.get("listaRecruiters").toString().indexOf("Tutti") > -1)
		{
			recruiter = risorseService.getNomiRecruiter();
			for (int c=0; c<recruiter.size(); c++)
				risorseRichiesteService.save(new RisorseRichieste(risorseService.findByName(recruiter.get(c)), idRichiesta));
		}
		else
			if (recruiters.length > 0)
				for (int c=0; c<recruiters.length; c++)
					risorseRichiesteService.save(new RisorseRichieste(risorseService.findByName(recruiters[c]), idRichiesta));
		
		return new ResponseEntity<> (HttpStatus.OK); 
	}
	
	@RequestMapping("/elimina-richiesta/{codiceRichiesta}/{pagina}")
	public ResponseEntity<?> eliminaRichiesta(@PathVariable("codiceRichiesta") String codiceRichiesta, @PathVariable("pagina") int pagina) {
		int idRichiesta = 0;
		JSONObject appoggio = null;
		
		if (pagina == 0) {
			List<JSONObject> listaCodici = SecurityController.getListaCodiciRichiesteAperte();
			for (JSONObject codice : listaCodici)
				if (((String)codice.get(("codice"))).equals(codiceRichiesta)) {
					idRichiesta = (Integer)codice.get("id");
					appoggio = codice;
				}
			listaCodici.remove(appoggio);
		}
		else {
			List<JSONObject> listaCodici = SecurityController.getListaCodiciRichiesteChiuse();
			for (JSONObject codice : listaCodici)
				if (((String)codice.get(("codice"))).equals(codiceRichiesta)) {
					idRichiesta = (Integer)codice.get("id");
					appoggio = codice;
				}
			listaCodici.remove(appoggio);
		}
		
		richiesteService.deleteById(idRichiesta);
		commentiRichiesteService.deleteCommento(idRichiesta);
		risorseRichiesteService.deleteRisorsaRichiesta(idRichiesta);
		return new ResponseEntity<> (HttpStatus.OK);  
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/modifica-richiesta/{codiceRichiesta}/{idRisorsa}/{pagina}")
	public ResponseEntity<?> modificaRichiesta(@PathVariable("codiceRichiesta") String codiceRichiesta, @PathVariable("idRisorsa") int idRisorsa, 
												@PathVariable("pagina") int pagina, @RequestBody JSONObject updateForm) {
		int idRichiesta = 0;
		JSONObject richiesta = null;
		
		if (pagina == 0) {
			List<JSONObject> listaCodici = SecurityController.getListaCodiciRichiesteAperte();
			for (JSONObject codice : listaCodici)
				if (((String)codice.get(("codice"))).equals(codiceRichiesta)) {
					idRichiesta = (Integer)codice.get("id");
					richiesta = codice;
				}
		}
		else {
			List<JSONObject> listaCodici = SecurityController.getListaCodiciRichiesteChiuse();
			for (JSONObject codice : listaCodici)
				if (((String)codice.get(("codice"))).equals(codiceRichiesta)) {
					idRichiesta = (Integer)codice.get("id");
					richiesta = codice;
				}
		}	
		
		richiesteService.updateStato(Integer.parseInt((String)updateForm.get("statoRichiesta")), idRichiesta);
		
		List<JSONObject> listaCodiciAperte = SecurityController.getListaCodiciRichiesteAperte();
		List<JSONObject> listaCodiciChiuse = SecurityController.getListaCodiciRichiesteChiuse();
		if (pagina == 0 && Integer.parseInt((String)updateForm.get("statoRichiesta")) == 3) {
			listaCodiciAperte.remove(richiesta);
			JSONObject oggetto = new JSONObject();
			UUID codice = UUID.randomUUID();
			oggetto.put("id", idRichiesta);
			oggetto.put("codice", codice.toString().replaceAll("-", ""));
			Collections.reverse(listaCodiciChiuse);
			listaCodiciChiuse.add(oggetto);
			Collections.reverse(listaCodiciChiuse);
		}
		if (pagina == 1 && (Integer.parseInt((String)updateForm.get("statoRichiesta")) == 1 ||
								Integer.parseInt((String)updateForm.get("statoRichiesta")) == 2)) {
			listaCodiciChiuse.remove(richiesta);
			JSONObject oggetto = new JSONObject();
			UUID codice = UUID.randomUUID();
			oggetto.put("id", idRichiesta);
			oggetto.put("codice", codice.toString().replaceAll("-", ""));
			Collections.reverse(listaCodiciAperte);
			listaCodiciAperte.add(oggetto);
			Collections.reverse(listaCodiciAperte);
		}
			
		if (Integer.parseInt((String)updateForm.get("statoRichiesta")) == 3) {
			risorseRichiesteService.setVisualizzato(idRichiesta);
		}
		if ((String)updateForm.get("commento") != "")
		{
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();
			CommentiRichieste commentoRichiesta = new CommentiRichieste();
			commentoRichiesta.setData(LocalDateTime.parse(dtf.format(now), dtf));
			commentoRichiesta.setIdRisorsa(idRisorsa);
			commentoRichiesta.setIdDestinatario(idRichiesta);
			commentoRichiesta.setNote((String)updateForm.get("commento"));
			commentiRichiesteService.save(commentoRichiesta);
		}
		return new ResponseEntity<> (HttpStatus.OK);  
	}
}
