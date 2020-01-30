package Alloggio;

public class ServiziAlloggio {
	
	private boolean wi_fi;
	private boolean dayUse;
	private boolean spa;
	private boolean piscina;
	private boolean ariaCondizionata;
	private boolean accessoDisabili;
	private boolean accessoAnimali;
	private boolean ascenzore;
	private boolean servizioLavanderia;
	private boolean servizioRistorazione;
	private boolean tv_stereo;
	private boolean parcheggio;
	
	
	
	public ServiziAlloggio(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12) {
		if(string=="si") {
			wi_fi=true;
		}else {
			wi_fi=false;
		}
		
		if(string2=="si") {
			dayUse=true;
		}else {
			dayUse=false;
		}
		
		if(string3=="si") {
			spa=true;
		}else {
			spa=false;
		}
		
		if(string4=="si") {
			piscina=true;
		}else {
			piscina=false;
		}
		
		if(string5=="si") {
			ariaCondizionata=true;
		}else {
			ariaCondizionata=false;
		}
		
		if(string6=="si") {
			accessoDisabili=true;
		}else {
			accessoDisabili=false;
		}
		
		if(string7=="si") {
			accessoAnimali=true;
		}else {
			accessoAnimali=false;
		}
		
		if(string8=="si") {
			ascenzore=true;
		}else {
			ascenzore=false;
		}
		
		if(string9=="si") {
			servizioLavanderia=true;
		}else {
			servizioLavanderia=false;
		}
		
		if(string10=="si") {
			servizioRistorazione=true;
		}else {
			servizioRistorazione=false;
		}
		
		if(string11=="si") {
			tv_stereo=true;
		}else {
			tv_stereo=false;
		}
		
		if(string12=="si") {
			parcheggio=true;
		}else {
			parcheggio=false;
		}
	}
	public boolean isWi_fi() {
		return wi_fi;
	}
	public void setWi_fi(boolean wi_fi) {
		this.wi_fi = wi_fi;
	}
	public boolean isDayUse() {
		return dayUse;
	}
	public void setDayUse(boolean dayUse) {
		this.dayUse = dayUse;
	}
	public boolean isSpa() {
		return spa;
	}
	public void setSpa(boolean spa) {
		this.spa = spa;
	}
	public boolean isPiscina() {
		return piscina;
	}
	public void setPiscina(boolean piscina) {
		this.piscina = piscina;
	}
	public boolean isAriaCondizionata() {
		return ariaCondizionata;
	}
	public void setAriaCondizionata(boolean ariaCondizionata) {
		this.ariaCondizionata = ariaCondizionata;
	}
	public boolean isAccessoDisabili() {
		return accessoDisabili;
	}
	public void setAccessoDisabili(boolean accessoDisabili) {
		this.accessoDisabili = accessoDisabili;
	}
	public boolean isAccessoAnimali() {
		return accessoAnimali;
	}
	public void setAccessoAnimali(boolean accessoAnimali) {
		this.accessoAnimali = accessoAnimali;
	}
	public boolean isAcenzore() {
		return ascenzore;
	}
	public void setAcenzore(boolean acenzore) {
		this.ascenzore = acenzore;
	}
	public boolean isServizioLavanderia() {
		return servizioLavanderia;
	}
	public void setServizioLavanderia(boolean servizioLavanderia) {
		this.servizioLavanderia = servizioLavanderia;
	}
	public boolean isServizioRistorazione() {
		return servizioRistorazione;
	}
	public void setServizioRistorazione(boolean servizioRistorazione) {
		this.servizioRistorazione = servizioRistorazione;
	}
	public boolean isTv_stereo() {
		return tv_stereo;
	}
	public void setTv_stereo(boolean tv_stereo) {
		this.tv_stereo = tv_stereo;
	}
	public boolean isParcheggio() {
		return parcheggio;
	}
	public void setParcheggio(boolean parcheggio) {
		this.parcheggio = parcheggio;
	}
}
