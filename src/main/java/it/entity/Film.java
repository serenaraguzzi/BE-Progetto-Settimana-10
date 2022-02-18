package it.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQuery (name = "film.trovaTutti", query = "SELECT f from Film f")
@NamedQuery (name = "film.trovaByRegista", query = "SELECT f from Film f where f.regista =?1")

public class Film {

	private int id;
	private String titolo;
	private int anno;
	private String regista;
	private String tipo;
	private String incasso;

	//Getters
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column
	public int getId() { return id; }

	@Column
	public String getTitolo() { return titolo; }

	@Column
	public int getAnno() { return anno; }

	@Column
	public String getRegista() { return regista; }

	@Column
	public String getTipo() { return tipo; }

	@Column
	public String getIncasso() { return incasso; }

	
	//Setters
	public void setId(int id) { this.id = id; }
	public void setTitolo(String titolo) { this.titolo = titolo; }
	public void setAnno(int anno) { this.anno = anno; }
	public void setRegista(String regista) { this.regista = regista; }
	public void setTipo(String tipo) { this.tipo = tipo; }
	public void setIncasso(String incasso) { this.incasso = incasso; }

}