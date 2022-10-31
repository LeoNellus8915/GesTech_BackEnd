package it.teorema.gestech.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import it.teorema.gestech.model.mapper.AllCandidati;
import it.teorema.gestech.service.SessionService;

@Controller
public class SecurityController {
	@Autowired
	SessionService sessionService;
	
	public static List<HashMap<String, Object>> getListaCodiciCandidati(List<AllCandidati> allCandidati) {
		List<HashMap<String, Object>> listaHash = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> hash = null;
		for (AllCandidati candidato  : allCandidati) {
			hash = new HashMap<String, Object>();
			hash.put("id", candidato.getId());
			UUID codice = UUID.randomUUID();
			hash.put("codice", codice.toString().replaceAll("-", ""));
			hash.put("nome", candidato.getNome());
			hash.put("cognome", candidato.getCognome());
			hash.put("citta", candidato.getCitta());
			hash.put("competenzaPrincipale", candidato.getCompetenzaPrincipale());
			hash.put("dataInserimento", candidato.getDataInserimento());
			hash.put("esitoNome", candidato.getEsitoNome());
			listaHash.add(hash);
		}
		return listaHash;
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