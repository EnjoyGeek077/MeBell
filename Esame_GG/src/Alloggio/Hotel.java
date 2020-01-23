package Alloggio;

public class Hotel extends Alloggio{
   
	private int nCamere;
	private int Nsuite;
	private int stelle;
	
	public Hotel(String cod, String nome, String cod_res, String tipo, String partitaIva, String descrizione) {
		super(cod, nome, cod_res, tipo, partitaIva, descrizione);
		// TODO Auto-generated constructor stub
	    }
	
	public int getnCamere() {
		return nCamere;
	}
	public void setnCamere(int nCamere) {
		this.nCamere = nCamere;
	}
	public int getNsuite() {
		return Nsuite;
	}
	public void setNsuite(int nsuite) {
		Nsuite = nsuite;
	}
	public int getStelle() {
		return stelle;
	}
	public void setStelle(int stelle) {
		this.stelle = stelle;
	}
}
