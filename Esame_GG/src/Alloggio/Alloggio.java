package Alloggio;

import Entità.Location;

public class Alloggio extends Location{
	private int prezzoMedio;
	private String tipoAlloggio;
	ServiziAlloggio serviziAlloggio;
	
	public Alloggio() {
		serviziAlloggio = new ServiziAlloggio(); 
	}
	

	public int getPrezzoMedio() {
		return prezzoMedio;
	}

	public void setPrezzoMedio(int prezzoMedio) {
		this.prezzoMedio = prezzoMedio;
	}

	public String getTipoAlloggio() {
		return tipoAlloggio;
	}

	public void setTipoAlloggio(String tipoAlloggio) {
		this.tipoAlloggio = tipoAlloggio;
	}

	public ServiziAlloggio getServiziAlloggio() {
		return serviziAlloggio;
	}

	public void setServiziAlloggio(ServiziAlloggio serviziAlloggio) {
		this.serviziAlloggio = serviziAlloggio;
	}

}
