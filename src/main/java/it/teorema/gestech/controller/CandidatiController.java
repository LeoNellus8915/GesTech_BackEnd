package it.teorema.gestech.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
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
import it.teorema.gestech.model.LingueDettagliCandidati;
import it.teorema.gestech.model.Persone;
import it.teorema.gestech.model.ProfiliDettagliCandidati;
import it.teorema.gestech.model.mapper.InfoPersona;
import it.teorema.gestech.model.mapper.MapperCandidato;
import it.teorema.gestech.service.CommentiCandidatiService;
import it.teorema.gestech.service.CvService;
import it.teorema.gestech.service.DettagliCandidatiService;
import it.teorema.gestech.service.PersoneService;
import it.teorema.gestech.service.ProfiliDettagliCandidatiService;
import it.teorema.gestech.service.EsitiColloquioService;
import it.teorema.gestech.service.LinguaggiService;
import it.teorema.gestech.service.LingueDettagliCandidatiService;
import it.teorema.gestech.service.LingueService;
import it.teorema.gestech.service.LivelliService;
import it.teorema.gestech.service.ProfiliService;
import it.teorema.gestech.utils.ResponseHttp;

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
	@Autowired
	ProfiliDettagliCandidatiService profiliDettagliCandidatiService;
	@Autowired
	SecurityController securityController;

	@RequestMapping("/all-candidati")
	public ResponseEntity<List<Object>> allCandidati(HttpServletRequest request) {
		/*if (securityController.controlloToken(request.getHeader("App-Key")) == false)
			return new ResponseEntity<>(null, HttpStatus.OK);
		else {*/
			List<Object> lista = new ArrayList<>();
			lista.add(dettagliCandidatiService.allCandidati());
			lista.add(SecurityController.getListaCodiciCandidati());
			return new ResponseEntity<>(lista, HttpStatus.OK);
		//}

	}

	@RequestMapping("/salva-candidato")
	public ResponseEntity<?> salvaCandidato(@RequestBody JSONObject formCandidato, HttpServletRequest request) {
		/*if (securityController.controlloToken(request.getHeader("App-Key")) == false)
			return new ResponseEntity<>(null, HttpStatus.OK);
		else {*/
			HashMap<String, Object> x = (HashMap) formCandidato.get("anagrafica");
			if (personeService.existsByEmail((String) formCandidato.get("email")) != null)
				return new ResponseEntity<>(0, HttpStatus.OK);
			else {

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

				// Profilo Candidato

				int idDettaglioCandidato = dettagliCandidatiService.getIdDettaglioCandidato(idCandidato);
				int c = 0;
				ProfiliDettagliCandidati pcd = new ProfiliDettagliCandidati(idDettaglioCandidato);
				List<ProfiliDettagliCandidati> listapdc = new ArrayList<ProfiliDettagliCandidati>();
				String[] arrayProfili = formCandidato.get("profilo").toString().replace("[{", "").replace("}]", "")
						.replace("}", "").replace(" {", " ").split(", ");
				if (arrayProfili.length > 1)
					for (String profilo : arrayProfili) {
						if (c == 0) {
							pcd.setIdProfilo(
									Integer.parseInt((String) profilo.substring(profilo.lastIndexOf("=") + 1)));
						}
						if (c == 1) {
							pcd.setIdLinguaggio(
									Integer.parseInt((String) profilo.substring(profilo.lastIndexOf("=") + 1)));
						}
						if (c == 2) {
							pcd.setIdLivello(
									Integer.parseInt((String) profilo.substring(profilo.lastIndexOf("=") + 1)));
						}
						if (c == 3) {
							pcd.setDescrizione(profilo.substring(profilo.lastIndexOf("=") + 1));
						}
						c++;
						if (c == 4) {
							listapdc.add(pcd);
							c = 0;
							pcd = new ProfiliDettagliCandidati(idDettaglioCandidato);
						}
					}
				profiliDettagliCandidatiService.saveAll(listapdc);

				// Lingue Candidato

				LingueDettagliCandidati ldc = new LingueDettagliCandidati(idDettaglioCandidato);
				List<LingueDettagliCandidati> listaldc = new ArrayList<LingueDettagliCandidati>();
				String[] arrayLingue = formCandidato.get("lingue").toString().replace("[{", "").replace("}]", "")
						.replace("}", "").replace(" {", " ").split(", ");
				if (arrayLingue.length > 1)
					for (String lingue : arrayLingue) {
						ldc.setIdLingua(Integer.parseInt((String) lingue.substring(lingue.lastIndexOf("=") + 1)));
						ldc.setDescrizione("");
						listaldc.add(ldc);
						ldc = new LingueDettagliCandidati(idDettaglioCandidato);
					}
				lingueDettagliCandidatiService.saveAll(listaldc);

				if ((String) formCandidato.get("cv") != null) {
					Cv cv = new Cv();
					cv.setCv(formCandidato, idCandidato);
					cvService.save(cv);
				}

				if ((String) formCandidato.get("commento") != "") {
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
		//}

	}

	@RequestMapping("/get-candidato-visualizza/{codiceCandidato}")
	public ResponseEntity<ResponseHttp> getCandidatoVisualizza(@PathVariable("codiceCandidato") String codiceCandidato,
			HttpServletRequest request) {
		/*if (securityController.controlloToken(request.getHeader("App-Key")) == false)
			return new ResponseEntity<>(null, HttpStatus.OK);
		else {*/
			ResponseHttp response = new ResponseHttp();
			response.setCode("1");
			int idCandidato = 0;
			List<JSONObject> listaCodici = SecurityController.getListaCodiciCandidati();

			for (JSONObject codice : listaCodici) {
				if (((String) codice.get(("codice"))).equals(codiceCandidato)) {
					idCandidato = (Integer) codice.get("id");
				}
			}

			MapperCandidato mc = new MapperCandidato();
			mc.setInfoPersona(personeService.getInfoPersona(idCandidato));
			mc.setInfoDettaglioCandidato(dettagliCandidatiService.getInfoDettaglioCandidato(idCandidato));
			mc.setInfoProfili(profiliDettagliCandidatiService.getInfoProfili(idCandidato));
			mc.setInfoLingue(lingueDettagliCandidatiService.getInfoLingue(idCandidato));
			mc.setCvBase64(cvService.getCv(idCandidato));
			mc.setAllCommentiCandidato(commentiCandidatiService.findByIdCandidato(idCandidato));
			if (mc.getInfoPersona() == null || mc.getInfoDettaglioCandidato() == null
					|| mc.getInfoProfili() == null || mc.getInfoLingue() == null) {
				response.setCode("0");
				response.setMessage("No");
			} else {
				response.setDataSource(mc);
				response.setMessage("Yes");
			}

			return new ResponseEntity<>(response, HttpStatus.OK);
		//}

	}

	@RequestMapping("/get-candidato-modifica/{codiceCandidato}")
	public ResponseEntity<ResponseHttp> getCandidatoModifica(@PathVariable("codiceCandidato") String codiceCandidato,
			HttpServletRequest request) {
		/*if (securityController.controlloToken(request.getHeader("App-Key")) == false)
			return new ResponseEntity<>(null, HttpStatus.OK);
		else {*/
		ResponseHttp response = new ResponseHttp();
		response.setCode("1");
		int idCandidato = 0;
		List<JSONObject> listaCodici = SecurityController.getListaCodiciCandidati();

		for (JSONObject codice : listaCodici) {
			if (((String) codice.get(("codice"))).equals(codiceCandidato)) {
				idCandidato = (Integer) codice.get("id");
			}
		}

		MapperCandidato mc = new MapperCandidato();
		mc.setInfoPersona(personeService.getInfoPersona(idCandidato));
		mc.setInfoDettaglioCandidato(dettagliCandidatiService.getInfoDettaglioCandidato(idCandidato));
		mc.setInfoProfili(profiliDettagliCandidatiService.getInfoProfili(idCandidato));
		mc.setInfoLingue(lingueDettagliCandidatiService.getInfoLingue(idCandidato));
		mc.setCvBase64(cvService.getCv(idCandidato));
		if (mc.getInfoPersona() == null || mc.getInfoDettaglioCandidato() == null
				|| mc.getInfoProfili() == null || mc.getInfoLingue() == null) {
			response.setCode("0");
			response.setMessage("No");
		} else {
			response.setDataSource(mc);
			response.setMessage("Yes");
		}

		return new ResponseEntity<>(response, HttpStatus.OK);
		//}

	}

	@RequestMapping("/elimina-candidato/{codiceCandidato}")
	public ResponseEntity<?> eliminaCandidato(@PathVariable("codiceCandidato") String codiceCandidato,
			HttpServletRequest request) {
		if (securityController.controlloToken(request.getHeader("App-Key")) == false)
			return new ResponseEntity<>(null, HttpStatus.OK);
		else {
			int idCandidato = 0;
			JSONObject appoggio = null;
			List<JSONObject> listaCodici = SecurityController.getListaCodiciCandidati();
			for (JSONObject codice : listaCodici) {
				if (((String) codice.get(("codice"))).equals(codiceCandidato)) {
					idCandidato = (Integer) codice.get("id");
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

	}

	@RequestMapping("/controllo-email-modifica")
	public ResponseEntity<Integer> controlloEmailModifica(@RequestBody String email, HttpServletRequest request) {
		/*if (securityController.controlloToken(request.getHeader("App-Key")) == false)
			return new ResponseEntity<>(null, HttpStatus.OK);
		else {*/
			if (personeService.existsByEmail(email) != null)
				return new ResponseEntity<>(0, HttpStatus.OK);
			else
				return new ResponseEntity<>(1, HttpStatus.OK);
		//}
	}

	@RequestMapping("/modifica-candidato/{codiceCandidato}/{idDipendente}")
	public ResponseEntity<?> modificaCandidato(@PathVariable("codiceCandidato") String codiceCandidato,
			@PathVariable("idDipendente") int idDipendente, @RequestBody JSONObject updateForm,
			HttpServletRequest request) {
		/*if (securityController.controlloToken(request.getHeader("App-Key")) == false)
			return new ResponseEntity<>(null, HttpStatus.OK);
		else {*/
			int idPersona = 0;
			List<JSONObject> listaCodici = SecurityController.getListaCodiciCandidati();
			for (JSONObject codice : listaCodici)
				if (((String) codice.get(("codice"))).equals(codiceCandidato))
					idPersona = (Integer) codice.get("id");
			
			InfoPersona infoPersona = new InfoPersona((String) updateForm.get("nome"), (String) updateForm.get("cognome"),
					(String) updateForm.get("email"), (String) updateForm.get("cellulare"), (String) updateForm.get("citta"));
			
			personeService.updateInfoPersona(idPersona, infoPersona);
			
			/*personeService.updatePersona(idPersona, (String) updateForm.get("nome"), (String) updateForm.get("cognome"),
					(String) updateForm.get("cellulare"), (String) updateForm.get("email"),
					(String) updateForm.get("citta"));

			dettagliCandidatiService.updateCandidato(idPersona,
					Integer.parseInt((String) updateForm.get("esitoColloquio")),
					LocalDate.parse((String) updateForm.get("dataColloquio")),
					(Integer) updateForm.get("annoColloquio"), (String) updateForm.get("fonteReperimento"),
					(String) updateForm.get("competenzaPrincipale"),
					Double.parseDouble((String) updateForm.get("costoGiornaliero")),
					(String) updateForm.get("possibilitaLavorativa"), (String) updateForm.get("competenzeTotali"),
					(String) updateForm.get("certificazioni"), (String) updateForm.get("profiloLinkedin"));

			if ((String) updateForm.get("commento") != "") {
				CommentiCandidati commentiCandidato = new CommentiCandidati();
				DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDateTime now = LocalDateTime.now();
				commentiCandidato.setData(LocalDate.parse(format.format(now), format));
				commentiCandidato.setIdPersona(idDipendente);
				commentiCandidato.setIdDettaglioCandidato(idPersona);
				commentiCandidato.setNote((String) updateForm.get("commento"));
				commentiCandidatiService.save(commentiCandidato);
			}*/
			return new ResponseEntity<>(HttpStatus.OK);
		//}
	}

}