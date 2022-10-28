package it.teorema.gestech.model.mapper;

import java.util.List;

public class MapperCandidato {

	private InfoPersona infoPersona;
	private InfoDettaglioCandidato infoDettaglioCandidato;
	private List<InfoProfili> infoProfili;
	private List<InfoLingue> infoLingue;
	private String cvBase64;
	private List<AllCommentiCandidato> commentiCandidato;
	
	public MapperCandidato() {}
	
	public MapperCandidato(InfoPersona infoPersona, InfoDettaglioCandidato infoDettaglioCandidato,
			List<InfoProfili> infoProfili, List<InfoLingue> infoLingue, String cvBase64,
			List<AllCommentiCandidato> commentiCandidato) {
		super();
		this.infoPersona = infoPersona;
		this.infoDettaglioCandidato = infoDettaglioCandidato;
		this.infoProfili = infoProfili;
		this.infoLingue = infoLingue;
		this.cvBase64 = cvBase64;
		this.commentiCandidato = commentiCandidato;
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

	public String getCvBase64() {
		return cvBase64;
	}

	public void setCvBase64(String cvBase64) {
		this.cvBase64 = cvBase64;
	}
	public List<AllCommentiCandidato> getAllCommentiCandidato() {
		return commentiCandidato;
	}
	public void setAllCommentiCandidato(List<AllCommentiCandidato> commentiCandidato) {
		this.commentiCandidato = commentiCandidato;
	}
	
}