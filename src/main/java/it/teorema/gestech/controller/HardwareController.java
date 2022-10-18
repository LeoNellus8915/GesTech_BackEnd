package it.teorema.gestech.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import it.teorema.gestech.model.Dispositivi;
import it.teorema.gestech.model.Hardware;
import it.teorema.gestech.service.DispositiviService;
import it.teorema.gestech.service.HardwareService;
import it.teorema.gestech.service.PersoneService;

@Controller
public class HardwareController {
	@Autowired
	HardwareService hardwareService;
	@Autowired
	PersoneService personeService;
	@Autowired
	DispositiviService dispositiviService;

	@RequestMapping("/all-hardware")
	public ResponseEntity<List<Object>> allHardware() {
		List<Object> lista = new ArrayList<>();
		lista.add(hardwareService.findHardware());
		lista.add(SecurityController.getListaCodiciHardware());
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	

	@SuppressWarnings("unchecked")
	@RequestMapping("/salva-hardware")
	public ResponseEntity<?> salvaHardware(@RequestBody JSONObject formHardware) {
	    Hardware hardware = new Hardware();  
		DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");  

		
		
	    hardware.setIdDispositivo(Integer.parseInt((String)formHardware.get("dispositivi")));
	    hardware.setIdPersona(Integer.parseInt((String)formHardware.get("dipendente")));
	    hardware.setMarca((String)formHardware.get("marca"));
	    hardware.setModello((String)formHardware.get("modello"));
	    hardware.setSeriale((String)formHardware.get("seriale"));
	    hardware.setNote((String)formHardware.get("note"));
	    hardware.setDataConsegna(LocalDate.parse((String)formHardware.get("dataConsegna"), format2));
	    hardware.setDataRestituzione(LocalDate.parse((String)formHardware.get("dataRestituzione"), format2));
	    
		System.err.println(hardware.getId() + " id dispositivo:" + hardware.getIdDispositivo() + " id persona:" + hardware.getIdPersona());
		hardwareService.save(hardware);
		List<JSONObject> listaCodici = SecurityController.getListaCodiciHardware();
		JSONObject oggetto = new JSONObject();
		UUID codice = UUID.randomUUID();
		oggetto.put("id", hardwareService.getLastHardwareId());
		oggetto.put("codice", codice.toString().replaceAll("-", ""));
		listaCodici.add(oggetto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping("/get-hardware-visualizza/{codiceHardware}")
	public ResponseEntity<List<Object>> getHardwareVisualizza(@PathVariable("codiceHardware") String codiceHardware) {
		List<Object> lista = new ArrayList<>();
		int idHardware = 0;
		List<JSONObject> listaCodici = SecurityController.getListaCodiciHardware();

		for (JSONObject codice : listaCodici)
			if (((String) codice.get(("codice"))).equals(codiceHardware))
				idHardware = (Integer) codice.get("id");

		lista.add(hardwareService.getHardware(idHardware));
		lista.add(hardwareService.findStoricoHardware());

		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@RequestMapping("/get-all-dispositivi")
	public ResponseEntity<List<Dispositivi>> getAllDispositivi(){
		List<Dispositivi> listaDispositivi = dispositiviService.getDispositivi();
		return new ResponseEntity<>(listaDispositivi,HttpStatus.OK);
		
	}

	@RequestMapping("/get-hardware-modifica/{codiceHardware}")
	public ResponseEntity<List<Object>> getHardwareModifica(@PathVariable("codiceHardware") String codiceHardware) {
		List<Object> lista = new ArrayList<>();

		int idHardware = 0;
		List<JSONObject> listaCodici = SecurityController.getListaCodiciHardware();

		for (JSONObject codice : listaCodici)
			if (((String) codice.get(("codice"))).equals(codiceHardware))
				idHardware = (Integer) codice.get("id");

		Hardware hardware = hardwareService.getHardware(idHardware);
		lista.add(hardware);
		lista.add(personeService.findAllDipendentiException(hardware.getIdPersona()));
		lista.add(hardwareService.findStoricoHardware());

		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@RequestMapping("/modifica-hardware/{codiceHardware}")
	public ResponseEntity<?> modificaHardware(@RequestBody Hardware hardware,
			@PathVariable("codiceHardware") String codiceHardware) {
		int idHardware = 0;
		List<JSONObject> listaCodici = SecurityController.getListaCodiciHardware();

		for (JSONObject codice : listaCodici)
			if (((String) codice.get(("codice"))).equals(codiceHardware))
				idHardware = (Integer) codice.get("id");

		if (hardware.getDataRestituzione() != null) {
			hardwareService.modificaHardwareRestituito(idHardware, hardware.getIdDispositivo(), hardware.getMarca(),
					hardware.getModello(), hardware.getSeriale(), hardware.getModello(), hardware.getNote());

			Hardware copia = new Hardware(hardware.getIdPersona(), hardware.getIdDispositivo(), hardware.getIdPersona(), hardware.getModello(),
					hardware.getSeriale(), hardware.getMarca(), hardware.getDataConsegna(),
					hardware.getDataRestituzione(), hardware.getNote());

			hardwareService.save(copia);
		} else {
			hardwareService.modificaHardware(idHardware, hardware.getIdDispositivo(), hardware.getMarca(), hardware.getModello(),
					hardware.getSeriale(), hardware.getIdPersona(), hardware.getDataConsegna(),
					hardware.getNote());
		}

		/*
		 * beniService.modificaBene(idBene, bene.getDispositivo(), bene.getMarca(),
		 * bene.getModello(), bene.getNumeroSeriale(), bene.getPassword(),
		 * bene.getDipendente(), bene.getSocieta(), bene.getDataConsegna(),
		 * bene.getDataRestituzione(), bene.getNote());
		 */

		return new ResponseEntity<>(HttpStatus.OK);
	}
}