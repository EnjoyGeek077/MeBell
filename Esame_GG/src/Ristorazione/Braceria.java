package Ristorazione;

public class Braceria {

    private boolean asporto;
    private boolean alcoliciArtigianali;
    private String tipoCarne;


    public Braceria(String asporto, String alcoliciArtigianali, String tipoCarne) {
    	if(asporto=="si") {
			this.asporto=true;
		}else {
			this.asporto=false;
		}
    	
    	if(alcoliciArtigianali=="si") {
			this.alcoliciArtigianali=true;
		}else {
			this.alcoliciArtigianali=false;
		}
    	
    	this.setTipoCarne(tipoCarne);
	}
    
    
	public boolean isAsporto() {
	return asporto;
    }
    public void setAsporto(boolean asporto) {
	this.asporto = asporto;
    }
    public boolean isAlcoliciArtigianali() {
	return alcoliciArtigianali;
    }
    public void setAlcoliciArtigianali(boolean alcoliciArtigianali) {
	this.alcoliciArtigianali = alcoliciArtigianali;
    }
	public String getTipoCarne() {
		return tipoCarne;
	}
	public void setTipoCarne(String tipoCarne) {
		this.tipoCarne = tipoCarne;
	}
}
