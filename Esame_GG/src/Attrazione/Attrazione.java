package Attrazione;

import Entit�.Location;

public class Attrazione extends Location{
    
    
    private boolean pagamento;
    private String tipoAttrazione;
    
    public Attrazione(Location loc,String pagamento, String tipoatt) {
   	super(loc.getCod(), loc.getNome(), loc.getCod_residenza(), loc.getTipo(), loc.getPartitaIva(), loc.getDescrizione(), loc.getResidenzaLocation(), loc.getRecensiondiLocation());
   	
   	this.tipoAttrazione=tipoatt;
   	
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
