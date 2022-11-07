package it.teorema.gestech.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import it.teorema.gestech.model.Hardware;
import it.teorema.gestech.model.mapper.AllHardware;
import it.teorema.gestech.service.DispositiviService;
import it.teorema.gestech.service.HardwareService;
import it.teorema.gestech.service.PersoneService;
import it.teorema.gestech.utils.ResponseHttp;

@Controller
public class HardwareController {
	@Autowired
	HardwareService hardwareService;
	@Autowired
	PersoneService personeService;
	@Autowired
	DispositiviService dispositiviService;
	@Autowired
	SecurityController securityController;

	@RequestMapping("/all-hardware")
	public ResponseEntity<ResponseHttp> allHardware(HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			responseHttp.setDataSource(hardwareService.allHardware());
			responseHttp.setCode("1");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
	}

	@RequestMapping("/salva-hardware")
	public ResponseEntity<ResponseHttp> salvaHardware(@RequestBody JSONObject formHardware,HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
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
			
			responseHttp.setCode("1");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
	}

	@RequestMapping("/get-hardware-visualizza/{idHardware}")
	public ResponseEntity<ResponseHttp> getHardwareVisualizza(@PathVariable("idHardware") int idHardware, HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			List<Object> lista = new ArrayList<>();

			AllHardware allHardware = hardwareService.getMapperHardware(idHardware);
			lista.add(allHardware);
			lista.add(hardwareService.findStoricoHardware(allHardware.getSeriale()));

			responseHttp.setDataSource(lista);
			responseHttp.setCode("1");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
	}

	@RequestMapping("/get-all-dispositivi")
	public ResponseEntity<ResponseHttp> getAllDispositivi(HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			responseHttp.setDataSource(dispositiviService.getDispositivi());
			responseHttp.setCode("1");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
	}

	@RequestMapping("/get-hardware-modifica/{idHardware}")
	public ResponseEntity<ResponseHttp> getHardwareModifica(@PathVariable("idHardware") int idHardware, HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
			List<Object> lista = new ArrayList<>();

			Hardware hardware = hardwareService.getHardware(idHardware);
			lista.add(hardware);
			lista.add(personeService.getDipendente(hardware.getIdPersona()));
			lista.add(dispositiviService.getDispositivo(hardware.getIdDispositivo()));
			lista.add(personeService.getAllDipendenti());
			lista.add(hardwareService.findStoricoHardware(hardware.getSeriale()));
			
			responseHttp.setDataSource(lista);
			responseHttp.setCode("1");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
	}

	@RequestMapping("/modifica-hardware/{idHardware}")
	public ResponseEntity<ResponseHttp> modificaHardware(@RequestBody Hardware updateForm,
			@PathVariable("idHardware") int idHardware, HttpServletRequest request) {
		ResponseHttp responseHttp = new ResponseHttp();
		if (securityController.controlloToken(request.getHeader("App-Key")) == false) {
			responseHttp.setCodeSession("0");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
		else {
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
			responseHttp.setCode("1");
			return new ResponseEntity<>(responseHttp, HttpStatus.OK);
		}
	}
}