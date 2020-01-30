package Alloggio;

import Entità.Location;

public class BeB extends Alloggio{

	public BeB(Location mainLoc, int prezzomedio, String tipoall) {
		super(mainLoc, serviziAlloggio, prezzomedio, tipoall);
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
