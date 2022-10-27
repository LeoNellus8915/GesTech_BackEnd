package it.teorema.gestech.model.mapper;

import java.util.List;

public class MapperCandidato {

	MapperPersona_Candidato PersonaCandidato;
	MapperDettaglioCandidato_Candidato DettaglioCandidato_Candidato;
	List<GetProfili> ProfiloDettaglioCandidato;
	List<GetLingue> LingueDettaglioCandidato;
	
	public MapperCandidato() {}
	
	public MapperCandidato(MapperPersona_Candidato personaCandidato,
			MapperDettaglioCandidato_Candidato dettaglioCandidato_Candidato, List<GetProfili> profiloDettaglioCandidato,
			List<GetLingue> lingueDettaglioCandidato) {
		super();
		PersonaCandidato = personaCandidato;
		DettaglioCandidato_Candidato = dettaglioCandidato_Candidato;
		ProfiloDettaglioCandidato = profiloDettaglioCandidato;
		LingueDettaglioCandidato = lingueDettaglioCandidato;
	}
	public MapperPersona_Candidato getPersonaCandidato() {
		return PersonaCandidato;
	}
	public void setPersonaCandidato(MapperPersona_Candidato personaCandidato) {
		PersonaCandidato = personaCandidato;
	}
	public MapperDettaglioCandidato_Candidato getDettaglioCandidato_Candidato() {
		return DettaglioCandidato_Candidato;
	}
	public void setDettaglioCandidato_Candidato(MapperDettaglioCandidato_Candidato dettaglioCandidato_Candidato) {
		DettaglioCandidato_Candidato = dettaglioCandidato_Candidato;
	}
	public List<GetProfili> getProfiloDettaglioCandidato() {
		return ProfiloDettaglioCandidato;
	}
	public void setProfiloDettaglioCandidato(List<GetProfili> profiloDettaglioCandidato) {
		ProfiloDettaglioCandidato = profiloDettaglioCandidato;
	}
	public List<GetLingue> getLingueDettaglioCandidato() {
		return LingueDettaglioCandidato;
	}
	public void setLingueDettaglioCandidato(List<GetLingue> lingueDettaglioCandidato) {
		LingueDettaglioCandidato = lingueDettaglioCandidato;
	}
	
	
}
