package it.teorema.gestech.model.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.json.simple.JSONObject;

public class MapperModificaCandidato {
	
	private String nome;
    private String cognome;
    private String email;
    private String cellulare;
    private String cittaDiResidenza;
    
    private int idPersona;
    private String profiloLinkedin;
    private int idEsitoColloquio;
	private String esitoColloquio;
	private int coloreEsitoColloquio;
	private LocalDateTime dataInserimento;
	private String competenzaPrincipale;
	private LocalDate dataColloquio;
	private Integer annoColloquio;
	private String fonteReperimento;
	private Double costoGiornaliero;
	private String possibilitaLavorativa;
	private String competenzeTotali;
	private String certificazioni;
	
	public MapperModificaCandidato() {}
	
	public MapperModificaCandidato(String nome, String cognome, String email, String cellulare, String cittaDiResidenza,
			int idPersona, String profiloLinkedin, int idEsitoColloquio, String esitoColloquio,
			int coloreEsitoColloquio, LocalDateTime dataInserimento, String competenzaPrincipale,
			LocalDate dataColloquio, Integer annoColloquio, String fonteReperimento, Double costoGiornaliero,
			String possibilitaLavorativa, String competenzeTotali, String certificazioni) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.cellulare = cellulare;
		this.cittaDiResidenza = cittaDiResidenza;
		this.idPersona = idPersona;
		this.profiloLinkedin = profiloLinkedin;
		this.idEsitoColloquio = idEsitoColloquio;
		this.esitoColloquio = esitoColloquio;
		this.coloreEsitoColloquio = coloreEsitoColloquio;
		this.dataInserimento = dataInserimento;
		this.competenzaPrincipale = competenzaPrincipale;
		this.dataColloquio = dataColloquio;
		this.annoColloquio = annoColloquio;
		this.fonteReperimento = fonteReperimento;
		this.costoGiornaliero = costoGiornaliero;
		this.possibilitaLavorativa = possibilitaLavorativa;
		this.competenzeTotali = competenzeTotali;
		this.certificazioni = certificazioni;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellulare() {
		return cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}

	public String getCittaDiResidenza() {
		return cittaDiResidenza;
	}

	public void setCittaDiResidenza(String cittaDiResidenza) {
		this.cittaDiResidenza = cittaDiResidenza;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getProfiloLinkedin() {
		return profiloLinkedin;
	}

	public void setProfiloLinkedin(String profiloLinkedin) {
		this.profiloLinkedin = profiloLinkedin;
	}

	public int getIdEsitoColloquio() {
		return idEsitoColloquio;
	}

	public void setIdEsitoColloquio(int idEsitoColloquio) {
		this.idEsitoColloquio = idEsitoColloquio;
	}

	public String getEsitoColloquio() {
		return esitoColloquio;
	}

	public void setEsitoColloquio(String esitoColloquio) {
		this.esitoColloquio = esitoColloquio;
	}

	public int getColoreEsitoColloquio() {
		return coloreEsitoColloquio;
	}

	public void setColoreEsitoColloquio(int coloreEsitoColloquio) {
		this.coloreEsitoColloquio = coloreEsitoColloquio;
	}

	public LocalDateTime getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(LocalDateTime dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public String getCompetenzaPrincipale() {
		return competenzaPrincipale;
	}

	public void setCompetenzaPrincipale(String competenzaPrincipale) {
		this.competenzaPrincipale = competenzaPrincipale;
	}

	public LocalDate getDataColloquio() {
		return dataColloquio;
	}

	public void setDataColloquio(LocalDate dataColloquio) {
		this.dataColloquio = dataColloquio;
	}

	public Integer getAnnoColloquio() {
		return annoColloquio;
	}

	public void setAnnoColloquio(Integer annoColloquio) {
		this.annoColloquio = annoColloquio;
	}

	public String getFonteReperimento() {
		return fonteReperimento;
	}

	public void setFonteReperimento(String fonteReperimento) {
		this.fonteReperimento = fonteReperimento;
	}

	public Double getCostoGiornaliero() {
		return costoGiornaliero;
	}

	public void setCostoGiornaliero(Double costoGiornaliero) {
		this.costoGiornaliero = costoGiornaliero;
	}

	public String getPossibilitaLavorativa() {
		return possibilitaLavorativa;
	}

	public void setPossibilitaLavorativa(String possibilitaLavorativa) {
		this.possibilitaLavorativa = possibilitaLavorativa;
	}

	public String getCompetenzeTotali() {
		return competenzeTotali;
	}

	public void setCompetenzeTotali(String competenzeTotali) {
		this.competenzeTotali = competenzeTotali;
	}

	public String getCertificazioni() {
		return certificazioni;
	}

	public void setCertificazioni(String certificazioni) {
		this.certificazioni = certificazioni;
	}
	
	public void setMapperModificaCandidato(JSONObject dettaglio, int idPersona) {
		this.setNome((String)dettaglio.get("nome"));
		this.setCognome((String)dettaglio.get("cognome"));
		this.setCellulare((String)dettaglio.get("cellulare"));
		this.setEmail((String)dettaglio.get("email"));
		this.setCittaDiResidenza((String)dettaglio.get("cittaDiResidenza"));
		DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDateTime now = LocalDateTime.now();  
		LocalDateTime data = LocalDateTime.parse(format1.format(now), format1);
		
		this.setIdPersona(idPersona);
		this.setProfiloLinkedin((String)dettaglio.get("profiloLinkedin"));
		this.setDataInserimento(data);
		this.setIdEsitoColloquio(Integer.parseInt((String)dettaglio.get("esitoColloquio")));
		this.setCompetenzaPrincipale((String)dettaglio.get("competenzaPrincipale"));
		if (((String)dettaglio.get("dataColloquio")).equals(""))
			this.setDataColloquio(null);
		else
			this.setDataColloquio(LocalDate.parse((String)dettaglio.get("dataColloquio"), format2));
		this.setAnnoColloquio((Integer)dettaglio.get("annoColloquio"));
		this.setFonteReperimento((String)dettaglio.get("fonteReperimento"));
		this.setCostoGiornaliero(Double.parseDouble((String)dettaglio.get("costoGiornaliero")));
		this.setPossibilitaLavorativa((String)dettaglio.get("possibilitaLavorativa"));
		this.setCompetenzeTotali((String)dettaglio.get("competenzeTotali"));
		this.setCertificazioni((String)dettaglio.get("certificazioni"));
	}
	
}

















