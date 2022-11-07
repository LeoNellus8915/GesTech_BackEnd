package it.teorema.gestech.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import it.teorema.gestech.model.Avvisi;
import it.teorema.gestech.service.AuthService;
import it.teorema.gestech.service.AvvisiService;
import it.teorema.gestech.utils.ResponseHttp;

@Controller
public class HomeController {
	@Autowired
	AvvisiService avvisiService;
	@Autowired
	AuthService authService;
	
	@Autowired
	SecurityController securityController;
	
	@RequestMapping("/get-avvisi/{ruolo}")
	public ResponseEntity<ResponseHttp> getAvvisi(@PathVariable("ruolo") String ruolo, HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			responseHttp.setCode("1");
			if (ruolo.equals("Admin")) {
				responseHttp.setDataSource(avvisiService.findAll());
				return new ResponseEntity<>(responseHttp, HttpStatus.OK);
			}
			else {
				responseHttp.setDataSource(avvisiService.getAvvisiByRuolo(ruolo));
				return new ResponseEntity<>(responseHttp, HttpStatus.OK);
			}
		}
	}
	
	@RequestMapping("/delete-avviso/{idAvviso}")
	public ResponseEntity<ResponseHttp> deleteAvviso(@PathVariable("idAvviso") int idAvviso, HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			avvisiService.deleteById(idAvviso);
			responseHttp.setCode("1");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		
	}
	
	@RequestMapping("/salva-avviso")
	public ResponseEntity<ResponseHttp> salvaAvviso(@RequestBody JSONObject addForm, HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();
			Avvisi avviso = new Avvisi();
			avviso.setTitolo((String) addForm.get("titolo"));
			avviso.setRuoli((String) addForm.get("ruoli").toString().replace(",", "").replace("[", "").replace("]", ""));
			avviso.setData(LocalDateTime.parse(dtf.format(now), dtf));
			avviso.setIdPersona(Integer.parseInt((String) addForm.get("idDipendente")));
			avviso.setNote((String) addForm.get("note"));
			avvisiService.save(avviso);
			responseHttp.setCode("1");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}

	}
	
	@RequestMapping("/modifica-password")
	public ResponseEntity<ResponseHttp> modificaPassword(@RequestBody JSONObject formModificaPassword,HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			authService.changePassword((String)formModificaPassword.get("password"), Integer.parseInt((String)formModificaPassword.get("idDipendente")));
			responseHttp.setCode("1");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
	}
}