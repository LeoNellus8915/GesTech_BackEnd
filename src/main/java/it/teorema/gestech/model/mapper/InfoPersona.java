package it.teorema.gestech.model.mapper;

public class InfoPersona {

	String nome;
	String cognome;
	String email;
	String cellulare;
	String cittaDiResidenza;
	
	public InfoPersona() {}

	public InfoPersona(String nome, String cognome, String email, String cellulare, String cittaDiResidenza) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.cellulare = cellulare;
		this.cittaDiResidenza = cittaDiResidenza;
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
	
	
}
