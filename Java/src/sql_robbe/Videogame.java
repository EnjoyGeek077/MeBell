package sql_robbe;
 
public class Videogame extends Articolo {
	private String titolo;
	
	public Videogame(String cod,String title) {
		setCodice(cod);
		titolo=title;
	}
	
	
	public Videogame() {
		// TODO Auto-generated constructor stub
	}


	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	@Override
	public String toString() {
		return ("Articolo:   "+getCodice()+"   Nome: "+titolo);
	}
}
