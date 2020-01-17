package sql_robbe;
 
public class Articolo {
	private String codice;
	
	public Articolo() {
		
	}
	
	public Articolo(String cod) {
		this.codice=cod;
	}
	
	
	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}
	
	public String toString() {
		return ("Articolo: "+codice);
	}
}
