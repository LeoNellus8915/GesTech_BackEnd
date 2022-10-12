package it.teorema.gestech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="am_clienti")
public class Clienti
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "sede")
	private String sede;
	@Column(name = "partita_iva")
	private String partitaIva;
	@Column(name = "stato")
	private int stato;
	
	public Clienti() {}

	public Clienti(int id, String nome, String sede, String partitaIva, int stato) {
		super();
		this.id = id;
		this.nome = nome;
		this.sede = sede;
		this.partitaIva = partitaIva;
		this.stato = stato;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public int getStato() {
		return stato;
	}

	public void setStato(int stato) {
		this.stato = stato;
	}
	
	
}