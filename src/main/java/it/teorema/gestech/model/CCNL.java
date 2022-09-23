package it.teorema.gestech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ty_ccnl")
public class CCNL
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "id_azienda")
	private int idAzienda;
	@Column(name = "ccnl")
	private String ccnl;
	
	public CCNL() {}

	public CCNL(int id, int idAzienda, String ccnl) {
		super();
		this.id = id;
		this.idAzienda = idAzienda;
		this.ccnl = ccnl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAzienda() {
		return idAzienda;
	}

	public void setIdAzienda(int idAzienda) {
		this.idAzienda = idAzienda;
	}

	public String getCcnl() {
		return ccnl;
	}

	public void setCcnl(String ccnl) {
		this.ccnl = ccnl;
	}
}