package Alloggio;

import Entità.Location;

public class Alloggio extends Location{
    
	public Alloggio(String cod, String nome, String cod_res, String tipo, String partitaIva, String descrizione) {
		super(cod, nome, cod_res, tipo, partitaIva, descrizione);
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
