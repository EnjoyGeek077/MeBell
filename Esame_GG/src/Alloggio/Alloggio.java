package Alloggio;

import Entità.Location;

public class Alloggio extends Location{
	public Alloggio(String codi, String nom, String cod_res, String tip, String partitaIv, String descrizion) {
		super(codi, nom, cod_res, tip, partitaIv, descrizion);
		serviziAlloggio = new ServiziAlloggio();
		
	}

	private int prezzoMedio;
	private String tipoAlloggio;
	ServiziAlloggio serviziAlloggio;
	
	
	

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
