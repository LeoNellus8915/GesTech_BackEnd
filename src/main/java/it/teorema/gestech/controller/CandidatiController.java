package it.teorema.gestech.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import it.teorema.gestech.model.CommentiCandidati;
import it.teorema.gestech.model.Cv;
import it.teorema.gestech.model.DettagliCandidati;
import it.teorema.gestech.model.Persone;
import it.teorema.gestech.service.CommentiCandidatiService;
import it.teorema.gestech.service.CvService;
import it.teorema.gestech.service.DettagliCandidatiService;
import it.teorema.gestech.service.PersoneService;
import it.teorema.gestech.service.EsitiColloquioService;
import it.teorema.gestech.service.LinguaggiService;
import it.teorema.gestech.service.LingueDettagliCandidatiService;
import it.teorema.gestech.service.LingueService;
import it.teorema.gestech.service.LivelliService;
import it.teorema.gestech.service.ProfiliService;

@Controller
public class CandidatiController {
	@Autowired
	PersoneService personeService;
	@Autowired
	EsitiColloquioService esitiColloquioService;
	@Autowired
	ProfiliService profiliService;
	@Autowired
	LinguaggiService linguaggiService;
	@Autowired
	LingueService lingueService;
	@Autowired
	LivelliService livelliService;
	@Autowired
	DettagliCandidatiService dettagliCandidatiService;
	@Autowired
	CommentiCandidatiService commentiCandidatiService;
	@Autowired
	CvService cvService;
	@Autowired
	LingueDettagliCandidatiService lingueDettagliCandidatiService;
		
	@RequestMapping("/all-candidati")
	public ResponseEntity<List<Object>> allCandidati(HttpServletRequest request) {
		List<Object> lista = new ArrayList<>();
		lista.add(dettagliCandidatiService.allCandidati());
		lista.add(SecurityController.getListaCodiciCandidati());
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@RequestMapping("/salva-candidato")
	public ResponseEntity<?> salvaCandidato(@RequestBody JSONObject formCandidato) {
		if (personeService.existsByEmail((String) formCandidato.get("email")) != null ||
				personeService.existsByEmail((String) formCandidato.get("email")) != null)
			return new ResponseEntity<>(0, HttpStatus.OK);
		else
		{
			DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
			DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
			LocalDateTime now = LocalDateTime.now();  
			LocalDateTime data = LocalDateTime.parse(format1.format(now), format1);
			
			Persone persona = new Persone();
			persona.setAnagrafica(formCandidato);
			personeService.save(persona);
			
			int idCandidato = personeService.findIdByEmail(persona.getEmail());
			
			DettagliCandidati dettagliCandidato = new DettagliCandidati();
			dettagliCandidato.setDettagliCandidato(formCandidato, idCandidato);
			dettagliCandidatiService.save(dettagliCandidato);
			
			if ((String)formCandidato.get("cv") != null) {
				Cv cv = new Cv();
				cv.setCv(formCandidato, idCandidato);
				cvService.save(cv);
			}
				
			if ((String)formCandidato.get("commento") != "")
			{
				CommentiCandidati commentiCandidato = new CommentiCandidati();
				commentiCandidato.setCommentiCandidati(formCandidato, idCandidato);
				commentiCandidatiService.save(commentiCandidato);
			}
			
			List<JSONObject> listaCodici = SecurityController.getListaCodiciCandidati();
			JSONObject oggetto = new JSONObject();
			UUID codice = UUID.randomUUID();
			oggetto.put("id", idCandidato);
			oggetto.put("codice", codice.toString().replaceAll("-", ""));
			listaCodici.add(oggetto);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@RequestMapping("/get-candidato-visualizza/{codiceCandidato}")
	public ResponseEntity<List<Object>> getCandidatoVisualizza(@PathVariable("codiceCandidato") String codiceCandidato) {
		int idPersona = 0;
		List<JSONObject> listaCodici = SecurityController.getListaCodiciCandidati();
		
		for (JSONObject codice : listaCodici)
			if (((String)codice.get(("codice"))).equals(codiceCandidato))
				idPersona = (Integer)codice.get("id");
		
		if (idPersona != 0) {
			Persone persona = personeService.findByIdPersona(idPersona);
			if (persona == null)
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			else {
				List<Object> datiCandidato = new ArrayList<Object>();
				List<Object> dettagliCandidato = new ArrayList<Object>();
				
				dettagliCandidato.add(dettagliCandidatiService.getDettagliCandidato(idPersona));
				dettagliCandidato.add(esitiColloquioService.getEsitoColloquio(idPersona));
				dettagliCandidato.add(profiliService.getProfilo(idPersona));
				dettagliCandidato.add(linguaggiService.getLinguaggio(idPersona));
				dettagliCandidato.add(lingueService.getLingua(idPersona));
				dettagliCandidato.add(livelliService.getSeniority(idPersona));
						
				datiCandidato.add(persona);
				datiCandidato.add(dettagliCandidato);
				datiCandidato.add(commentiCandidatiService.findByIdCandidato(idPersona));
				datiCandidato.add(esitiColloquioService.getColore((String)dettagliCandidato.get(1)));
				return new ResponseEntity<>(datiCandidato, HttpStatus.OK);
			}
		}
		else
			return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@RequestMapping("/get-candidato-modifica/{codiceCandidato}")
	public ResponseEntity<List<Object>> getCandidatoModifica(@PathVariable("codiceCandidato") String codiceCandidato) {
		int idPersona = 0;
		List<JSONObject> listaCodici = SecurityController.getListaCodiciCandidati();
		
		for (JSONObject codice : listaCodici)
			if (((String)codice.get(("codice"))).equals(codiceCandidato))
				idPersona = (Integer)codice.get("id");
		
		if (idPersona != 0) {
			Persone persona = personeService.findByIdPersona(idPersona);
			DettagliCandidati listaSelects = dettagliCandidatiService.findByIdCandidato(idPersona);
			if (persona == null)
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			else {
				List<Object> datiCandidato = new ArrayList<Object>();
				List<Object> dettagliCandidato = new ArrayList<Object>();
				
				String esitoColloquio = esitiColloquioService.getEsitoColloquio(idPersona);
				dettagliCandidato.add(esitoColloquio);
				dettagliCandidato.add(esitiColloquioService.findAllException(esitoColloquio));
				
				String profilo = profiliService.getProfilo(idPersona);
				dettagliCandidato.add(profilo);
				dettagliCandidato.add(profiliService.findAllException(profilo));
				
				String[] linguaggi = linguaggiService.getLinguaggio(idPersona);
				dettagliCandidato.add(linguaggi);
				for (String linguaggio : linguaggi) {
					dettagliCandidato.add(linguaggiService.findAllException(linguaggio));
				}
				
				String[] lingue = lingueService.getLingua(idPersona);
				dettagliCandidato.add(lingue);
				for (String lingua : lingue) {
					dettagliCandidato.add(lingueService.findAllException(lingua));
				}
				
				String livello = livelliService.getSeniority(idPersona);
				dettagliCandidato.add(livello);
				dettagliCandidato.add(livelliService.findAllException(livello));
				
				datiCandidato.add(persona);
				datiCandidato.add(dettagliCandidato);
				datiCandidato.add(listaSelects);
			
				return new ResponseEntity<>(datiCandidato, HttpStatus.OK);
			}
		}
		else
			return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@RequestMapping("/elimina-candidato/{codiceCandidato}")
	public ResponseEntity<?> eliminaCandidato(@PathVariable("codiceCandidato") String codiceCandidato) {
		int idCandidato = 0;
		JSONObject appoggio = null;
		List<JSONObject> listaCodici = SecurityController.getListaCodiciCandidati();
		for (JSONObject codice : listaCodici) {
			if (((String)codice.get(("codice"))).equals(codiceCandidato)) {
				idCandidato = (Integer)codice.get("id");
				appoggio = codice;
			}
		}
		listaCodici.remove(appoggio);
		
		personeService.deleteById(idCandidato);
		dettagliCandidatiService.deleteByIdCandidato(idCandidato);
		commentiCandidatiService.deleteByIdCandidato(idCandidato);
		cvService.deleteByIdCandidato(idCandidato);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping("/controllo-email-modifica")
	public ResponseEntity<Integer> controlloEmailModifica(@RequestBody String email) {
		if (personeService.existsByEmail(email) != null)
			return new ResponseEntity<>(0, HttpStatus.OK);
		else
			return new ResponseEntity<>(1, HttpStatus.OK);
	}
	
	@RequestMapping("/modifica-candidato/{codiceCandidato}/{idDipendente}")
	public ResponseEntity<?> modificaCandidato(@PathVariable("codiceCandidato") String codiceCandidato, @PathVariable("idDipendente") int idDipendente, 
											@RequestBody JSONObject updateForm) {
		int idPersona = 0;
		List<JSONObject> listaCodici = SecurityController.getListaCodiciCandidati();
		for (JSONObject codice : listaCodici)
			if (((String)codice.get(("codice"))).equals(codiceCandidato))
				idPersona = (Integer)codice.get("id");
		
		personeService.updatePersona(idPersona,
			(String)updateForm.get("nome"),
			(String)updateForm.get("cognome"),
			(String)updateForm.get("cellulare"),
			(String)updateForm.get("email"),
			(String)updateForm.get("citta"));
			
		
		dettagliCandidatiService.updateCandidato(idPersona, 
			Integer.parseInt((String)updateForm.get("esitoColloquio")),
			LocalDate.parse((String)updateForm.get("dataColloquio")), 
			(Integer)updateForm.get("annoColloquio"), 
			(String)updateForm.get("fonteReperimento"), 
			(String)updateForm.get("competenzaPrincipale"), 
			Double.parseDouble((String)updateForm.get("costoGiornaliero")),
			(String)updateForm.get("possibilitaLavorativa"),
			(String)updateForm.get("competenzeTotali"), 
			(String)updateForm.get("certificazioni"),
			(String)updateForm.get("profiloLinkedin"));
		
		
		if ((String)updateForm.get("commento") != "")
		{
			CommentiCandidati commentiCandidato = new CommentiCandidati();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
			LocalDateTime now = LocalDateTime.now();
			commentiCandidato.setData(LocalDate.parse(format.format(now), format));
			commentiCandidato.setIdPersona(idDipendente);
			commentiCandidato.setIdDettaglioCandidato(idPersona);
			commentiCandidato.setNote((String)updateForm.get("commento"));
			commentiCandidatiService.save(commentiCandidato);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}