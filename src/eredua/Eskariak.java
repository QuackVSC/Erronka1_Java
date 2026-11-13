package eredua;

public class Eskariak {

	private String zenbakia;
	private String produktua;
	private Integer kopurua;
	private Double prezioa;
	private String data;

	public String getZenbakia() {
		return zenbakia;
	}

	public void setZenbakia(String zenbakia) {
		this.zenbakia = zenbakia;
	}

	public String getProduktua() {
		return produktua;
	}

	public void setProduktua(String produktua) {
		this.produktua = produktua;
	}

	public Integer getKopurua() {
		return kopurua;
	}

	public void setKopurua(Integer kopurua) {
		this.kopurua = kopurua;
	}

	public Double getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(Double prezioa) {
		this.prezioa = prezioa;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String toString() {

		Double prezioTotala = kopurua * prezioa;

		String prezioTotalaZuzena = String.format("%.2f", prezioTotala).replace(",", ".");

		return zenbakia + " - " + produktua + " - " + kopurua + " - " + prezioa + " - " + prezioTotalaZuzena + " - "
				+ data;

	}

}
