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
import it.teorema.gestech.utils.ResponseHttp;

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
	public ResponseEntity<ResponseHttp> allEsitiColloquio(HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			responseHttp.setCode("1");
			responseHttp.setDataSource(esitiColloquioService.findAll());
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
	}

	@RequestMapping("/all-linguaggi")
	public ResponseEntity<ResponseHttp> allLinguaggi(HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			responseHttp.setCode("1");
			responseHttp.setDataSource(linguaggiService.findAll());
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
	}

	@RequestMapping("/all-lingue")
	public ResponseEntity<ResponseHttp> allLingue(HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			responseHttp.setCode("1");
			responseHttp.setDataSource(lingueService.findAll());
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
	}

	@RequestMapping("/all-livelli")
	public ResponseEntity<ResponseHttp> allLivelli(HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			responseHttp.setCode("1");
			responseHttp.setDataSource(livelliService.findAll());
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}

	}

	@RequestMapping("/all-profili")
	public ResponseEntity<ResponseHttp> ResponseHttp(HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			responseHttp.setCode("1");
			responseHttp.setDataSource(profiiliService.findAll());
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
	}

	@RequestMapping("/all-ruoli")
	public ResponseEntity<ResponseHttp> allRuoli(HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			responseHttp.setCode("1");
			responseHttp.setDataSource(ruoliService.findAll());
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
	}

	@RequestMapping("/all-ruoli-dipendente-admin")
	public ResponseEntity<ResponseHttp> allRuoliTranneDipendenteAdmin(HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			responseHttp.setCode("1");
			responseHttp.setDataSource(ruoliService.allRuoliTranneDipendenteAdmin());
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
	}

	@RequestMapping("/all-ruoli-dipendente-personale")
	public ResponseEntity<ResponseHttp> allRuoliTranneDipendentePersonale(HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			responseHttp.setCode("1");
			responseHttp.setDataSource(ruoliService.allRuoliTranneDipendentePersonale());
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
	}

	@RequestMapping("/all-stati-richiesta")
	public ResponseEntity<ResponseHttp> allStatiRichiesta(HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			responseHttp.setCode("1");
			responseHttp.setDataSource(statiRichiestaService.findAll());
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
	}

	@RequestMapping("/all-aziende")
	public ResponseEntity<ResponseHttp> allAziende(HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			responseHttp.setCode("1");
			responseHttp.setDataSource(aziendeService.findAll());
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
	}

	@RequestMapping("/all-clienti")
	public ResponseEntity<ResponseHttp> allClienti(HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			responseHttp.setCode("1");
			responseHttp.setDataSource(clientiService.findAll());
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
	}

	@RequestMapping("/all-contratti")
	public ResponseEntity<ResponseHttp> allContratti(HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			responseHttp.setCode("1");
			responseHttp.setDataSource(contrattiService.findAll());
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
	}
}