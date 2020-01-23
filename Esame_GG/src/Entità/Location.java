package Entità;

public class Location {
	private String cod;
	private String nome;
	private String cod_residenza;
	private String tipo;
	private String partitaIva;
	private String descrizione;
	
	

	public Location(String codi, String nom, String cod_res, String tip, String partitaIv, String descrizion) {
		
		setCod(codi);
		setNome(nom);
		setCod_residenza(cod_res);
		setTipo(tip);
		setPartitaIva(partitaIv);
		setDescrizione(descrizion);

	}
	
	
	
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPartitaIva() {
		return partitaIva;
	}
	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getCod_residenza() {
		return cod_residenza;
	}
	public void setCod_residenza(String cod_residenza) {
		this.cod_residenza = cod_residenza;
	}

}
