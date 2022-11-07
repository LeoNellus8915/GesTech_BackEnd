package it.teorema.gestech.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.UUID;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import it.teorema.gestech.model.Persone;
import it.teorema.gestech.model.Session;
import it.teorema.gestech.service.AuthService;
import it.teorema.gestech.service.ContrattiService;
import it.teorema.gestech.service.RichiestePersoneService;
import it.teorema.gestech.service.PersoneService;
import it.teorema.gestech.service.RuoliPersoneService;
import it.teorema.gestech.service.SessionService;
import it.teorema.gestech.session.LocalSession;

@Controller
public class LoginController {
	@Autowired
	PersoneService personeService;
	@Autowired
	AuthService authService;
	@Autowired
	RuoliPersoneService ruoliDipendentiService;
	@Autowired
	RichiestePersoneService dipendentiRichiesteService;
	@Autowired
	ContrattiService contrattiService;
	@Autowired
	SessionService sessionService;
	@Autowired
	SecurityController securityController;

	@RequestMapping("/login")
	public ResponseEntity<?> login(@RequestBody JSONObject formLogin) {

			Integer idDipendente = authService.login((String) formLogin.get("email"),
					(String) formLogin.get("password"));
			System.err.println(idDipendente);

			if (idDipendente == null)
				return new ResponseEntity<>(null, HttpStatus.OK);
			else {
				LocalSession localSession = new LocalSession();
				localSession.setIdDipendente(idDipendente);
				Persone persona = personeService.findByIdPersona(idDipendente);
				localSession.setNome(persona.getNome());
				localSession.setCognome(persona.getCognome());
				localSession.setNumeroRichieste(dipendentiRichiesteService.getNumeroRichieste(idDipendente));
				localSession.setRuolo(ruoliDipendentiService.getRuoloByIdPersona(idDipendente));
				localSession.setAzienda(contrattiService.getAziendaByIdPersona(idDipendente));

				sessionService.deleteTokensById(idDipendente);

				DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				LocalDateTime data = LocalDateTime.parse(format.format(LocalDateTime.now()), format);

				sessionService.deleteAllOldToken(data);

				UUID primoCodice = UUID.randomUUID();
				UUID secondoCodice = UUID.randomUUID();

				String token = (primoCodice.toString().replaceAll("-", "") + ":" + data.getYear() + data.getMonthValue()
						+ data.getDayOfMonth() + data.getHour() + data.getMinute() + data.getSecond() + ":"
						+ secondoCodice.toString().replaceAll("-", "")).toString();

				String tokenCodificato = Base64.getEncoder().encodeToString(token.getBytes());

				Session session = new Session();
				session.setIdPersona(idDipendente);
				session.setToken(tokenCodificato);
				session.setData(data);
				sessionService.save(session);
				localSession.setToken(tokenCodificato);
				return new ResponseEntity<>(localSession, HttpStatus.OK);
			}

	}
}