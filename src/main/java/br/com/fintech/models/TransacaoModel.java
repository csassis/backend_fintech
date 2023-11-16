package br.com.fintech.models;

import java.util.Calendar;

public class TransacaoModel {
	private int id;
	private String tipo;
	private double valor;
	private Calendar dataCriacao;
	private Calendar dataVencimento;
	private int usuarioID;
	
	public TransacaoModel() {
		super();
	}
	
	public TransacaoModel(int id, String tipo, double valor, Calendar dataCriacao, Calendar dataVencimento,
			int usuarioID) {
		super();
		this.id 				= id;
		this.tipo 				= tipo;
		this.valor 				= valor;
		this.dataCriacao 		= dataCriacao;
		this.dataVencimento 	= dataVencimento;
		this.usuarioID 			= usuarioID;
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

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Calendar getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public int getUsuarioID() {
		return usuarioID;
	}

	public void setUsuarioID(int usuarioID) {
		this.usuarioID = usuarioID;
	}
	
	
}
