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
import it.teorema.gestech.model.RichiesteDettagliCandidati;
import it.teorema.gestech.model.RichiestePersone;
import it.teorema.gestech.model.mapper.GetNomiRecruiter;
import it.teorema.gestech.service.CommentiRichiesteService;
import it.teorema.gestech.service.RichiesteService;
import it.teorema.gestech.service.RichiestePersoneService;
import it.teorema.gestech.service.PersoneService;
import it.teorema.gestech.service.RichiesteDettagliCandidatiService;
import it.teorema.gestech.service.StatiRichiestaService;

@Controller
public class RichiesteController {
	@Autowired
	RichiesteService richiesteService;
	@Autowired
	PersoneService dipendentiService;
	@Autowired
	CommentiRichiesteService commentiRichiesteService;
	@Autowired
	RichiesteDettagliCandidatiService richiesteDettagliCandidatiService;
	@Autowired
	RichiestePersoneService richiestePersoneService;
	@Autowired
	StatiRichiestaService statiRichiestaService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/salva-richiesta/{ruolo}")
	public ResponseEntity<?> salvaRichiesta(@RequestBody JSONObject addForm, @PathVariable("ruolo") String ruolo) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		Richieste richiesta = new Richieste();
		richiesta.setIdPersona(Integer.parseInt((String)addForm.get("idDipendente")));
		richiesta.setData(LocalDateTime.parse(dtf.format(now), dtf));
		richiesta.setIdLinguaggio(Integer.parseInt((String)addForm.get("linguaggio")));
		richiesta.setIdProfilo(Integer.parseInt((String)addForm.get("profilo")));
		richiesta.setIdLivello(Integer.parseInt((String)addForm.get("livello")));
		richiesta.setIdCliente(Integer.parseInt((String)addForm.get("cliente")));
		richiesta.setCitta((String)addForm.get("citta"));
		richiesta.setCosto(Double.parseDouble((String)addForm.get("costo")));
		richiesta.setNote((String)addForm.get("note"));
		richiesta.setIdStato(1);
		richiesta.setPriorita(0);
		richiesteService.save(richiesta);
		
		List<JSONObject> listaCodici = null;
		if (ruolo.equals("Account"))
			listaCodici = SecurityController.getListaCodiciRichiesteAperteAccount();
		if (ruolo.equals("Admin"))
			listaCodici = SecurityController.getListaCodiciRichiesteAperteAdmin();
		JSONObject oggetto = new JSONObject();
		UUID codice = UUID.randomUUID();
		oggetto.put("id", richiesteService.getLastId());
		oggetto.put("codice", codice.toString().replaceAll("-", ""));
			Collections.reverse(listaCodici);
			listaCodici.add(oggetto);
			Collections.reverse(listaCodici);

		return new ResponseEntity<> (HttpStatus.OK); 
	}
	
	@RequestMapping("/all-richieste-aperte-account/{idDipendente}")
	public ResponseEntity<List<Object>> allRichiesteAperteAccount(@PathVariable("idDipendente") int idDipendente) {
		List <Object> lista = new ArrayList<Object>();
		lista.add(SecurityController.getListaCodiciRichiesteAperteAccount());
		lista.add(richiesteService.stampaCardAperteAccount(idDipendente));
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@RequestMapping("/all-richieste-aperte-commerciale")
	public ResponseEntity<List<Object>> allRichiesteAperteCommerciale() {
		List <Object> lista = new ArrayList<Object>();
		lista.add(SecurityController.getListaCodiciRichiesteAperteCommerciale());
		lista.add(richiesteService.stampaCardAperteCommerciale());
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@RequestMapping("/all-richieste-aperte-recruiter") //Direttore Recruiter
	public ResponseEntity<List<Object>> allRichiesteAperteRecruiter() {
		List <Object> lista = new ArrayList<Object>();
		lista.add(SecurityController.getListaCodiciRichiesteAperteRecruiter());
		lista.add(richiesteService.stampaCardAperteRecruiter());
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@RequestMapping("/all-richieste-aperte-admin")
	public ResponseEntity<List<Object>> allRichiesteAperteAdmin() {
		List <Object> lista = new ArrayList<Object>();
		lista.add(SecurityController.getListaCodiciRichiesteAperteAdmin());
		lista.add(richiesteService.stampaCardAperteAdmin());
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@RequestMapping("/all-richieste-aperte/{nome}/{cognome}/{idDipendente}")
	public ResponseEntity<List<Object>> allRichiesteAperte(@PathVariable("nome") String nome, @PathVariable("cognome") String cognome, @PathVariable("idDipendente") int idDipendente) {
		String cognomeNome = cognome + "  " + nome;
		List <Object> lista = new ArrayList<Object>();
		lista.add(SecurityController.getListaCodiciRichiesteAperte());
		lista.add(richiesteService.stampaCardAperte(cognomeNome, idDipendente));
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@RequestMapping("/all-richieste-chiuse/{ruolo}/{nomeCognome}/{idDipendente}")
	public ResponseEntity<List<Object>> allRichiesteChiuse(@PathVariable String ruolo, @PathVariable String nomeCognome, @PathVariable("idDipendente") int idDipendente) {
		List <Object> lista = new ArrayList<Object>();
		lista.add(SecurityController.getListaCodiciRichiesteChiuse());
		lista.add(richiesteService.stampaCardChiuse());
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@RequestMapping("/get-richiesta/{codiceRichiesta}/{pagina}/{ruolo}")
	public ResponseEntity<List<Object>> getRichiesta(@PathVariable("codiceRichiesta") String codiceRichiesta, @PathVariable("pagina") int pagina, @PathVariable("ruolo") String ruolo) {
		int idRichiesta = 0;
		if (pagina == 0 && ruolo.equals("Admin")) {
			List<JSONObject> listaCodici = SecurityController.getListaCodiciRichiesteAperteAdmin();
			for (JSONObject codice : listaCodici)
				if (((String)codice.get(("codice"))).equals(codiceRichiesta))
					idRichiesta = (Integer)codice.get("id");
		}
		if (pagina == 0 && ruolo.equals("Account")) {
			List<JSONObject> listaCodici = SecurityController.getListaCodiciRichiesteAperteAccount();
			for (JSONObject codice : listaCodici)
				if (((String)codice.get(("codice"))).equals(codiceRichiesta))
					idRichiesta = (Integer)codice.get("id");
		}
		if (pagina == 0 && ruolo.equals("Direttore Commerciale")) {
			List<JSONObject> listaCodici = SecurityController.getListaCodiciRichiesteAperteCommerciale();
			for (JSONObject codice : listaCodici)
				if (((String)codice.get(("codice"))).equals(codiceRichiesta))
					idRichiesta = (Integer)codice.get("id");
		}
		if (pagina == 0 && ruolo.equals("Direttore Recruiter")) {
			List<JSONObject> listaCodici = SecurityController.getListaCodiciRichiesteAperteRecruiter();
			for (JSONObject codice : listaCodici)
				if (((String)codice.get(("codice"))).equals(codiceRichiesta))
					idRichiesta = (Integer)codice.get("id");
		}
		if (pagina == 0 && ruolo.equals("Recruiter")) {
			List<JSONObject> listaCodici = SecurityController.getListaCodiciRichiesteAperte();
			for (JSONObject codice : listaCodici)
				if (((String)codice.get(("codice"))).equals(codiceRichiesta))
					idRichiesta = (Integer)codice.get("id");
		}
		if (pagina == 1) {
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
		dati.add(richiesteService.getCandidatiSelezionati(idRichiesta));
		if (ruolo.equals("Direttore Recruiter")) {
			dati.add(commentiRichiesteService.findRecruiterById(idRichiesta));
		}
		else if (ruolo.equals("Recruiter"))
			dati.add(commentiRichiesteService.findById(idRichiesta));
		else
			dati.add(commentiRichiesteService.findAltriById(idRichiesta));
		return new ResponseEntity<>(dati, HttpStatus.OK);
	}
	
	@RequestMapping("salva-priorita/{ruolo}")
	public ResponseEntity<?> salvaPriorita(@RequestBody List<JSONObject> listaPriorita, @PathVariable("ruolo") String ruolo) {
		int idRichiesta = 0;
		List<JSONObject> listaCodici = new ArrayList<JSONObject>();
		if (ruolo.equals("Direttore Commerciale"))
			listaCodici = SecurityController.getListaCodiciRichiesteAperteCommerciale();
		else
			listaCodici = SecurityController.getListaCodiciRichiesteAperteAdmin();
		for (JSONObject oggetto : listaPriorita) {
			for (JSONObject codice : listaCodici)
				if (((String)codice.get(("codice"))).equals((String)oggetto.get("codiceRichiesta")))
					idRichiesta = (Integer)codice.get("id");
				richiesteService.setPriorita(idRichiesta, (Integer)oggetto.get("priorita"));
			}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	/*
	@RequestMapping("/elimina-richiesta/{codiceRichiesta}/{pagina}/{ruolo}")
	public ResponseEntity<?> eliminaRichiesta(@PathVariable("codiceRichiesta") String codiceRichiesta, @PathVariable("pagina") int pagina,
												@PathVariable("ruolo") String ruolo) {
		int idRichiesta = 0;
		JSONObject appoggio = null;
		
		if (pagina == 0) {
			List<JSONObject> listaCodici = null;
			if (ruolo.equals("Direttore Commerciale"))
				listaCodici = SecurityController.getListaCodiciRichiesteAperteCommerciale();
			if (ruolo.equals("Admin"))
				listaCodici = SecurityController.getListaCodiciRichiesteAperteAdmin();
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
		dipendentiRichiesteService.deleteDipendenteRichiesta(idRichiesta);
		return new ResponseEntity<> (HttpStatus.OK);  
	}
*/
	@RequestMapping("/get-nomi-recruiter")
	public ResponseEntity<List<String>> getNomiRecruiter() {
		List<GetNomiRecruiter> getNomiRecruiter = dipendentiService.getNomiRecruiter();
		List<String> nomiRecruiter = new ArrayList<String>();
		for (GetNomiRecruiter element : getNomiRecruiter) {
			nomiRecruiter.add(element.getCognome() + "  " + element.getNome());
		}
		return new ResponseEntity<>(nomiRecruiter, HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/modifica-richiesta/{codiceRichiesta}/{idPersona}/{pagina}/{ruolo}")
	public ResponseEntity<?> modificaRichiesta(@PathVariable("codiceRichiesta") String codiceRichiesta, @PathVariable("idPersona") int idPersona, 
												@PathVariable("pagina") int pagina, @PathVariable("ruolo") String ruolo, @RequestBody JSONObject updateForm) {
		int idRichiesta = 0;
		JSONObject richiesta = null;
		
		if (pagina == 0 && ruolo.equals("Admin")) {
			List<JSONObject> listaCodici = SecurityController.getListaCodiciRichiesteAperteAdmin();
			for (JSONObject codice : listaCodici)
				if (((String)codice.get(("codice"))).equals(codiceRichiesta)) {
					idRichiesta = (Integer)codice.get("id");
					richiesta = codice;
				}
		}
		if (pagina == 0 && ruolo.equals("Account")) {
			List<JSONObject> listaCodici = SecurityController.getListaCodiciRichiesteAperteAccount();
			for (JSONObject codice : listaCodici)
				if (((String)codice.get(("codice"))).equals(codiceRichiesta)) {
					idRichiesta = (Integer)codice.get("id");
					richiesta = codice;
				}
		}
		if (pagina == 0 && ruolo.equals("Direttore Commerciale")) {
			List<JSONObject> listaCodici = SecurityController.getListaCodiciRichiesteAperteCommerciale();
			for (JSONObject codice : listaCodici)
				if (((String)codice.get(("codice"))).equals(codiceRichiesta)) {
					idRichiesta = (Integer)codice.get("id");
					richiesta = codice;
				}
		}
		if (pagina == 0 && ruolo.equals("Direttore Recruiter")) {
			List<JSONObject> listaCodici = SecurityController.getListaCodiciRichiesteAperteRecruiter();
			for (JSONObject codice : listaCodici)
				if (((String)codice.get(("codice"))).equals(codiceRichiesta)) {
					idRichiesta = (Integer)codice.get("id");
					richiesta = codice;
				}
		}
		if (pagina == 0 && ruolo.equals("Recruiter")) {
			List<JSONObject> listaCodici = SecurityController.getListaCodiciRichiesteAperte();
			for (JSONObject codice : listaCodici)
				if (((String)codice.get(("codice"))).equals(codiceRichiesta))
					idRichiesta = (Integer)codice.get("id");
		}
		if (pagina == 1) {
			List<JSONObject> listaCodici = SecurityController.getListaCodiciRichiesteChiuse();
			for (JSONObject codice : listaCodici)
				if (((String)codice.get(("codice"))).equals(codiceRichiesta)) {
					idRichiesta = (Integer)codice.get("id");
					richiesta = codice;
				}
		}
		
		if (!ruolo.equals("Recruiter")) {
			String listaRecruiters;
			if (updateForm.get("listaRecruiters").toString().equals("[]"))
				listaRecruiters = null;
			else
				listaRecruiters = (String)updateForm.get("listaRecruiters").toString().replace("[", "").replace("]", "");
					
			Richieste modificaRichiesta = new Richieste(idRichiesta, listaRecruiters, Integer.parseInt((String)updateForm.get("statoRichiesta")),
					Integer.parseInt((String)updateForm.get("priorita")));
			
			richiesteService.updateRichiesta(modificaRichiesta);
			
			String[] recruiters = updateForm.get("listaRecruiters").toString().replace("[", "").replace("]", "").split(", ");
			List<GetNomiRecruiter> recruiter = new ArrayList<GetNomiRecruiter>();
			if (ruolo.equals("Direttore Recruiter") && !recruiters[0].equals("")) {
				if (updateForm.get("listaRecruiters").toString().indexOf("Tutti") > -1)
				{
					recruiter = dipendentiService.getNomiRecruiter();
					for (int c=0; c<recruiter.size(); c++) {
						RichiesteDettagliCandidati rdc = new RichiesteDettagliCandidati(idRichiesta, dipendentiService.findByName(recruiter.get(c).getNome(), recruiter.get(c).getCognome()), (String)updateForm.get("note"));
						richiesteDettagliCandidatiService.save(rdc);
					}
				}
				else
					if (recruiters.length > 0)
						for (int c=0; c<recruiters.length; c++) {
							String[] rec = recruiters[c].toString().split("  ");
							richiestePersoneService.save(new RichiestePersone(idRichiesta, dipendentiService.findByName((String)rec[1], (String)rec[0])));
						}
			}
			
			List<JSONObject> listaCodiciAperte = new ArrayList<JSONObject>();
			if (ruolo.equals("Account"))
				listaCodiciAperte = SecurityController.getListaCodiciRichiesteAperteAccount();
			if (ruolo.equals("Direttore Commerciale"))
				listaCodiciAperte = SecurityController.getListaCodiciRichiesteAperteCommerciale();
			if (ruolo.equals("Direttore Recruiter"))
				listaCodiciAperte = SecurityController.getListaCodiciRichiesteAperteRecruiter();
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
				richiestePersoneService.setVisualizzato(idRichiesta);
			}
			if ((String)updateForm.get("commento") != "") {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
				LocalDateTime now = LocalDateTime.now();
				CommentiRichieste commentoRichiesta = new CommentiRichieste();
				commentoRichiesta.setData(LocalDateTime.parse(dtf.format(now), dtf));
				commentoRichiesta.setIdPersona(idPersona);
				commentoRichiesta.setIdRichiesta(idRichiesta);
				commentoRichiesta.setNote((String)updateForm.get("commento"));
				if (commentiRichiesteService.recruiterPresente(idRichiesta) == null && listaRecruiters == null)
					commentoRichiesta.setNascosto(false);
				else
					commentoRichiesta.setNascosto(true);
				commentiRichiesteService.save(commentoRichiesta);
			}
		}
		else
			if ((String)updateForm.get("commento") != "") {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
				LocalDateTime now = LocalDateTime.now();
				CommentiRichieste commentoRichiesta = new CommentiRichieste();
				commentoRichiesta.setData(LocalDateTime.parse(dtf.format(now), dtf));
				commentoRichiesta.setIdPersona(idPersona);
				commentoRichiesta.setIdRichiesta(idRichiesta);
				commentoRichiesta.setNote((String)updateForm.get("commento"));
				commentoRichiesta.setNascosto(true);
				commentiRichiesteService.save(commentoRichiesta);
			}
		return new ResponseEntity<> (HttpStatus.OK);  
	}
	
	@RequestMapping("/set-visualizzato/{codiceRichiesta}/{idDipendente}")
	public ResponseEntity<?> setVisualizzato(@PathVariable("codiceRichiesta") String codiceRichiesta, @PathVariable("idDipendente") int idDipendente) {
		int idRichiesta = 0;
		
		List<JSONObject> listaCodici = SecurityController.getListaCodiciRichiesteAperte();
		for (JSONObject codice : listaCodici)
			if (((String)codice.get(("codice"))).equals(codiceRichiesta))
				idRichiesta = (Integer)codice.get("id");
		
		richiestePersoneService.setVisualizzato(idRichiesta, idDipendente);
		return new ResponseEntity<> (HttpStatus.OK);
	}

	@RequestMapping("/assegna-candidati/{idRichiesta}")
	public ResponseEntity<?> assegnaCandidati(@RequestBody String listaCandidati, @PathVariable("idRichiesta") int idRichiesta) {
		String[] candidati = listaCandidati.split(",");
		for(int i=0; i<candidati.length; i++) {
			for (JSONObject codice : SecurityController.getListaCodiciCandidati()) {
				if(codice.get("codice").equals(candidati[i])) {
					int idCandidato = (int) codice.get("id");
					RichiesteDettagliCandidati rdc = new RichiesteDettagliCandidati(idCandidato, idRichiesta);
					richiesteDettagliCandidatiService.save(rdc);
				}
			}
		}
		richiesteService.setStato(idRichiesta);
		return new ResponseEntity<> (HttpStatus.OK);
	}
}




















