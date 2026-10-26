package eredua;

public class Langileak {

	private String ID;
	private String izena;
	private String abizena;
	private String altaEguna;
	private String telZenbakia;

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getAbizena() {
		return abizena;
	}

	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}

	public String getAltaEguna() {
		return altaEguna;
	}

	public void setAltaEguna(String altaEguna) {
		this.altaEguna = altaEguna;
	}

	public String getTelZenbakia() {
		return telZenbakia;
	}

	public void setTelZenbakia(String telZenbakia) {
		this.telZenbakia = telZenbakia;
	}

	public String toString() {
		return ID + " - " + izena + " - " + abizena + " - " + telZenbakia + " - " + altaEguna;
	}
}
