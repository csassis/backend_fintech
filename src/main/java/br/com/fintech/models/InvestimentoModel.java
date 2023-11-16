package br.com.fintech.models;

import java.util.Date;

public class InvestimentoModel {
	@Override
	public String toString() {
		return "InvestimentoModel [id=" + id + ", tipo=" + tipo + ", valor=" + valor + ", dataCriacao=" + dataCriacao
				+ ", dataVencimento=" + dataVencimento + "]";
	}

	private int id;
	private String tipo;
	private double valor;
	private Date dataCriacao;
	private Date dataVencimento;
	private int usuarioID;

	public InvestimentoModel() {
		super();
	}

	public InvestimentoModel(int id, String tipo, double valor, Date dataCriacao, Date dataVencimento, int usuarioID) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.valor = valor;
		this.dataCriacao = dataCriacao;
		this.dataVencimento = dataVencimento;
		this.usuarioID = usuarioID;
	}

	public InvestimentoModel(String tipo, double valor, Date dataCriacao, Date dataVencimento, int usuarioID) {
		super();
		this.tipo = tipo;
		this.valor = valor;
		this.dataCriacao = dataCriacao;
		this.dataVencimento = dataVencimento;
		this.usuarioID = usuarioID;
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

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public int getUsuarioID() {
		return usuarioID;
	}

	public void setUsuarioID(int usuarioID) {
		this.usuarioID = usuarioID;
	}

}
