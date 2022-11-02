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
import it.teorema.gestech.model.mapper.InfoLingue;
import it.teorema.gestech.model.mapper.InfoPersona;
import it.teorema.gestech.model.mapper.InfoProfili;
import it.teorema.gestech.model.mapper.MapperCandidato;
import it.teorema.gestech.model.mapper.MapperModificaCandidato;
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
	public ResponseEntity<ResponseHttp> allCandidati(HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			responseHttp.setCode("1");
			responseHttp.setDataSource(SecurityController.getListaCodiciCandidati(dettagliCandidatiService.allCandidati()));
			return new ResponseEntity<> (responseHttp, HttpStatus.OK);
		}

	}

	@RequestMapping("/salva-candidato")
	public ResponseEntity<?> salvaCandidato(@RequestBody JSONObject formCandidato, HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			responseHttp.setCode("1");
			//HashMap<String, Object> x = (HashMap) formCandidato.get("anagrafica");
			if (personeService.existsByEmail((String) formCandidato.get("email")) != null) {
				responseHttp.setDataSource(0);
				return new ResponseEntity<>(responseHttp, HttpStatus.OK);
			}
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
				return new ResponseEntity<>(responseHttp, HttpStatus.OK);
			}
		}
	}

	@RequestMapping("/get-candidato-visualizza/{idCandidato}")
	public ResponseEntity<ResponseHttp> getCandidatoVisualizza(@PathVariable("idCandidato") int idCandidato,
			HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			ResponseHttp response = new ResponseHttp();
			response.setCode("1");

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
		}
	}

	@RequestMapping("/get-candidato-modifica/{idCandidato}")
	public ResponseEntity<ResponseHttp> getCandidatoModifica(@PathVariable("idCandidato") int idCandidato,
			HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			responseHttp.setCode("1");
	
			MapperCandidato mc = new MapperCandidato();
			mc.setInfoPersona(personeService.getInfoPersona(idCandidato));
			mc.setInfoDettaglioCandidato(dettagliCandidatiService.getInfoDettaglioCandidato(idCandidato));
			mc.setInfoProfili(profiliDettagliCandidatiService.getInfoProfili(idCandidato));
			mc.setInfoLingue(lingueDettagliCandidatiService.getInfoLingue(idCandidato));
			mc.setCvBase64(cvService.getCv(idCandidato));
			if (mc.getInfoPersona() == null || mc.getInfoDettaglioCandidato() == null
					|| mc.getInfoProfili() == null || mc.getInfoLingue() == null) {
				responseHttp.setCode("0");
				responseHttp.setMessage("No");
			} else {
				responseHttp.setDataSource(mc);
				responseHttp.setMessage("Yes");
			}
	
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
	}

	@RequestMapping("/elimina-candidato/{idCandidato}")
	public ResponseEntity<ResponseHttp> eliminaCandidato(@PathVariable("idCandidato") int idCandidato,
			HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			personeService.deleteById(idCandidato);
			dettagliCandidatiService.deleteByIdCandidato(idCandidato);
			commentiCandidatiService.deleteByIdCandidato(idCandidato);
			cvService.deleteByIdCandidato(idCandidato);
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
	}

	@RequestMapping("/controllo-email-modifica")
	public ResponseEntity<ResponseHttp> controlloEmailModifica(@RequestBody String email, HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			responseHttp.setCode("1");
			if (personeService.existsByEmail(email) != null) {
				responseHttp.setDataSource(1);
				return new ResponseEntity<>(responseHttp, HttpStatus.OK);
			}
			else {
				responseHttp.setDataSource(0);
				return new ResponseEntity<>(responseHttp, HttpStatus.OK);
			}
		}
	}

	@RequestMapping("/modifica-candidato/{idCandidato}/{idDipendente}")
	// idCandidato -> idPersona del profilo modificato
	// idDipendente -> idPersona di chi effettua la modifica
	public ResponseEntity<?> modificaCandidato(@PathVariable("idCandidato") int idCandidato,
			@PathVariable("idDipendente") int idDipendente, @RequestBody JSONObject updateForm,
			HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {		
			Persone p = new Persone();
			p.setAnagrafica(updateForm);
			personeService.updateInfoPersona(p, idCandidato);
			
			DettagliCandidati dc = new DettagliCandidati();
			dc.setDettagliCandidato(updateForm, idCandidato);
			dettagliCandidatiService.updateInfoDettaglioCandidato(dc, idCandidato);
			
			int idDettaglioCandidato = dettagliCandidatiService.getIdDettaglioCandidato(idCandidato);
			profiliDettagliCandidatiService.deleteByIdDettaglioCandidato(idDettaglioCandidato);
			lingueDettagliCandidatiService.deleteByIdDettaglioCandidato(idDettaglioCandidato);
			
			int c = 0;
			ProfiliDettagliCandidati pcd = new ProfiliDettagliCandidati(idDettaglioCandidato);
			List<ProfiliDettagliCandidati> listapdc = new ArrayList<ProfiliDettagliCandidati>();
			String[] arrayProfili = updateForm.get("listaProfili").toString().replace("[{", "").replace("}]", "")
					.replace("}", "").replace(" {", " ").split(", ");
			if (arrayProfili.length > 1) {
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
						System.out.println(pcd.getIdLivello());
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
			}
			profiliDettagliCandidatiService.saveAll(listapdc);
			
			LingueDettagliCandidati ldc = new LingueDettagliCandidati(idDettaglioCandidato);
			List<LingueDettagliCandidati> listaldc = new ArrayList<LingueDettagliCandidati>();
			String[] arrayLingue = updateForm.get("listaLingue").toString().replace("[{", "").replace("}]", "")
					.replace("}", "").replace(" {", " ").split(", ");
			if (arrayLingue.length > 1) {
				for (String lingue : arrayLingue) {
					ldc.setIdLingua(Integer.parseInt((String) lingue.substring(lingue.lastIndexOf("=") + 1)));
					ldc.setDescrizione("");
					listaldc.add(ldc);
					ldc = new LingueDettagliCandidati(idDettaglioCandidato);
				}
			}
			lingueDettagliCandidatiService.saveAll(listaldc);
			
			if ((String) updateForm.get("cv") != null) {
				Cv cv = new Cv();
				cv.setCv(updateForm, idCandidato);
				cvService.save(cv);
			}

			if ((String) updateForm.get("commento") != "") {
				CommentiCandidati commentiCandidato = new CommentiCandidati();
				commentiCandidato.setCommentiCandidati(updateForm, idCandidato);
				commentiCandidatiService.save(commentiCandidato);
			}
			
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}