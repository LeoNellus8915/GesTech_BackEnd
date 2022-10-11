package it.teorema.gestech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import it.teorema.gestech.model.Aziende;
import it.teorema.gestech.model.Clienti;
import it.teorema.gestech.model.Contratti;
import it.teorema.gestech.model.EsitiColloquio;
import it.teorema.gestech.model.Linguaggi;
import it.teorema.gestech.model.Lingue;
import it.teorema.gestech.model.Livelli;
import it.teorema.gestech.model.Profili;
import it.teorema.gestech.model.Ruoli;
import it.teorema.gestech.model.StatiRichiesta;
import it.teorema.gestech.service.AziendeService;
import it.teorema.gestech.service.ClientiService;
import it.teorema.gestech.service.ContrattiService;
import it.teorema.gestech.service.EsitiColloquioService;
import it.teorema.gestech.service.LinguaggiService;
import it.teorema.gestech.service.LingueService;
import it.teorema.gestech.service.LivelliService;
import it.teorema.gestech.service.ProfiliService;
import it.teorema.gestech.service.RuoliService;
import it.teorema.gestech.service.StatiRichiestaService;

@Controller
public class GetListeController {
	@Autowired
	EsitiColloquioService esitiColloquioService;
	@Autowired
	LinguaggiService linguaggiService;
	@Autowired
	LingueService lingueService;
	@Autowired
	LivelliService livelliService;
	@Autowired
	ProfiliService profiiliService;
	@Autowired
	RuoliService ruoliService;
	@Autowired
	StatiRichiestaService statiRichiestaService;
	@Autowired
	AziendeService aziendeService;
	@Autowired
	ClientiService clientiService;
	@Autowired
	ContrattiService contrattiService;

	@RequestMapping("/all-esiti-colloquio")
	public ResponseEntity<List<EsitiColloquio>> allEsitiColloquio() {
		return new ResponseEntity<>(esitiColloquioService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping("/all-linguaggi")
	public ResponseEntity<List<Linguaggi>> allLinguaggi() {
		return new ResponseEntity<>(linguaggiService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping("/all-lingue")
	public ResponseEntity<List<Lingue>> allLingue() {
		return new ResponseEntity<>(lingueService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping("/all-livelli")
	public ResponseEntity<List<Livelli>> allLivelli() {
		return new ResponseEntity<>(livelliService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping("/all-profili")
	public ResponseEntity<List<Profili>> allProfili() {
		return new ResponseEntity<>(profiiliService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping("/all-ruoli")
	public ResponseEntity<List<Ruoli>> allRuoli() {
		return new ResponseEntity<>(ruoliService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping("/all-ruoli-dipendente-admin")
	public ResponseEntity<List<Ruoli>> allRuoliTranneDipendenteAdmin() {
		return new ResponseEntity<>(ruoliService.allRuoliTranneDipendenteAdmin(), HttpStatus.OK);
	}
	
	@RequestMapping("/all-ruoli-dipendente-personale")
	public ResponseEntity<List<Ruoli>> allRuoliTranneDipendentePersonale() {
		return new ResponseEntity<>(ruoliService.allRuoliTranneDipendentePersonale(), HttpStatus.OK);
	}
	
	@RequestMapping("/all-stati-richiesta")
	public ResponseEntity<List<StatiRichiesta>> allStatiRichiesta() {
		return new ResponseEntity<>(statiRichiestaService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping("/all-aziende")
	public ResponseEntity<List<Aziende>> allAziende() {
		return new ResponseEntity<>(aziendeService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping("/all-clienti")
	public ResponseEntity<List<Clienti>> allClienti() {
		return new ResponseEntity<>(clientiService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping("/all-contratti")
	public ResponseEntity<List<Contratti>> allContratti() {
		return new ResponseEntity<>(contrattiService.findAll(), HttpStatus.OK);
	}
}