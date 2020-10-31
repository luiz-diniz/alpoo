package view;

import java.util.List;

public class Pizza {

	private String nome;
	private List<Coberturas> coberturas;
	private String tipo = "Individual";
	private Double valor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Coberturas> getCoberturas() {
		return coberturas;
	}

	public void setCoberturas(List<Coberturas> coberturas) {
		this.coberturas = coberturas;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Pizza [nome=" + nome + ", coberturas=" + coberturas + ", tipo=" + tipo + ", valor=" + valor + "]";
	}

}
