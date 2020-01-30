package Alloggio;

import Entità.Location;

public class Appartemento extends Alloggio{
    	
    	public Appartemento(Location mainLoc, int prezzomedio, String tipoall) {
		super(mainLoc, serviziAlloggio, prezzomedio, tipoall);
		// TODO Auto-generated constructor stub
	}

		private int n_vani;
    	private int n_bagni;
    	private boolean veranda;
    	
	

	public int getN_vani() {
	    return n_vani;
	}

	public void setN_vani(int n_vani) {
	    this.n_vani = n_vani;
	}

	public int getN_bagni() {
	    return n_bagni;
	}

	public void setN_bagni(int n_bagni) {
	    this.n_bagni = n_bagni;
	}

	public boolean isVeranda() {
	    return veranda;
	}

	public void setVeranda(boolean veranda) {
	    this.veranda = veranda;
	}
	
}
