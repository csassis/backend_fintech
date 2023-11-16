package br.com.fintech.models;

import java.util.Date;

	public class DespesaModel {
	private int id;
	private String tipo;
	private double valor;
	private Date dataCriacao;
	private int usuarioID;

	public DespesaModel() {
		super();
	}

	public DespesaModel(int id, String tipo, double valor, Date dataCriacao, int usuarioID) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.valor = valor;
		this.dataCriacao = dataCriacao;
		this.usuarioID = usuarioID;
	}
	
	

	@Override
	public String toString() {
		return "DespesaModel [id=" + id + ", tipo=" + tipo + ", valor=" + valor + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public int getUsuarioID() {
		return usuarioID;
	}

	public void setUsuarioID(int usuarioID) {
		this.usuarioID = usuarioID;
	}

}
