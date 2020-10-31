package view;


public class Coberturas {

	private String tipoCobertura;
	private Double valor;
	
	
	public Coberturas(String tipoCobertura, Double valor) {
		this.tipoCobertura = tipoCobertura;
		this.valor = valor;
	}
	public String getTipoCobertura() {
		return tipoCobertura;
	}
	public void setTipoCobertura(String tipoCobertura) {
		this.tipoCobertura = tipoCobertura;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "Coberturas: " + tipoCobertura + " R$ = " + valor + " \n";
	}
	
	

}
