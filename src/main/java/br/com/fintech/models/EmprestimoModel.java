package br.com.fintech.models;

import java.util.Calendar;

public class EmprestimoModel {
	private int id;
	private double valor;
	private double tributo;
	private String jurosMensal;
	private int quantidadeParcela;
	private int quantidadeParcelaPaga;
	private Calendar data;
	
	public EmprestimoModel() {
		super();
	}
	
	public EmprestimoModel(int id, double valor, double tributo, String jurosMensal, int quantidadeParcela,
			int quantidadeParcelaPaga, Calendar data) {
		super();
		this.id 					= id;
		this.valor 					= valor;
		this.tributo 				= tributo;
		this.jurosMensal 			= jurosMensal;
		this.quantidadeParcela 		= quantidadeParcela;
		this.quantidadeParcelaPaga 	= quantidadeParcelaPaga;
		this.data 					= data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getTributo() {
		return tributo;
	}

	public void setTributo(double tributo) {
		this.tributo = tributo;
	}

	public String getJurosMensal() {
		return jurosMensal;
	}

	public void setJurosMensal(String jurosMensal) {
		this.jurosMensal = jurosMensal;
	}

	public int getQuantidadeParcela() {
		return quantidadeParcela;
	}

	public void setQuantidadeParcela(int quantidadeParcela) {
		this.quantidadeParcela = quantidadeParcela;
	}

	public int getQuantidadeParcelaPaga() {
		return quantidadeParcelaPaga;
	}

	public void setQuantidadeParcelaPaga(int quantidadeParcelaPaga) {
		this.quantidadeParcelaPaga = quantidadeParcelaPaga;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}
	
	
	
}
