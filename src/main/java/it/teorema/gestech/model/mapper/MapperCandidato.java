package it.teorema.gestech.model.mapper;

import java.util.List;

public class MapperCandidato {

	InfoPersona PersonaCandidato;
	InfoDettaglioCandidato DettaglioCandidato_Candidato;
	List<InfoProfili> ProfiloDettaglioCandidato;
	List<InfoLingue> LingueDettaglioCandidato;
	
	public MapperCandidato() {}
	
	public MapperCandidato(InfoPersona personaCandidato,
			InfoDettaglioCandidato dettaglioCandidato_Candidato, List<InfoProfili> profiloDettaglioCandidato,
			List<InfoLingue> lingueDettaglioCandidato) {
		super();
		PersonaCandidato = personaCandidato;
		DettaglioCandidato_Candidato = dettaglioCandidato_Candidato;
		ProfiloDettaglioCandidato = profiloDettaglioCandidato;
		LingueDettaglioCandidato = lingueDettaglioCandidato;
	}
	public InfoPersona getPersonaCandidato() {
		return PersonaCandidato;
	}
	public void setPersonaCandidato(InfoPersona personaCandidato) {
		PersonaCandidato = personaCandidato;
	}
	public InfoDettaglioCandidato getDettaglioCandidato_Candidato() {
		return DettaglioCandidato_Candidato;
	}
	public void setDettaglioCandidato_Candidato(InfoDettaglioCandidato dettaglioCandidato_Candidato) {
		DettaglioCandidato_Candidato = dettaglioCandidato_Candidato;
	}
	public List<InfoProfili> getProfiloDettaglioCandidato() {
		return ProfiloDettaglioCandidato;
	}
	public void setProfiloDettaglioCandidato(List<InfoProfili> profiloDettaglioCandidato) {
		ProfiloDettaglioCandidato = profiloDettaglioCandidato;
	}
	public List<InfoLingue> getLingueDettaglioCandidato() {
		return LingueDettaglioCandidato;
	}
	public void setLingueDettaglioCandidato(List<InfoLingue> lingueDettaglioCandidato) {
		LingueDettaglioCandidato = lingueDettaglioCandidato;
	}
	
	
}
