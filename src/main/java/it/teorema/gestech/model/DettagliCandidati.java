package it.teorema.gestech.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.simple.JSONObject;

@Entity
@Table(name="hr_dettagli_candidati")
public class DettagliCandidati
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "id_persona")
	private int idPersona;
	@Column(name = "profilo_linkedin")
	private String profiloLinkedin;
	@Column(name = "data_inserimento")
	private LocalDateTime dataInserimento;
	@Column(name = "id_esito_colloquio")
	private int idEsitoColloquio;
	@Column(name = "competenza_principale")
	private String competenzaPrincipale; 
	@Column(name = "data_colloquio")
	private LocalDate dataColloquio;
	@Column(name = "anno_colloquio")
	private int annoColloquio;
	@Column(name = "fonte_reperimento")
	private String fonteReperimento;
	@Column(name = "costo_giornaliero")
	private double  costoGiornaliero;
	@Column(name = "possibilita_lavorativa")
	private String possibilitaLavorativa;
	@Column(name = "competenze_totali")
	private String competenzeTotali;
	@Column(name = "certificazioni")
	private String certificazioni;
	
	public DettagliCandidati() {}

	public DettagliCandidati(Integer id, int idPersona, String profiloLinkedin, LocalDateTime dataInserimento,
			int idEsitoColloquio, String competenzaPrincipale, LocalDate dataColloquio,
			int annoColloquio, String fonteReperimento, double costoGiornaliero, String possibilitaLavorativa,
			String competenzeTotali, String certificazioni) {
		super();
		this.id = id;
		this.idPersona = idPersona;
		this.profiloLinkedin = profiloLinkedin;
		this.dataInserimento = dataInserimento;
		this.idEsitoColloquio = idEsitoColloquio;
		this.competenzaPrincipale = competenzaPrincipale;
		this.dataColloquio = dataColloquio;
		this.annoColloquio = annoColloquio;
		this.fonteReperimento = fonteReperimento;
		this.costoGiornaliero = costoGiornaliero;
		this.possibilitaLavorativa = possibilitaLavorativa;
		this.competenzeTotali = competenzeTotali;
		this.certificazioni = certificazioni;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public LocalDateTime getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(LocalDateTime dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public int getIdEsitoColloquio() {
		return idEsitoColloquio;
	}

	public void setIdEsitoColloquio(int idEsitoColloquio) {
		this.idEsitoColloquio = idEsitoColloquio;
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

	public int getAnnoColloquio() {
		return annoColloquio;
	}

	public void setAnnoColloquio(int annoColloquio) {
		this.annoColloquio = annoColloquio;
	}

	public String getFonteReperimento() {
		return fonteReperimento;
	}

	public void setFonteReperimento(String fonteReperimento) {
		this.fonteReperimento = fonteReperimento;
	}

	public double getCostoGiornaliero() {
		return costoGiornaliero;
	}

	public void setCostoGiornaliero(double costoGiornaliero) {
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
	
	public void setDettagliCandidato(JSONObject dettagliCandidato, int idPersona) {
		DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDateTime now = LocalDateTime.now();  
		LocalDateTime data = LocalDateTime.parse(format1.format(now), format1);
		
		this.setIdPersona(idPersona);
		this.setProfiloLinkedin((String)dettagliCandidato.get("profiloLinkedin"));
		this.setDataInserimento(data);
		//non funge il cast
		this.setIdEsitoColloquio(Integer.parseInt((String)dettagliCandidato.get("esitoColloquio")));
		this.setCompetenzaPrincipale((String)dettagliCandidato.get("competenzaPrincipale"));
		if (((String)dettagliCandidato.get("dataColloquio")).equals(""))
			this.setDataColloquio(null);
		else
			this.setDataColloquio(LocalDate.parse((String)dettagliCandidato.get("dataColloquio"), format2));
		this.setAnnoColloquio((Integer)dettagliCandidato.get("annoColloquio"));
		this.setFonteReperimento((String)dettagliCandidato.get("fonteReperimento"));
		this.setCostoGiornaliero(Double.parseDouble((String)dettagliCandidato.get("costoGiornaliero")));
		this.setPossibilitaLavorativa((String)dettagliCandidato.get("possibilitaLavorativa"));
		this.setCompetenzeTotali((String)dettagliCandidato.get("competenzeTotali"));
		this.setCertificazioni((String)dettagliCandidato.get("certificazioni"));
		
	}
}