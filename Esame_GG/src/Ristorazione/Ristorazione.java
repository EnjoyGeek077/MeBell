package Ristorazione;

import Entità.Location;

public class Ristorazione extends Location{
	
    private int prezzoMedio;
    private int nPosti;
    private String tipoRistorazione;
    
    private SushiBar sushiBar;
    private Pizzeria pizzeria;
    private Braceria braceria;

	public Ristorazione(Location mainLoc, int prezzomedio, int nPosti, String tipoRistorazione) {
		super(mainLoc.getCod(), mainLoc.getNome(), mainLoc.getCod_residenza(), mainLoc.getTipo(), mainLoc.getPartitaIva(), mainLoc.getDescrizione(), mainLoc.getResidenzaLocation(), mainLoc.getRecensiondiLocation());

		this.prezzoMedio=prezzomedio;
		this.nPosti=nPosti;
		this.tipoRistorazione=tipoRistorazione;
	    }

    public int getPrezzoMedio() {
	return prezzoMedio;
    }
    public void setPrezzoMedio(int prezzoMedio) {
	this.prezzoMedio = prezzoMedio;
    }
    public int getnPosti() {
	return nPosti;
    }
    public void setnPosti(int nPosti) {
	this.nPosti = nPosti;
    }
    public String getTipoRistorazione() {
	return tipoRistorazione;
    }
    public void setTipoRistorazione(String tipoRistorazione) {
	this.tipoRistorazione = tipoRistorazione;
    }
	public SushiBar getSushiBar() {
		return sushiBar;
	}
	public void setSushiBar(SushiBar sushiBar) {
		this.sushiBar = sushiBar;
	}
	public Pizzeria getPizzeria() {
		return pizzeria;
	}
	public void setPizzeria(Pizzeria pizzeria) {
		this.pizzeria = pizzeria;
	}
	public Braceria getBraceria() {
		return braceria;
	}
	public void setBraceria(Braceria braceria) {
		this.braceria = braceria;
	}
}
