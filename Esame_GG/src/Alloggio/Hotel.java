package Alloggio;

import Entità.Location;

public class Hotel extends Alloggio{
	
	private int nCamere;
	private int Nsuite;
	private int stelle;
	private ServiziAlloggio serviziAlloggio;
   
	public Hotel(Location mainLoc, int prezzomedio, String tipoall) {
		super(mainLoc, serviziAlloggio, prezzomedio, tipoall);
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
