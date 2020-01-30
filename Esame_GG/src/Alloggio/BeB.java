package Alloggio;

import Entità.Location;

public class BeB extends Alloggio{

	public BeB(Alloggio all,int nCamere, int stelle, boolean bagnoInComune) {
		super(all);
		this.nCamere=nCamere;
		this.bagnoInComune=bagnoInComune;
		this.stelle=stelle;
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
