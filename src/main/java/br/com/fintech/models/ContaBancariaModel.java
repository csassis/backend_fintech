package br.com.fintech.models;

public class ContaBancariaModel {
	private int usuarioID;
	private String agencia;
	private String conta;
	private double saldo;
	private String tipoConta;
	private boolean ativo;
	
	public ContaBancariaModel() {
		super();
	}
	
	public ContaBancariaModel(String agencia, String conta, double saldo, String tipoConta, boolean ativo) {
		super();
		this.agencia 		= agencia;
		this.conta 			= conta;
		this.saldo 			= saldo;
		this.tipoConta 		= tipoConta;
		this.ativo 			= ativo;
	}
	public int getUsuarioID() {
		return usuarioID;
	}
	public void setUsuarioID(int usuarioID) {
		this.usuarioID = usuarioID;
	}
	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}
