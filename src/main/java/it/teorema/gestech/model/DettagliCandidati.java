package it.teorema.gestech.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hy_dettagli_candidati")
public class DettagliCandidati
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "id_candidato")
	private Integer idCandidato;
	@Column(name = "file_base64")
	private String fileBase64;
	@Column(name = "data_inserimento")
	private LocalDateTime dataInserimento;
	@Column(name = "id_esito_colloquio")
	private Integer idEsitoColloquio;
	@Column(name = "id_profilo")
	private Integer idProfilo;
	@Column(name = "id_linguaggio1")
	private Integer idLinguaggio1;
	@Column(name = "id_linguaggio2")
	private Integer idLinguaggio2;
	@Column(name = "id_linguaggio3")
	private Integer idLinguaggio3;
	@Column(name = "id_linguaggio4")
	private Integer idLinguaggio4;
	@Column(name = "id_linguaggio5")
	private Integer idLinguaggio5;
	@Column(name = "id_lingua1")
	private Integer idLingua1;
	@Column(name = "id_lingua2")
	private Integer idLingua2;
	@Column(name = "id_lingua3")
	private Integer idLingua3;
	@Column(name = "id_livello")
	private Integer idLivello;
	@Column(name = "linguaggio_campo_libero")
	private String linguaggioCampoLibero;
	@Column(name = "competenza_principale")
	private String competenzaPrincipale;
	@Column(name = "data_colloquio")
	private LocalDate dataColloquio;
	@Column(name = "anno_colloquio")
	private int annoColloquio;
	@Column(name = "fonte_reperimento")
	private String fonteReperimento;
	@Column(name = "costo_giornaliero")
	private Double costoGiornaliero;
	@Column(name = "possibilita_lavorativa")
	private String possibilitaLavorativa;
	@Column(name = "competenze_totali")
	private String competenzeTotali;
	@Column(name = "certificazioni")
	private String certificazioni;
	
	public DettagliCandidati() {}

	public DettagliCandidati(Integer id, Integer idCandidato, String fileBase64, LocalDateTime dataInserimento,
			Integer idEsitoColloquio, Integer idProfilo, Integer idLinguaggio1, Integer idLinguaggio2,
			Integer idLinguaggio3, Integer idLinguaggio4, Integer idLinguaggio5, Integer idLingua1, Integer idLingua2,
			Integer idLingua3, Integer idLivello, String linguaggioCampoLibero, String competenzaPrincipale,
			LocalDate dataColloquio, int annoColloquio, String fonteReperimento, Double costoGiornaliero,
			String possibilitaLavorativa, String competenzeTotali, String certificazioni) {
		super();
		this.id = id;
		this.idCandidato = idCandidato;
		this.fileBase64 = fileBase64;
		this.dataInserimento = dataInserimento;
		this.idEsitoColloquio = idEsitoColloquio;
		this.idProfilo = idProfilo;
		this.idLinguaggio1 = idLinguaggio1;
		this.idLinguaggio2 = idLinguaggio2;
		this.idLinguaggio3 = idLinguaggio3;
		this.idLinguaggio4 = idLinguaggio4;
		this.idLinguaggio5 = idLinguaggio5;
		this.idLingua1 = idLingua1;
		this.idLingua2 = idLingua2;
		this.idLingua3 = idLingua3;
		this.idLivello = idLivello;
		this.linguaggioCampoLibero = linguaggioCampoLibero;
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

	public Integer getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(Integer idCandidato) {
		this.idCandidato = idCandidato;
	}

	public String getFileBase64() {
		return fileBase64;
	}

	public void setFileBase64(String fileBase64) {
		this.fileBase64 = fileBase64;
	}

	public LocalDateTime getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(LocalDateTime dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public Integer getIdEsitoColloquio() {
		return idEsitoColloquio;
	}

	public void setIdEsitoColloquio(Integer idEsitoColloquio) {
		this.idEsitoColloquio = idEsitoColloquio;
	}

	public Integer getIdProfilo() {
		return idProfilo;
	}

	public void setIdProfilo(Integer idProfilo) {
		this.idProfilo = idProfilo;
	}

	public Integer getIdLinguaggio1() {
		return idLinguaggio1;
	}

	public void setIdLinguaggio1(Integer idLinguaggio1) {
		this.idLinguaggio1 = idLinguaggio1;
	}

	public Integer getIdLinguaggio2() {
		return idLinguaggio2;
	}

	public void setIdLinguaggio2(Integer idLinguaggio2) {
		this.idLinguaggio2 = idLinguaggio2;
	}

	public Integer getIdLinguaggio3() {
		return idLinguaggio3;
	}

	public void setIdLinguaggio3(Integer idLinguaggio3) {
		this.idLinguaggio3 = idLinguaggio3;
	}

	public Integer getIdLinguaggio4() {
		return idLinguaggio4;
	}

	public void setIdLinguaggio4(Integer idLinguaggio4) {
		this.idLinguaggio4 = idLinguaggio4;
	}

	public Integer getIdLinguaggio5() {
		return idLinguaggio5;
	}

	public void setIdLinguaggio5(Integer idLinguaggio5) {
		this.idLinguaggio5 = idLinguaggio5;
	}

	public Integer getIdLingua1() {
		return idLingua1;
	}

	public void setIdLingua1(Integer idLingua1) {
		this.idLingua1 = idLingua1;
	}

	public Integer getIdLingua2() {
		return idLingua2;
	}

	public void setIdLingua2(Integer idLingua2) {
		this.idLingua2 = idLingua2;
	}

	public Integer getIdLingua3() {
		return idLingua3;
	}

	public void setIdLingua3(Integer idLingua3) {
		this.idLingua3 = idLingua3;
	}

	public Integer getIdLivello() {
		return idLivello;
	}

	public void setIdLivello(Integer idLivello) {
		this.idLivello = idLivello;
	}

	public String getLinguaggioCampoLibero() {
		return linguaggioCampoLibero;
	}

	public void setLinguaggioCampoLibero(String linguaggioCampoLibero) {
		this.linguaggioCampoLibero = linguaggioCampoLibero;
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
}