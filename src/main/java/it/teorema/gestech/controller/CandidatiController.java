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

import it.teorema.gestech.model.CommentiRisorse;
import it.teorema.gestech.model.DettagliRisorse;
import it.teorema.gestech.model.Risorse;
import it.teorema.gestech.service.CommentiRisorseService;
import it.teorema.gestech.service.DettagliRisorseService;
import it.teorema.gestech.service.EsitiColloquioService;
import it.teorema.gestech.service.LinguaggiService;
import it.teorema.gestech.service.LingueService;
import it.teorema.gestech.service.LivelliService;
import it.teorema.gestech.service.ProfiliService;
import it.teorema.gestech.service.RisorseService;

@Controller
public class CandidatiController {
	@Autowired
	RisorseService risorseService;
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
	DettagliRisorseService dettagliRisorseService;
	@Autowired
	CommentiRisorseService commentiRisorseService;
		
	@RequestMapping("/all-candidati")
	public ResponseEntity<List<Object>> allCandidati(HttpServletRequest request) {
		List<Object> lista = new ArrayList<>();
		lista.add(dettagliRisorseService.allCandidati());
		lista.add(SecurityController.getListaCodiciCandidati());
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@RequestMapping("/all-dipendenti")
	public ResponseEntity<List<Object>> allDipendenti() {
		return new ResponseEntity<>(dettagliRisorseService.allDipendenti(), HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/salva-candidato")
	public ResponseEntity<?> salvaCandidato(@RequestBody JSONObject formCandidato) {
		if (risorseService.existsByEmail((String) formCandidato.get("email")) != null)
			return new ResponseEntity<>(0, HttpStatus.OK);
		else
		{
			Risorse risorsa = new Risorse();
			DettagliRisorse dettagliRisorsa = new DettagliRisorse();
			CommentiRisorse commentiRisorse = new CommentiRisorse();
			
			DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
			DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
			LocalDateTime now = LocalDateTime.now();  
			LocalDateTime data = LocalDateTime.parse(format1.format(now), format1);	
	
			risorsa.setNomeCognome((String)formCandidato.get("nomeCognome"));
			risorsa.setRecapito((String)formCandidato.get("recapito"));
			risorsa.setEmail((String)formCandidato.get("email"));
			risorsa.setProfiloLinkedin((String)formCandidato.get("profiloLinkedin"));
			risorsa.setCitta((String)formCandidato.get("citta"));
			if (((String)formCandidato.get("dataColloquio")).equals(""))
				risorsa.setDataColloquio(null);
			else
				risorsa.setDataColloquio(LocalDate.parse((String)formCandidato.get("dataColloquio"), format2));
			risorsa.setAnnoColloquio((Integer)formCandidato.get("annoColloquio"));
			risorsa.setFonteReperimento((String)formCandidato.get("fonteReperimento"));
			risorsa.setCompetenzaPrincipale((String)formCandidato.get("competenzaPrincipale"));
			risorsa.setCostoGiornaliero(Double.parseDouble((String)formCandidato.get("costoGiornaliero")));
			risorsa.setPossibilitaLavorativa((String)formCandidato.get("possibilitaLavorativa"));
			risorsa.setSkillCampoLibero((String)formCandidato.get("skillCampoLibero"));
			risorsa.setCompetenzeTotali((String)formCandidato.get("competenzeTotali"));
			risorsa.setCertificazioni((String)formCandidato.get("certificazioni"));
			
			risorseService.save(risorsa);
			int idRisorsa = risorseService.findIdByEmail(risorsa.getEmail());	
	
			dettagliRisorsa.setDataInserimento(data);
			if ((String)formCandidato.get("cv") == null)
				dettagliRisorsa.setFileBase64(null);
			else
				dettagliRisorsa.setFileBase64((String)formCandidato.get("cv").toString());
			dettagliRisorsa.setIdEsitoColloquio(Integer.parseInt((String)formCandidato.get("esitoColloquio")));
			dettagliRisorsa.setIdProfilo(Integer.parseInt((String)formCandidato.get("profilo")));
			dettagliRisorsa.setIdLingua1(Integer.parseInt((String)formCandidato.get("lingua1")));
			dettagliRisorsa.setIdLingua2(Integer.parseInt((String)formCandidato.get("lingua2")));
			dettagliRisorsa.setIdLingua3(Integer.parseInt((String)formCandidato.get("lingua3")));
			dettagliRisorsa.setIdRisorsa(idRisorsa);
			dettagliRisorsa.setIdSeniority(Integer.parseInt((String)formCandidato.get("livello")));
			dettagliRisorsa.setIdSkill1(Integer.parseInt((String)formCandidato.get("skill1")));
			dettagliRisorsa.setIdSkill2(Integer.parseInt((String)formCandidato.get("skill2")));
			dettagliRisorsa.setIdSkill3(Integer.parseInt((String)formCandidato.get("skill3")));
			dettagliRisorsa.setIdSkill4(Integer.parseInt((String)formCandidato.get("skill4")));
			dettagliRisorsa.setIdSkill5(Integer.parseInt((String)formCandidato.get("skill5")));
				
			if ((String)formCandidato.get("commento") != "")
			{
				commentiRisorse.setData(LocalDate.parse(format1.format(now), format1));
				commentiRisorse.setIdMittente(Integer.parseInt((String)formCandidato.get("idRisorsa")));
				commentiRisorse.setIdDestinatario(idRisorsa);
				commentiRisorse.setNote((String)formCandidato.get("commento"));
				commentiRisorseService.save(commentiRisorse);
			}
			dettagliRisorseService.save(dettagliRisorsa);
			
			List<JSONObject> listaCodici = SecurityController.getListaCodiciCandidati();
			JSONObject oggetto = new JSONObject();
			UUID codice = UUID.randomUUID();
			oggetto.put("id", idRisorsa);
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
			Risorse risorsa = risorseService.findByIdRisorsa(idCandidato);
			if (risorsa == null)
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			else {
				List<Object> datiCandidato = new ArrayList<Object>();
				List<Object> dettagliCandidato = new ArrayList<Object>();
				
				dettagliCandidato.add(dettagliRisorseService.getDataInserimento(idCandidato));
				dettagliCandidato.add(esitiColloquioService.getEsitoColloquio(idCandidato));
				dettagliCandidato.add(profiliService.getProfilo(idCandidato));
				dettagliCandidato.add(linguaggiService.getSkill2(idCandidato));
				dettagliCandidato.add(linguaggiService.getSkill3(idCandidato));
				dettagliCandidato.add(linguaggiService.getSkill4(idCandidato));
				dettagliCandidato.add(linguaggiService.getSkill5(idCandidato));
				dettagliCandidato.add(lingueService.getLingua1(idCandidato));
				dettagliCandidato.add(lingueService.getLingua2(idCandidato));
				dettagliCandidato.add(lingueService.getLingua3(idCandidato));
				dettagliCandidato.add(livelliService.getSeniority(idCandidato));
						
				datiCandidato.add(risorsa);
				datiCandidato.add(dettagliCandidato);
				datiCandidato.add(commentiRisorseService.findByIdRisorsa(idCandidato));
				datiCandidato.add(esitiColloquioService.getColore((String)dettagliCandidato.get(1)));
				datiCandidato.add(dettagliRisorseService.getFile64(idCandidato));
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
			Risorse risorsa = risorseService.findByIdRisorsa(idCandidato);
			DettagliRisorse listaSelects = dettagliRisorseService.findByIdRisorsa(idCandidato);
			if (risorsa == null)
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
				
				String linguaggio1 = linguaggiService.getSkill1(idCandidato);
				dettagliCandidato.add(linguaggio1);
				dettagliCandidato.add(linguaggiService.findAllException(linguaggio1));
				
				String linguaggio2 = linguaggiService.getSkill2(idCandidato);
				dettagliCandidato.add(linguaggio2);
				dettagliCandidato.add(linguaggiService.findAllException(linguaggio2));
				
				String linguaggio3 = linguaggiService.getSkill3(idCandidato);
				dettagliCandidato.add(linguaggio3);
				dettagliCandidato.add(linguaggiService.findAllException(linguaggio3));
				
				String linguaggio4 = linguaggiService.getSkill4(idCandidato);
				dettagliCandidato.add(linguaggio4);
				dettagliCandidato.add(linguaggiService.findAllException(linguaggio4));
				
				String linguaggio5 = linguaggiService.getSkill5(idCandidato);
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
				
				datiCandidato.add(risorsa);
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
		
		risorseService.deleteById(idCandidato);
		dettagliRisorseService.deleteByIdCandidato(idCandidato);
		commentiRisorseService.deleteByIdCandidato(idCandidato);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping("/controllo-email-modifica")
	public ResponseEntity<Integer> controlloEmailModifica(@RequestBody String email) {
		if (risorseService.existsByEmail(email) != null)
			return new ResponseEntity<>(0, HttpStatus.OK);
		else
			return new ResponseEntity<>(1, HttpStatus.OK);
	}
	
	@RequestMapping("/modifica-candidato/{codiceCandidato}/{idRisorsa}")
	public ResponseEntity<?> modificaCandidato(@PathVariable("codiceCandidato") String codiceCandidato, @PathVariable("idRisorsa") int idRisorsa, 
											@RequestBody JSONObject updateForm) {
		int idCandidato = 0;
		List<JSONObject> listaCodici = SecurityController.getListaCodiciCandidati();
		for (JSONObject codice : listaCodici)
			if (((String)codice.get(("codice"))).equals(codiceCandidato))
				idCandidato = (Integer)codice.get("id");
		
		risorseService.updateCandidato(idCandidato,
			(String)updateForm.get("nomeCognome"), 
			(String)updateForm.get("recapito"),
			(String)updateForm.get("email"), 
			(String)updateForm.get("profiloLinkedin"), 
			(String)updateForm.get("citta"), 
			LocalDate.parse((String)updateForm.get("dataColloquio")), 
			(Integer)updateForm.get("annoColloquio"), 
			(String)updateForm.get("fonteReperimento"), 
			(String)updateForm.get("competenzaPrincipale"), 
			Double.parseDouble((String)updateForm.get("costoGiornaliero")),
			(String)updateForm.get("possibilitaLavorativa"), 
			(String)updateForm.get("skillCampoLibero"), 
			(String)updateForm.get("competenzeTotali"), 
			(String)updateForm.get("certificazioni"));
		
		dettagliRisorseService.updateCandidato(idCandidato, 
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
			Integer.parseInt((String)updateForm.get("livello")));
		
		if ((String)updateForm.get("commento") != "")
		{
			CommentiRisorse commentiRisorse = new CommentiRisorse();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
			LocalDateTime now = LocalDateTime.now();
			commentiRisorse.setData(LocalDate.parse(format.format(now), format));
			commentiRisorse.setIdMittente(idRisorsa);
			commentiRisorse.setIdDestinatario(idCandidato);
			commentiRisorse.setNote((String)updateForm.get("commento"));
			commentiRisorseService.save(commentiRisorse);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping("/get-dipendenti")
	public ResponseEntity<String[]> getDipendenti() {
		return new ResponseEntity<> (risorseService.getDipendenti(), HttpStatus.OK);
	}
}