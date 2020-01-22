package Alloggio;

public class Hotel extends Alloggio{
	private int nCamere;
	private int Nsuite;
	private int stelle;
	
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
