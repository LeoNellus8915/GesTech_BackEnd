package it.teorema.gestech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ty_nome")
public class CCNL
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "codice")
	private int codice;
	@Column(name = "nome")
	private String nome;
	
	public CCNL() {}

	public CCNL(int id, int codice, String nome) {
		super();
		this.id = id;
		this.codice = codice;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getcodice() {
		return codice;
	}

	public void setcodice(int codice) {
		this.codice = codice;
	}

	public String getCcnl() {
		return nome;
	}

	public void setCcnl(String nome) {
		this.nome = nome;
	}
}