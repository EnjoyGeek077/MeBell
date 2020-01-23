package Alloggio;

public class Appartemento extends Alloggio{
    	
    	private int n_vani;
    	private int n_bagni;
    	private boolean veranda;
    	
	public Appartemento(String cod, String nome, String cod_res, String tipo, String partitaIva, String descrizione) {
	super(cod, nome, cod_res, tipo, partitaIva, descrizione);
	// TODO Auto-generated constructor stub
    }

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
