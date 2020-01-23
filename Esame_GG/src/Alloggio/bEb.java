package Alloggio;

public class bEb extends Alloggio{
	public bEb(String codi, String nom, String cod_res, String tip, String partitaIv, String descrizion) {
		super(codi, nom, cod_res, tip, partitaIv, descrizion);
		// TODO Auto-generated constructor stub
	}
	private int nCamere;
	private int stelle;
	private boolean bagnoInComune;
	
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
