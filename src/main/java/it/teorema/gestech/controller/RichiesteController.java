package it.teorema.gestech.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
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

import it.teorema.gestech.model.CommentiRichieste;
import it.teorema.gestech.model.Richieste;
import it.teorema.gestech.model.RichiesteDettagliCandidati;
import it.teorema.gestech.model.RichiestePersone;
import it.teorema.gestech.model.mapper.AllRichieste;
import it.teorema.gestech.model.mapper.AllRichiesteAperte;
import it.teorema.gestech.model.mapper.AllRichiesteChiuse;
import it.teorema.gestech.model.mapper.GetNomiRecruiter;
import it.teorema.gestech.service.CommentiRichiesteService;
import it.teorema.gestech.service.RichiesteService;
import it.teorema.gestech.service.RichiestePersoneService;
import it.teorema.gestech.service.PersoneService;
import it.teorema.gestech.service.RichiesteDettagliCandidatiService;
import it.teorema.gestech.service.StatiRichiestaService;
import it.teorema.gestech.utils.ResponseHttp;

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
	@Autowired
	SecurityController securityController;

	@SuppressWarnings("unchecked")
	@RequestMapping("/salva-richiesta/{ruolo}")
	public ResponseEntity<ResponseHttp> salvaRichiesta(@RequestBody JSONObject addForm, @PathVariable("ruolo") String ruolo,
			HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			Richieste richiesta = new Richieste();
			richiesta.setIdPersona(Integer.parseInt((String) addForm.get("idDipendente")));
			richiesta.setData(LocalDateTime.parse(dtf.format(now), dtf));
			richiesta.setIdLinguaggio(Integer.parseInt((String) addForm.get("linguaggio")));
			richiesta.setIdProfilo(Integer.parseInt((String) addForm.get("profilo")));
			richiesta.setIdLivello(Integer.parseInt((String) addForm.get("livello")));
			richiesta.setIdCliente(Integer.parseInt((String) addForm.get("cliente")));
			richiesta.setCitta((String) addForm.get("citta"));
			richiesta.setCosto(Double.parseDouble((String) addForm.get("costo")));
			richiesta.setNote((String) addForm.get("note"));
			richiesta.setIdStato(1);
			richiesta.setPriorita(0);
			richiesteService.save(richiesta);

			responseHttp.setCode("1");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}

	}

	@RequestMapping("/all-richieste-aperte-account/{idDipendente}")
	public ResponseEntity<ResponseHttp> allRichiesteAperteAccount(@PathVariable("idDipendente") int idDipendente,
			HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			responseHttp.setCode("1");
			responseHttp.setDataSource(richiesteService.stampaCardAperteAccount(idDipendente));
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
	}

	@RequestMapping("/all-richieste-aperte-commerciale")
	public ResponseEntity<ResponseHttp> allRichiesteAperteCommerciale(HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			responseHttp.setCode("1");
			responseHttp.setDataSource(richiesteService.stampaCardAperteCommerciale());
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
	}

	@RequestMapping("/all-richieste-aperte-recruiter") // Direttore Recruiter
	public ResponseEntity<ResponseHttp> allRichiesteAperteRecruiter(HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			responseHttp.setCode("1");
			responseHttp.setDataSource(richiesteService.stampaCardAperteRecruiter());
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
	}

	@RequestMapping("/all-richieste-aperte-admin")
	public ResponseEntity<ResponseHttp> allRichiesteAperteAdmin(HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			responseHttp.setCode("1");
			responseHttp.setDataSource(richiesteService.stampaCardAperteAdmin());
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
	}

	@RequestMapping("/all-richieste-aperte/{nome}/{cognome}/{idDipendente}")
	public ResponseEntity<ResponseHttp> allRichiesteAperte(@PathVariable("nome") String nome,
			@PathVariable("cognome") String cognome, @PathVariable("idDipendente") int idDipendente,
			HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			String nomeCognome = nome + "  " + cognome;
			responseHttp.setCode("1");
			responseHttp.setDataSource(richiesteService.stampaCardAperte(nomeCognome, idDipendente));
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
	}

	@RequestMapping("/all-richieste-chiuse/{ruolo}/{nomeCognome}/{idDipendente}")
	public ResponseEntity<ResponseHttp> allRichiesteChiuse(@PathVariable String ruolo, @PathVariable String nomeCognome,
			@PathVariable("idDipendente") int idDipendente, HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			responseHttp.setCode("1");
			responseHttp.setDataSource(richiesteService.stampaCardChiuse());
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
	}

	@RequestMapping("/get-richiesta/{idRichiesta}/{pagina}/{ruolo}")
	public ResponseEntity<ResponseHttp> getRichiesta(@PathVariable("idRichiesta") int idRichiesta,
			@PathVariable("pagina") int pagina, @PathVariable("ruolo") String ruolo, HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			List<Object> dati = new ArrayList<Object>();
			String nomeStatoRichiesta = statiRichiestaService.getStatoRichiesta(idRichiesta);
			dati.add(richiesteService.visualizzaRichiesta(idRichiesta));
			dati.add(nomeStatoRichiesta);
			dati.add(statiRichiestaService.getIdStatoRichiesta(nomeStatoRichiesta).toString());
			dati.add(statiRichiestaService.findAllException(nomeStatoRichiesta));
			dati.add(richiesteService.getCandidatiSelezionati(idRichiesta));
			if (ruolo.equals("Direttore Recruiter")) {
				dati.add(commentiRichiesteService.findRecruiterById(idRichiesta));
			} else if (ruolo.equals("Recruiter"))
				dati.add(commentiRichiesteService.findById(idRichiesta));
			else {
				dati.add(commentiRichiesteService.findAltriById(idRichiesta));
			}
			responseHttp.setCode("1");
			responseHttp.setDataSource(dati);
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}

	}

	@RequestMapping("salva-priorita/{ruolo}")
	public ResponseEntity<ResponseHttp> salvaPriorita(@RequestBody List<JSONObject> listaPriorita,
			@PathVariable("ruolo") String ruolo, HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			for (JSONObject oggetto : listaPriorita) {
				richiesteService.setPriorita((Integer) oggetto.get("idRichiesta"), (Integer) oggetto.get("priorita"));
			}
			responseHttp.setCode("1");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
	}

	
	@RequestMapping("/elimina-richiesta/{idRichiesta}/{pagina}/{ruolo}")
	public ResponseEntity<ResponseHttp> eliminaRichiesta(@PathVariable("idRichiesta") int idRichiesta, 
		  										@PathVariable("pagina") int pagina, @PathVariable("ruolo") String ruolo, 
		  										HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			richiesteService.deleteById(idRichiesta);
			commentiRichiesteService.deleteCommento(idRichiesta);
			richiestePersoneService.deleteDipendenteRichiesta(idRichiesta); 
			responseHttp.setCode("1");
			return new ResponseEntity<> (responseHttp, HttpStatus.OK); 
		}
	}
	 
	
	@RequestMapping("/get-nomi-recruiter")
	public ResponseEntity<ResponseHttp> getNomiRecruiter(HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			List<GetNomiRecruiter> getNomiRecruiter = dipendentiService.getNomiRecruiter();
			List<String> nomiRecruiter = new ArrayList<String>();
			for (GetNomiRecruiter element : getNomiRecruiter) {
				nomiRecruiter.add(element.getNome() + "  " + element.getCognome());
			}
			responseHttp.setCode("1");
			responseHttp.setDataSource(nomiRecruiter);
			return new ResponseEntity<> (responseHttp, HttpStatus.OK); 
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/modifica-richiesta/{idRichiesta}/{idPersona}/{pagina}/{ruolo}")
	public ResponseEntity<ResponseHttp> modificaRichiesta(@PathVariable("idRichiesta") int idRichiesta,
			@PathVariable("idPersona") int idPersona, @PathVariable("pagina") int pagina,
			@PathVariable("ruolo") String ruolo, @RequestBody JSONObject updateForm, HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			if (!ruolo.equals("Recruiter")) {
				String listaRecruiters;
				if (updateForm.get("listaRecruiters").toString().equals("[]"))
					listaRecruiters = null;
				else
					listaRecruiters = (String) updateForm.get("listaRecruiters").toString().replace("[", "")
							.replace("]", "");

				Richieste modificaRichiesta = new Richieste(idRichiesta, listaRecruiters,
						Integer.parseInt((String) updateForm.get("statoRichiesta")),
						Integer.parseInt((String) updateForm.get("priorita")));

				richiesteService.updateRichiesta(modificaRichiesta);

				String[] recruiters = updateForm.get("listaRecruiters").toString().replace("[", "").replace("]", "")
						.split(", ");
				List<GetNomiRecruiter> recruiter = new ArrayList<GetNomiRecruiter>();
				if (ruolo.equals("Direttore Recruiter") && !recruiters[0].equals("")) {
					if (updateForm.get("listaRecruiters").toString().indexOf("Tutti") > -1) {
						recruiter = dipendentiService.getNomiRecruiter();
						for (int c = 0; c < recruiter.size(); c++) {
							RichiesteDettagliCandidati rdc = new RichiesteDettagliCandidati(idRichiesta,
									dipendentiService.findByName(recruiter.get(c).getNome(),
											recruiter.get(c).getCognome()));
							richiesteDettagliCandidatiService.save(rdc);
						}
					} else if (recruiters.length > 0)
						for (int c = 0; c < recruiters.length; c++) {
							String[] rec = recruiters[c].toString().split("  ");
							richiestePersoneService.save(new RichiestePersone(idRichiesta,
									dipendentiService.findByName((String) rec[0], (String) rec[1])));
						}
				}

				if (Integer.parseInt((String) updateForm.get("statoRichiesta")) == 3) {
					richiestePersoneService.setVisualizzato(idRichiesta);
				}
				if ((String) updateForm.get("commento") != "") {
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					LocalDateTime now = LocalDateTime.now();
					CommentiRichieste commentoRichiesta = new CommentiRichieste();
					commentoRichiesta.setData(LocalDateTime.parse(dtf.format(now), dtf));
					commentoRichiesta.setIdPersona(idPersona);
					commentoRichiesta.setIdRichiesta(idRichiesta);
					commentoRichiesta.setNote((String) updateForm.get("commento"));
					if (commentiRichiesteService.recruiterPresente(idRichiesta) == null && listaRecruiters == null)
						commentoRichiesta.setNascosto(false);
					else
						commentoRichiesta.setNascosto(true);
					commentiRichiesteService.save(commentoRichiesta);
				}
			} else if ((String) updateForm.get("commento") != "") {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				CommentiRichieste commentoRichiesta = new CommentiRichieste();
				commentoRichiesta.setData(LocalDateTime.parse(dtf.format(now), dtf));
				commentoRichiesta.setIdPersona(idPersona);
				commentoRichiesta.setIdRichiesta(idRichiesta);
				commentoRichiesta.setNote((String) updateForm.get("commento"));
				commentoRichiesta.setNascosto(true);
				commentiRichiesteService.save(commentoRichiesta);
			}
			responseHttp.setCode("1");
			return new ResponseEntity<> (responseHttp, HttpStatus.OK); 
		}

	}

	@RequestMapping("/set-visualizzato/{idRichiesta}/{idDipendente}")
	public ResponseEntity<ResponseHttp> setVisualizzato(@PathVariable("idRichiesta") int idRichiesta,
			@PathVariable("idDipendente") int idDipendente, HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			richiestePersoneService.setVisualizzato(idRichiesta, idDipendente);
			responseHttp.setCode("1");
			return new ResponseEntity<> (responseHttp, HttpStatus.OK); 
		}
	}

	@RequestMapping("/assegna-candidati/{idRichiesta}")
	public ResponseEntity<ResponseHttp> assegnaCandidati(@RequestBody String listaCandidati,
			@PathVariable("idRichiesta") int idRichiesta, HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			String[] candidati = listaCandidati.split(",");
			for (int i = 0; i < candidati.length; i++) {
				RichiesteDettagliCandidati rdc = new RichiesteDettagliCandidati(Integer.parseInt(candidati[i]), idRichiesta);
				richiesteDettagliCandidatiService.save(rdc);
			}
			richiesteService.setStato(idRichiesta);
			responseHttp.setCode("1");
			return new ResponseEntity<> (responseHttp, HttpStatus.OK); 
		}
	}
}
