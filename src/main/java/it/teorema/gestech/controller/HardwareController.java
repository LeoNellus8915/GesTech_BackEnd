package it.teorema.gestech.controller;

import java.time.LocalDate;
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
import it.teorema.gestech.model.mapper.AllHardware;
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
		lista.add(hardwareService.allHardware());
		lista.add(SecurityController.getListaCodiciHardware());
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/salva-hardware")
	public ResponseEntity<?> salvaHardware(@RequestBody JSONObject formHardware) {
		Hardware hardware = new Hardware();
		DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		hardware.setIdDispositivo(Integer.parseInt((String) formHardware.get("dispositivi")));
		hardware.setIdPersona(Integer.parseInt((String) formHardware.get("dipendente")));
		hardware.setMarca((String) formHardware.get("marca"));
		hardware.setModello((String) formHardware.get("modello"));
		hardware.setSeriale((String) formHardware.get("seriale"));
		hardware.setNote((String) formHardware.get("note"));
		hardware.setDataConsegna(LocalDate.parse((String) formHardware.get("dataConsegna"), format2));
		if (formHardware.get("dataRestituzione") != "") {
			hardware.setDataRestituzione(LocalDate.parse((String) formHardware.get("dataRestituzione"), format2));
		}

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
		
		System.err.println(codiceHardware);
		List<Object> lista = new ArrayList<>();
		int idHardware = 0;
		List<JSONObject> listaCodici = SecurityController.getListaCodiciHardware();
		for (JSONObject codice : listaCodici) {
			if (((String) codice.get(("codice"))).equals(codiceHardware)) {
				idHardware = (Integer) codice.get("id");
				
				System.err.println(idHardware);

				AllHardware allHardware = hardwareService.getMapperHardware(idHardware);
				lista.add(allHardware);
				lista.add(hardwareService.findStoricoHardware(allHardware.getSeriale()));
			}
		}

		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@RequestMapping("/get-all-dispositivi")
	public ResponseEntity<List<Dispositivi>> getAllDispositivi() {
		List<Dispositivi> listaDispositivi = dispositiviService.getDispositivi();
		return new ResponseEntity<>(listaDispositivi, HttpStatus.OK);

	}

	@RequestMapping("/get-hardware-modifica/{codiceHardware}")
	public ResponseEntity<List<Object>> getHardwareModifica(@PathVariable("codiceHardware") String codiceHardware) {
		List<Object> lista = new ArrayList<>();

		int idHardware = 0;
		List<JSONObject> listaCodici = SecurityController.getListaCodiciHardware();

		for (JSONObject codice : listaCodici)
			if (((String) codice.get(("codice"))).equals(codiceHardware)) {
				idHardware = (Integer) codice.get("id");
			}

		Hardware hardware = hardwareService.getHardware(idHardware);
		lista.add(hardware);
		lista.add(personeService.getDipendente(hardware.getIdPersona()));
		lista.add(dispositiviService.getDispositivo(hardware.getIdDispositivo()));
		lista.add(personeService.getAllDipendenti());
		lista.add(hardwareService.findStoricoHardware(hardware.getSeriale()));
		
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@RequestMapping("/modifica-hardware/{codiceHardware}")
	public ResponseEntity<?> modificaHardware(@RequestBody Hardware updateForm,
			@PathVariable("codiceHardware") String codiceHardware) {

		int idHardware = 0;
		List<JSONObject> listaCodici = SecurityController.getListaCodiciHardware();

		for (JSONObject codice : listaCodici) {
			if (((String) codice.get(("codice"))).equals(codiceHardware)) {
				idHardware = (Integer) codice.get("id");
			}
		}
		
		Hardware hw = new Hardware(updateForm.getIdPersona(), updateForm.getIdDispositivo(), updateForm.getMarca(), updateForm.getModello(), 
				updateForm.getSeriale(), updateForm.getDataConsegna(), updateForm.getDataRestituzione(), updateForm.getNote());
		
		
		if(hw.getDataRestituzione() != null) {
			hardwareService.save(hw);
			
			Hardware newHw = new Hardware(10, hw.getIdDispositivo(),
					hw.getMarca(),hw.getModello(),hw.getSeriale()
					,null,null,
					"");
			
			hardwareService.modificaHardware(idHardware, newHw);
		}
		else {
			hardwareService.modificaHardware(idHardware, hw);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}
}





























