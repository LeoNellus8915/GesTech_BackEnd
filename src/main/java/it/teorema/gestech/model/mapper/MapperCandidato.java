package it.teorema.gestech.model.mapper;

import java.util.List;

public class MapperCandidato {

	InfoPersona infoPersona;
	InfoDettaglioCandidato infoDettaglioCandidato;
	List<InfoProfili> infoProfili;
	List<InfoLingue> infoLingue;
	
	public MapperCandidato() {}

	public MapperCandidato(InfoPersona infoPersona, InfoDettaglioCandidato infoDettaglioCandidato,
			List<InfoProfili> infoProfili, List<InfoLingue> infoLingue) {
		super();
		this.infoPersona = infoPersona;
		this.infoDettaglioCandidato = infoDettaglioCandidato;
		this.infoProfili = infoProfili;
		this.infoLingue = infoLingue;
	}

	public InfoPersona getInfoPersona() {
		return infoPersona;
	}

	public void setInfoPersona(InfoPersona infoPersona) {
		this.infoPersona = infoPersona;
	}

	public InfoDettaglioCandidato getInfoDettaglioCandidato() {
		return infoDettaglioCandidato;
	}

	public void setInfoDettaglioCandidato(InfoDettaglioCandidato infoDettaglioCandidato) {
		this.infoDettaglioCandidato = infoDettaglioCandidato;
	}

	public List<InfoProfili> getInfoProfili() {
		return infoProfili;
	}

	public void setInfoProfili(List<InfoProfili> infoProfili) {
		this.infoProfili = infoProfili;
	}

	public List<InfoLingue> getInfoLingue() {
		return infoLingue;
	}

	public void setInfoLingue(List<InfoLingue> infoLingue) {
		this.infoLingue = infoLingue;
	}
	
}