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
import it.teorema.gestech.model.DettagliCandidati;
import it.teorema.gestech.model.Candidati;
import it.teorema.gestech.service.CommentiCandidatiService;
import it.teorema.gestech.service.DettagliCandidatiService;
import it.teorema.gestech.service.DipendentiService;
import it.teorema.gestech.service.EsitiColloquioService;
import it.teorema.gestech.service.LinguaggiService;
import it.teorema.gestech.service.LingueService;
import it.teorema.gestech.service.LivelliService;
import it.teorema.gestech.service.ProfiliService;
import it.teorema.gestech.service.CandidatiService;

@Controller
public class CandidatiController {
	@Autowired
	CandidatiService candidatiService;
	@Autowired
	DipendentiService dipendentiService;
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
		
	@RequestMapping("/all-candidati")
	public ResponseEntity<List<Object>> allCandidati(HttpServletRequest request) {
		List<Object> lista = new ArrayList<>();
		lista.add(dettagliCandidatiService.allCandidati());
		lista.add(SecurityController.getListaCodiciCandidati());
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/salva-candidato")
	public ResponseEntity<?> salvaCandidato(@RequestBody JSONObject formCandidato) {
		if (candidatiService.existsByEmail((String) formCandidato.get("email")) != null ||
				dipendentiService.existsByEmail((String) formCandidato.get("email")) != null)
			return new ResponseEntity<>(0, HttpStatus.OK);
		else
		{
			Candidati candidato = new Candidati();
			DettagliCandidati dettagliCandidato = new DettagliCandidati();
			CommentiCandidati commentiCandidato = new CommentiCandidati();
			
			DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
			DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
			LocalDateTime now = LocalDateTime.now();  
			LocalDateTime data = LocalDateTime.parse(format1.format(now), format1);	
	
			candidato.setNomeCognome((String)formCandidato.get("nomeCognome"));
			candidato.setCellulare((String)formCandidato.get("cellulare"));
			candidato.setEmail((String)formCandidato.get("email"));
			candidato.setProfiloLinkedin((String)formCandidato.get("profiloLinkedin"));
			candidato.setCitta((String)formCandidato.get("citta"));
			
			System.out.println(formCandidato);
			
			candidatiService.save(candidato);
			
			int idCandidato = candidatiService.findIdByEmail(candidato.getEmail());
			
			if (((String)formCandidato.get("dataColloquio")).equals(""))
				dettagliCandidato.setDataColloquio(null);
			else
				dettagliCandidato.setDataColloquio(LocalDate.parse((String)formCandidato.get("dataColloquio"), format2));
			dettagliCandidato.setAnnoColloquio((Integer)formCandidato.get("annoColloquio"));
			dettagliCandidato.setFonteReperimento((String)formCandidato.get("fonteReperimento"));
			dettagliCandidato.setCompetenzaPrincipale((String)formCandidato.get("competenzaPrincipale"));
			dettagliCandidato.setCostoGiornaliero(Double.parseDouble((String)formCandidato.get("costoGiornaliero")));
			dettagliCandidato.setPossibilitaLavorativa((String)formCandidato.get("possibilitaLavorativa"));
			dettagliCandidato.setLinguaggioCampoLibero((String)formCandidato.get("skillCampoLibero"));
			dettagliCandidato.setCompetenzeTotali((String)formCandidato.get("competenzeTotali"));
			dettagliCandidato.setCertificazioni((String)formCandidato.get("certificazioni"));
			dettagliCandidato.setDataInserimento(data);
			if ((String)formCandidato.get("cv") == null)
				dettagliCandidato.setFileBase64(null);
			else
				dettagliCandidato.setFileBase64((String)formCandidato.get("cv").toString());
			dettagliCandidato.setIdEsitoColloquio(Integer.parseInt((String)formCandidato.get("esitoColloquio")));
			dettagliCandidato.setIdProfilo(Integer.parseInt((String)formCandidato.get("profilo")));
			dettagliCandidato.setIdLingua1(Integer.parseInt((String)formCandidato.get("lingua1")));
			dettagliCandidato.setIdLingua2(Integer.parseInt((String)formCandidato.get("lingua2")));
			dettagliCandidato.setIdLingua3(Integer.parseInt((String)formCandidato.get("lingua3")));
			dettagliCandidato.setIdCandidato(idCandidato);
			dettagliCandidato.setIdLivello(Integer.parseInt((String)formCandidato.get("livello")));
			dettagliCandidato.setIdLinguaggio1(Integer.parseInt((String)formCandidato.get("linguaggio1")));
			dettagliCandidato.setIdLinguaggio2(Integer.parseInt((String)formCandidato.get("linguaggio2")));
			dettagliCandidato.setIdLinguaggio3(Integer.parseInt((String)formCandidato.get("linguaggio3")));
			dettagliCandidato.setIdLinguaggio4(Integer.parseInt((String)formCandidato.get("linguaggio4")));
			dettagliCandidato.setIdLinguaggio5(Integer.parseInt((String)formCandidato.get("linguaggio5")));
				
			if ((String)formCandidato.get("commento") != "")
			{
				commentiCandidato.setData(LocalDate.parse(format1.format(now), format1));
				commentiCandidato.setIdDipendente(Integer.parseInt((String)formCandidato.get("idDipendente")));
				commentiCandidato.setIdCandidato(idCandidato);
				commentiCandidato.setNote((String)formCandidato.get("commento"));
				commentiCandidatiService.save(commentiCandidato);
			}
			dettagliCandidatiService.save(dettagliCandidato);
			
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
		int idCandidato = 0;
		List<JSONObject> listaCodici = SecurityController.getListaCodiciCandidati();
		
		for (JSONObject codice : listaCodici)
			if (((String)codice.get(("codice"))).equals(codiceCandidato))
				idCandidato = (Integer)codice.get("id");
		
		if (idCandidato != 0) {
			Candidati candidato = candidatiService.findByIdCandidato(idCandidato);
			if (candidato == null)
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			else {
				List<Object> datiCandidato = new ArrayList<Object>();
				List<Object> dettagliCandidato = new ArrayList<Object>();
				
				dettagliCandidato.add(dettagliCandidatiService.getDettagliCandidato(idCandidato));
				dettagliCandidato.add(esitiColloquioService.getEsitoColloquio(idCandidato));
				dettagliCandidato.add(profiliService.getProfilo(idCandidato));
				dettagliCandidato.add(linguaggiService.getLinguaggio1(idCandidato));
				dettagliCandidato.add(linguaggiService.getLinguaggio2(idCandidato));
				dettagliCandidato.add(linguaggiService.getLinguaggio3(idCandidato));
				dettagliCandidato.add(linguaggiService.getLinguaggio4(idCandidato));
				dettagliCandidato.add(linguaggiService.getLinguaggio5(idCandidato));
				dettagliCandidato.add(lingueService.getLingua1(idCandidato));
				dettagliCandidato.add(lingueService.getLingua2(idCandidato));
				dettagliCandidato.add(lingueService.getLingua3(idCandidato));
				dettagliCandidato.add(livelliService.getSeniority(idCandidato));
						
				datiCandidato.add(candidato);
				datiCandidato.add(dettagliCandidato);
				datiCandidato.add(commentiCandidatiService.findByIdCandidato(idCandidato));
				datiCandidato.add(esitiColloquioService.getColore((String)dettagliCandidato.get(1)));
				datiCandidato.add(dettagliCandidatiService.getFile64(idCandidato));
				return new ResponseEntity<>(datiCandidato, HttpStatus.OK);
			}
		}
		else
			return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@RequestMapping("/get-candidato-modifica/{codiceCandidato}")
	public ResponseEntity<List<Object>> getCandidatoModifica(@PathVariable("codiceCandidato") String codiceCandidato) {
		int idCandidato = 0;
		List<JSONObject> listaCodici = SecurityController.getListaCodiciCandidati();
		
		for (JSONObject codice : listaCodici)
			if (((String)codice.get(("codice"))).equals(codiceCandidato))
				idCandidato = (Integer)codice.get("id");
		
		if (idCandidato != 0) {
			Candidati candidato = candidatiService.findByIdCandidato(idCandidato);
			DettagliCandidati listaSelects = dettagliCandidatiService.findByIdCandidato(idCandidato);
			if (candidato == null)
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			else {
				List<Object> datiCandidato = new ArrayList<Object>();
				List<Object> dettagliCandidato = new ArrayList<Object>();
				
				String esitoColloquio = esitiColloquioService.getEsitoColloquio(idCandidato);
				dettagliCandidato.add(esitoColloquio);
				dettagliCandidato.add(esitiColloquioService.findAllException(esitoColloquio));
				
				String profilo = profiliService.getProfilo(idCandidato);
				dettagliCandidato.add(profilo);
				dettagliCandidato.add(profiliService.findAllException(profilo));
				
				String linguaggio1 = linguaggiService.getLinguaggio1(idCandidato);
				dettagliCandidato.add(linguaggio1);
				dettagliCandidato.add(linguaggiService.findAllException(linguaggio1));
				
				String linguaggio2 = linguaggiService.getLinguaggio2(idCandidato);
				dettagliCandidato.add(linguaggio2);
				dettagliCandidato.add(linguaggiService.findAllException(linguaggio2));
				
				String linguaggio3 = linguaggiService.getLinguaggio3(idCandidato);
				dettagliCandidato.add(linguaggio3);
				dettagliCandidato.add(linguaggiService.findAllException(linguaggio3));
				
				String linguaggio4 = linguaggiService.getLinguaggio4(idCandidato);
				dettagliCandidato.add(linguaggio4);
				dettagliCandidato.add(linguaggiService.findAllException(linguaggio4));
				
				String linguaggio5 = linguaggiService.getLinguaggio5(idCandidato);
				dettagliCandidato.add(linguaggio5);
				dettagliCandidato.add(linguaggiService.findAllException(linguaggio5));
				
				String lingua1 = lingueService.getLingua1(idCandidato);
				dettagliCandidato.add(lingua1);
				dettagliCandidato.add(lingueService.findAllException(lingua1));
				
				String lingua2 = lingueService.getLingua2(idCandidato);
				dettagliCandidato.add(lingua2);
				dettagliCandidato.add(lingueService.findAllException(lingua2));
				
				String lingua3 = lingueService.getLingua3(idCandidato);
				dettagliCandidato.add(lingua3);
				dettagliCandidato.add(lingueService.findAllException(lingua3));
				
				String livello = livelliService.getSeniority(idCandidato);
				dettagliCandidato.add(livello);
				dettagliCandidato.add(livelliService.findAllException(livello));
				
				datiCandidato.add(candidato);
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
		
		candidatiService.deleteById(idCandidato);
		dettagliCandidatiService.deleteByIdCandidato(idCandidato);
		commentiCandidatiService.deleteByIdCandidato(idCandidato);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping("/controllo-email-modifica")
	public ResponseEntity<Integer> controlloEmailModifica(@RequestBody String email) {
		if (candidatiService.existsByEmail(email) != null)
			return new ResponseEntity<>(0, HttpStatus.OK);
		else
			return new ResponseEntity<>(1, HttpStatus.OK);
	}
	
	@RequestMapping("/modifica-candidato/{codiceCandidato}/{idDipendente}")
	public ResponseEntity<?> modificaCandidato(@PathVariable("codiceCandidato") String codiceCandidato, @PathVariable("idDipendente") int idDipendente, 
											@RequestBody JSONObject updateForm) {
		int idCandidato = 0;
		List<JSONObject> listaCodici = SecurityController.getListaCodiciCandidati();
		for (JSONObject codice : listaCodici)
			if (((String)codice.get(("codice"))).equals(codiceCandidato))
				idCandidato = (Integer)codice.get("id");
		
		candidatiService.updateCandidato(idCandidato,
			(String)updateForm.get("nomeCognome"), 
			(String)updateForm.get("cellulare"),
			(String)updateForm.get("email"), 
			(String)updateForm.get("profiloLinkedin"), 
			(String)updateForm.get("citta"));
			
		
		dettagliCandidatiService.updateCandidato(idCandidato, 
			Integer.parseInt((String)updateForm.get("esitoColloquio")), 
			Integer.parseInt((String)updateForm.get("profilo")), 
			Integer.parseInt((String)updateForm.get("skill1")),
			Integer.parseInt((String)updateForm.get("skill2")), 
			Integer.parseInt((String)updateForm.get("skill3")), 
			Integer.parseInt((String)updateForm.get("skill4")), 
			Integer.parseInt((String)updateForm.get("skill5")), 
			Integer.parseInt((String)updateForm.get("lingua1")), 
			Integer.parseInt((String)updateForm.get("lingua2")), 
			Integer.parseInt((String)updateForm.get("lingua3")), 
			Integer.parseInt((String)updateForm.get("livello")),
			LocalDate.parse((String)updateForm.get("dataColloquio")), 
			(Integer)updateForm.get("annoColloquio"), 
			(String)updateForm.get("fonteReperimento"), 
			(String)updateForm.get("competenzaPrincipale"), 
			Double.parseDouble((String)updateForm.get("costoGiornaliero")),
			(String)updateForm.get("possibilitaLavorativa"), 
			(String)updateForm.get("linguaggioCampoLibero"), 
			(String)updateForm.get("competenzeTotali"), 
			(String)updateForm.get("certificazioni"));
		
		if ((String)updateForm.get("commento") != "")
		{
			CommentiCandidati commentiCandidato = new CommentiCandidati();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
			LocalDateTime now = LocalDateTime.now();
			commentiCandidato.setData(LocalDate.parse(format.format(now), format));
			commentiCandidato.setIdDipendente(idDipendente);
			commentiCandidato.setIdCandidato(idCandidato);
			commentiCandidato.setNote((String)updateForm.get("commento"));
			commentiCandidatiService.save(commentiCandidato);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}