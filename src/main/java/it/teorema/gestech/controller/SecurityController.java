package it.teorema.gestech.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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
import org.springframework.web.bind.annotation.RequestMapping;

import it.teorema.gestech.service.HardwareService;
import it.teorema.gestech.service.PersoneService;
import it.teorema.gestech.service.RichiesteService;
import it.teorema.gestech.service.SessionService;

@Controller
public class SecurityController {
	@Autowired
	RichiesteService richiesteService;
	@Autowired
	PersoneService personeService;
	@Autowired
	HardwareService hardwareService;
	@Autowired
	SessionService sessionService;

	private static List<JSONObject> listaCodiciCandidati;
	private static List<JSONObject> listaCodiciRichiesteAperteAdmin;
	private static List<JSONObject> listaCodiciRichiesteAperteAccount;
	private static List<JSONObject> listaCodiciRichiesteAperteCommerciale;
	private static List<JSONObject> listaCodiciRichiesteAperteRecruiter;
	private static List<JSONObject> listaCodiciRichiesteAperte;
	private static List<JSONObject> listaCodiciRichiesteChiuse;
	private static List<JSONObject> listaCodiciHardware;

	@SuppressWarnings("unchecked")
	@RequestMapping("/get-codici-candidati")
	public ResponseEntity<?> getCodiciCandidati(HttpServletRequest request) {
		if (controlloToken(request.getHeader("App-Key")) == false)
			return new ResponseEntity<>(null, HttpStatus.OK);
		else {
			List<JSONObject> listaCodici = new ArrayList<JSONObject>();
			List<Integer> listaId = personeService.getIdPersone();
			for (Integer id : listaId) {
				JSONObject oggetto = new JSONObject();
				UUID codice = UUID.randomUUID();
				oggetto.put("id", id);
				oggetto.put("codice", codice.toString().replaceAll("-", ""));
				listaCodici.add(oggetto);
				// controllo sul se esce uguale
			}
			listaCodiciCandidati = listaCodici;
			return new ResponseEntity<>(HttpStatus.OK);
		}

	}

	public static List<JSONObject> getListaCodiciCandidati() {
		return listaCodiciCandidati;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/get-codici-richieste-aperte-account/{idDipendente}")
	public ResponseEntity<?> getCodiciRichiesteAperteAccount(@PathVariable("idDipendente") int idDipendente,
			HttpServletRequest request) {
		if (controlloToken(request.getHeader("App-Key")) == false)
			return new ResponseEntity<>(null, HttpStatus.OK);
		else {
			List<JSONObject> listaCodici = new ArrayList<JSONObject>();
			List<Integer> listaId = richiesteService.getIdRichiesteAperteAccount(idDipendente);
			for (Integer id : listaId) {
				JSONObject oggetto = new JSONObject();
				UUID codice = UUID.randomUUID();
				oggetto.put("id", id);
				oggetto.put("codice", codice.toString().replaceAll("-", ""));
				listaCodici.add(oggetto);
				// controllo sul se esce uguale

			}
			listaCodiciRichiesteAperteAccount = listaCodici;
			return new ResponseEntity<>(HttpStatus.OK);
		}

	}

	public static List<JSONObject> getListaCodiciRichiesteAperteAccount() {
		return listaCodiciRichiesteAperteAccount;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/get-codici-richieste-aperte-commerciale")
	public ResponseEntity<?> getCodiciRichiesteAperteCommerciale(HttpServletRequest request) {
		if (controlloToken(request.getHeader("App-Key")) == false)
			return new ResponseEntity<>(null, HttpStatus.OK);
		else {
			List<JSONObject> listaCodici = new ArrayList<JSONObject>();
			List<Integer> listaId = richiesteService.getIdRichiesteAperteCommerciale();
			for (Integer id : listaId) {
				JSONObject oggetto = new JSONObject();
				UUID codice = UUID.randomUUID();
				oggetto.put("id", id);
				oggetto.put("codice", codice.toString().replaceAll("-", ""));
				listaCodici.add(oggetto);
				// controllo sul se esce uguale
			}
			listaCodiciRichiesteAperteCommerciale = listaCodici;
			return new ResponseEntity<>(HttpStatus.OK);
		}

	}

	public static List<JSONObject> getListaCodiciRichiesteAperteCommerciale() {
		return listaCodiciRichiesteAperteCommerciale;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/get-codici-richieste-aperte-recruiter")
	public ResponseEntity<?> getCodiciRichiesteAperteRecruiter(HttpServletRequest request) {
		if (controlloToken(request.getHeader("App-Key")) == false)
			return new ResponseEntity<>(null, HttpStatus.OK);
		else {
			List<JSONObject> listaCodici = new ArrayList<JSONObject>();
			List<Integer> listaId = richiesteService.getIdRichiesteAperteRecruiter();
			for (Integer id : listaId) {
				JSONObject oggetto = new JSONObject();
				UUID codice = UUID.randomUUID();
				oggetto.put("id", id);
				oggetto.put("codice", codice.toString().replaceAll("-", ""));
				listaCodici.add(oggetto);
				// controllo sul se esce uguale
			}
			listaCodiciRichiesteAperteRecruiter = listaCodici;
			return new ResponseEntity<>(HttpStatus.OK);
		}

	}

	public static List<JSONObject> getListaCodiciRichiesteAperteRecruiter() {
		return listaCodiciRichiesteAperteRecruiter;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/get-codici-richieste-aperte-admin")
	public ResponseEntity<?> getCodiciRichiesteAperteAdmin(HttpServletRequest request) {
		if (controlloToken(request.getHeader("App-Key")) == false)
			return new ResponseEntity<>(null, HttpStatus.OK);
		else {
			List<JSONObject> listaCodici = new ArrayList<JSONObject>();
			List<Integer> listaId = richiesteService.getIdRichiesteAperteAdmin();
			for (Integer id : listaId) {
				JSONObject oggetto = new JSONObject();
				UUID codice = UUID.randomUUID();
				oggetto.put("id", id);
				oggetto.put("codice", codice.toString().replaceAll("-", ""));
				listaCodici.add(oggetto);
				// controllo sul se esce uguale
			}
			listaCodiciRichiesteAperteAdmin = listaCodici;
			return new ResponseEntity<>(HttpStatus.OK);
		}

	}

	public static List<JSONObject> getListaCodiciRichiesteAperteAdmin() {
		return listaCodiciRichiesteAperteAdmin;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/get-codici-richieste-aperte/{nome}/{cognome}")
	public ResponseEntity<?> getCodiciRichiesteAperte(@PathVariable("nome") String nome,
			@PathVariable("cognome") String cognome, HttpServletRequest request) {
		if (controlloToken(request.getHeader("App-Key")) == false)
			return new ResponseEntity<>(null, HttpStatus.OK);
		else {
			List<JSONObject> listaCodici = new ArrayList<JSONObject>();
			String cognomeNome = cognome + "  " + nome;
			List<Integer> listaId = richiesteService.getIdRichiesteAperte(cognomeNome);
			for (Integer id : listaId) {
				JSONObject oggetto = new JSONObject();
				UUID codice = UUID.randomUUID();
				oggetto.put("id", id);
				oggetto.put("codice", codice.toString().replaceAll("-", ""));
				listaCodici.add(oggetto);
				// controllo sul se esce uguale
			}
			listaCodiciRichiesteAperte = listaCodici;
			return new ResponseEntity<>(HttpStatus.OK);
		}

	}

	public static List<JSONObject> getListaCodiciRichiesteAperte() {
		return listaCodiciRichiesteAperte;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/get-codici-richieste-chiuse")
	public ResponseEntity<?> getCodiciRichiesteChiuse(HttpServletRequest request) {
		if (controlloToken(request.getHeader("App-Key")) == false)
			return new ResponseEntity<>(null, HttpStatus.OK);
		else {
			List<JSONObject> listaCodici = new ArrayList<JSONObject>();
			List<Integer> listaId = richiesteService.getIdRichiesteChiuse();
			for (Integer id : listaId) {
				JSONObject oggetto = new JSONObject();
				UUID codice = UUID.randomUUID();
				oggetto.put("id", id);
				oggetto.put("codice", codice.toString().replaceAll("-", ""));
				listaCodici.add(oggetto);
				// controllo sul se esce uguale
			}
			listaCodiciRichiesteChiuse = listaCodici;
			return new ResponseEntity<>(HttpStatus.OK);
		}

	}

	public static List<JSONObject> getListaCodiciRichiesteChiuse() {
		return listaCodiciRichiesteChiuse;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/get-codici-hardware")
	public ResponseEntity<?> getCodiciHardware(HttpServletRequest request) {
		if (controlloToken(request.getHeader("App-Key")) == false)
			return new ResponseEntity<>(null, HttpStatus.OK);
		else {
			List<JSONObject> listaCodici = new ArrayList<JSONObject>();
			List<Integer> listaId = hardwareService.getListaIdHardware();

			for (Integer id : listaId) {
				JSONObject oggetto = new JSONObject();
				UUID codice = UUID.randomUUID();
				oggetto.put("id", id);
				oggetto.put("codice", codice.toString().replaceAll("-", ""));
				System.err.println(id);
				System.err.println(codice.toString().replaceAll("-", ""));
				listaCodici.add(oggetto);
				// controllo sul se esce uguale
			}
			listaCodiciHardware = listaCodici;
			return new ResponseEntity<>(HttpStatus.OK);
		}

	}

	public static List<JSONObject> getListaCodiciHardware() {
		return listaCodiciHardware;
	}

	public boolean controlloToken(String token) {
		LocalDateTime dataSessione = sessionService.getData(token);
		if (dataSessione == null)
			return false;
		else {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			LocalDateTime data = LocalDateTime.parse(format.format(now), format);
			long diffInSeconds = ChronoUnit.SECONDS.between(dataSessione, data);
			if (diffInSeconds > 1800)
				return false;
			else {
				sessionService.updateData(data, token);
				return true;
			}
		}
	}
}