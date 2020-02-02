package Ristorazione;

import Entità.Location;

public class Ristorazione extends Location{
	
    private int prezzoMedio;
    private int nPosti;
    private String tipoRistorazione;
	
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
}
