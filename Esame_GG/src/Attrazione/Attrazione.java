package Attrazione;

import Entità.Location;

public class Attrazione extends Location{
    
    private String cod;
    private boolean pagamento;
    private String tipoAttrazione;
    
    public Attrazione(String cod, String nome, String cod_res, String tipo, String partitaIva, String descrizione) {
   	super(cod, nome, cod_res, tipo, partitaIva, descrizione);
   	// TODO Auto-generated constructor stub
       }
    
    public String getCod() {
        return cod;
    }
    public void setCod(String cod) {
        this.cod = cod;
    }
    public boolean isPagamento() {
        return pagamento;
    }
    public void setPagamento(boolean pagamento) {
        this.pagamento = pagamento;
    }
    public String getTipoAttrazione() {
        return tipoAttrazione;
    }
    public void setTipoAttrazione(String tipoAttrazione) {
        this.tipoAttrazione = tipoAttrazione;
    }
    

}
