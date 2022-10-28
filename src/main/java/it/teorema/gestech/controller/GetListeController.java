package it.teorema.gestech.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	@Autowired
	SecurityController securityController;

	@RequestMapping("/all-esiti-colloquio")
	public ResponseEntity<List<EsitiColloquio>> allEsitiColloquio(HttpServletRequest request) {
		if (securityController.controlloToken(request.getHeader("App-Key")) == false)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else {
			return new ResponseEntity<>(esitiColloquioService.findAll(), HttpStatus.OK);
		}
	}

	@RequestMapping("/all-linguaggi")
	public ResponseEntity<List<Linguaggi>> allLinguaggi(HttpServletRequest request) {
		if (securityController.controlloToken(request.getHeader("App-Key")) == false)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else {
			return new ResponseEntity<>(linguaggiService.findAll(), HttpStatus.OK);
		}
	}

	@RequestMapping("/all-lingue")
	public ResponseEntity<List<Lingue>> allLingue(HttpServletRequest request) {
		if (securityController.controlloToken(request.getHeader("App-Key")) == false)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else {
			return new ResponseEntity<>(lingueService.findAll(), HttpStatus.OK);
		}
	}

	@RequestMapping("/all-livelli")
	public ResponseEntity<List<Livelli>> allLivelli(HttpServletRequest request) {
		if (securityController.controlloToken(request.getHeader("App-Key")) == false)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else {
			return new ResponseEntity<>(livelliService.findAll(), HttpStatus.OK);
		}

	}

	@RequestMapping("/all-profili")
	public ResponseEntity<List<Profili>> allProfili(HttpServletRequest request) {
		if (securityController.controlloToken(request.getHeader("App-Key")) == false)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else {
			return new ResponseEntity<>(profiiliService.findAll(), HttpStatus.OK);
		}
	}

	@RequestMapping("/all-ruoli")
	public ResponseEntity<List<Ruoli>> allRuoli(HttpServletRequest request) {
		if (securityController.controlloToken(request.getHeader("App-Key")) == false)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else {
			return new ResponseEntity<>(ruoliService.findAll(), HttpStatus.OK);
		}
	}

	@RequestMapping("/all-ruoli-dipendente-admin")
	public ResponseEntity<List<Ruoli>> allRuoliTranneDipendenteAdmin(HttpServletRequest request) {
		if (securityController.controlloToken(request.getHeader("App-Key")) == false)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else {
			return new ResponseEntity<>(ruoliService.allRuoliTranneDipendenteAdmin(), HttpStatus.OK);
		}
	}

	@RequestMapping("/all-ruoli-dipendente-personale")
	public ResponseEntity<List<Ruoli>> allRuoliTranneDipendentePersonale(HttpServletRequest request) {
		if (securityController.controlloToken(request.getHeader("App-Key")) == false)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else {
			return new ResponseEntity<>(ruoliService.allRuoliTranneDipendentePersonale(), HttpStatus.OK);
		}
	}

	@RequestMapping("/all-stati-richiesta")
	public ResponseEntity<List<StatiRichiesta>> allStatiRichiesta(HttpServletRequest request) {
		if (securityController.controlloToken(request.getHeader("App-Key")) == false)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else {
			return new ResponseEntity<>(statiRichiestaService.findAll(), HttpStatus.OK);
		}
	}

	@RequestMapping("/all-aziende")
	public ResponseEntity<List<Aziende>> allAziende(HttpServletRequest request) {
		if (securityController.controlloToken(request.getHeader("App-Key")) == false)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(aziendeService.findAll(), HttpStatus.OK);
	}

	@RequestMapping("/all-clienti")
	public ResponseEntity<List<Clienti>> allClienti(HttpServletRequest request) {
		if (securityController.controlloToken(request.getHeader("App-Key")) == false)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else {
			return new ResponseEntity<>(clientiService.findAll(), HttpStatus.OK);
		}
	}

	@RequestMapping("/all-contratti")
	public ResponseEntity<List<Contratti>> allContratti(HttpServletRequest request) {
		if (securityController.controlloToken(request.getHeader("App-Key")) == false)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else {
			return new ResponseEntity<>(contrattiService.findAll(), HttpStatus.OK);
		}
	}
}