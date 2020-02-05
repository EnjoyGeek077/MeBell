package Entità;

import java.sql.Date;

public class Recensione {
    private String cod;
    private String creatore;
    private int voto;
    private String titolo;
    private String testo;
    private Date dataRecensione;

    public Recensione(String cod, String creatore, int voto, Date date, String titolo, String testo) {

	this.setCod(cod);
	this.setCreatore(creatore);
	this.setVoto(voto);
	this.setTitolo(titolo);
	this.setTesto(testo);
	this.setDataRecensione(date);

    }
    public String getCod() {
	return cod;
    }
    public void setCod(String cod) {
	this.cod = cod;
    }
    public String getCreatore() {
	return creatore;
    }
    public void setCreatore(String creatore) {
	this.creatore = creatore;
    }
    public int getVoto() {
	return voto;
    }
    public void setVoto(int voto) {
	this.voto = voto;
    }
    public String getTitolo() {
	return titolo;
    }
    public void setTitolo(String titolo) {
	this.titolo = titolo;
    }
    public String getTesto() {
	return testo;
    }
    public void setTesto(String testo) {
	this.testo = testo;
    }
	public Date getDataRecensione() {
		return dataRecensione;
	}
	public void setDataRecensione(Date dataRecensione) {
		this.dataRecensione = dataRecensione;
	}
}
