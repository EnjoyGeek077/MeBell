package Alloggio;

public class bEb extends Alloggio{

	private int nCamere;
	private int stelle;
	private boolean bagnoInComune;
	
	public bEb(String cod, String nome, String cod_res, String tipo, String partitaIva, String descrizione) {
		super(cod, nome, cod_res, tipo, partitaIva, descrizione);
		// TODO Auto-generated constructor stub
	    }
	
	public int getnCamere() {
		return nCamere;
	}
	public void setnCamere(int nCamere) {
		this.nCamere = nCamere;
	}
	public int getStelle() {
		return stelle;
	}
	public void setStelle(int stelle) {
		this.stelle = stelle;
	}
	public boolean isBagnoInComune() {
		return bagnoInComune;
	}
	public void setBagnoInComune(boolean bagnoInComune) {
		this.bagnoInComune = bagnoInComune;
	}
}
