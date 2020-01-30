package Alloggio;

import Entità.Location;

public class Alloggio extends Location{
    
	

	private int prezzoMedio;
	private String tipoAlloggio;
	private ServiziAlloggio serviziAlloggio;
	
	public Alloggio(Location mainLoc, ServiziAlloggio serAlloggio, int prezzomedio,String tipoall) {
		super(mainLoc.getCod(), mainLoc.getNome(), mainLoc.getCod_residenza(), mainLoc.getTipo(), mainLoc.getPartitaIva(), mainLoc.getDescrizione());
		this.prezzoMedio=prezzomedio;
		this.tipoAlloggio=tipoall;
		this.setServiziAlloggio(serAlloggio);
	}
	
	public Alloggio(Alloggio all) {
		super(all.getCod(), all.getNome(), all.getCod_residenza(), all.getTipo(), all.getPartitaIva(), all.getDescrizione());
		this.prezzoMedio=all.getPrezzoMedio();
		this.tipoAlloggio=all.getTipoAlloggio();
		this.setServiziAlloggio(all.getServiziAlloggio());
		
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
