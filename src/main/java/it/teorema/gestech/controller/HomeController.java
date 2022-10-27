package it.teorema.gestech.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import it.teorema.gestech.model.Avvisi;
import it.teorema.gestech.service.AuthService;
import it.teorema.gestech.service.AvvisiService;
import it.teorema.gestech.service.SessionService;

@Controller
public class HomeController {
	@Autowired
	AvvisiService avvisiService;
	@Autowired
	AuthService authService;
	@Autowired
	SessionService sessionService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/get-avvisi/{ruolo}")
	public ResponseEntity<List<Avvisi>> getAvvisi(@PathVariable("ruolo") String ruolo,HttpServletRequest request) throws ParseException {		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		String token= (String) request.getAttribute("token");
		LocalDateTime now = LocalDateTime.now();
		
		String datadb =sdf.format(sessionService.getDateByToken(token));
		String datanow = sdf.format(now);
   
        long elapsedms = sdf.parse(datanow).getTime() - sdf.parse(datadb).getTime();
        long diff = TimeUnit.SECONDS.convert(elapsedms, TimeUnit.MILLISECONDS);
        System.out.println(diff);
        
        if(diff >= 1800)
        	return new ResponseEntity<>(null, HttpStatus.OK);
		 
		
		if(ruolo.equals("Admin"))
			return new ResponseEntity<>(avvisiService.findAll(), HttpStatus.OK);
		else 
			return new ResponseEntity<>(avvisiService.getAvvisiByRuolo(ruolo), HttpStatus.OK);
	}
	
	@RequestMapping("/delete-avviso/{idAvviso}")
	public ResponseEntity<?> deleteAvviso(@PathVariable("idAvviso") int idAvviso) {
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
		avviso.setIdPersona(Integer.parseInt((String) addForm.get("idDipendente")));
		avviso.setNote((String) addForm.get("note"));
		avvisiService.save(avviso);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping("/modifica-password")
	public ResponseEntity<?> modificaPassword(@RequestBody JSONObject formModificaPassword) {
		authService.changePassword((String)formModificaPassword.get("password"), Integer.parseInt((String)formModificaPassword.get("idDipendente")));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	 
}