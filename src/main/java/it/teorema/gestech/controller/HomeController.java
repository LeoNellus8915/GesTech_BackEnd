package it.teorema.gestech.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

@Controller
public class HomeController {
	@Autowired
	AvvisiService avvisiService;
	@Autowired
	AuthService authService;
	
	@RequestMapping("/get-avvisi/{ruolo}")
	public ResponseEntity<List<Avvisi>> getAvvisi(@PathVariable("ruolo") String ruolo) {
		if(ruolo.equals("Admin"))
			return new ResponseEntity<>(avvisiService.findAll(), HttpStatus.OK);
		else 
			return new ResponseEntity<>(avvisiService.getAvvisiByRuolo(ruolo), HttpStatus.OK);
	}
	
	@RequestMapping("/delete-avviso/{idAvviso}")
	public ResponseEntity<?> deleteRisorsa(@PathVariable("idAvviso") int idAvviso) {
		avvisiService.deleteById(idAvviso);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping("/salva-avviso")
	public ResponseEntity<?> salvaAvviso(@RequestBody JSONObject addForm) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		Avvisi avviso = new Avvisi();
		avviso.setTitolo((String) addForm.get("titolo"));
		avviso.setRuoli((String) addForm.get("ruoli").toString().replace(",", "").replace("[", "").replace("]", ""));
		avviso.setData(LocalDateTime.parse(dtf.format(now), dtf));
		avviso.setIdRisorsa(Integer.parseInt((String) addForm.get("idRisorsa")));
		avviso.setNote((String) addForm.get("note"));
		avvisiService.save(avviso);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping("/modifica-password")
	public ResponseEntity<?> modificaPassword(@RequestBody JSONObject formModificaPassword) {
		authService.changePassword((String)formModificaPassword.get("password"), Integer.parseInt((String)formModificaPassword.get("idRisorsa")));
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
