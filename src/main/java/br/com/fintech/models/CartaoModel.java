package br.com.fintech.models;

import java.util.Calendar;

public class CartaoModel {
	private String nomeBandeira;
	private Calendar dataValidade;
	private int codigoSeguranca;
	private String nomeImpresso;
	private int numeroCartao;
	private String tipoCartao;
	private boolean ativo;

	public CartaoModel(String nomeBandeira, Calendar dataValidade, int codigoSeguranca, String nomeImpresso,
			int numeroCartao, String tipoCartao, boolean ativo) {
		super();
		this.nomeBandeira 			= nomeBandeira;
		this.dataValidade			= dataValidade;
		this.codigoSeguranca 		= codigoSeguranca;
		this.nomeImpresso 			= nomeImpresso;
		this.numeroCartao 			= numeroCartao;
		this.tipoCartao 			= tipoCartao;
		this.ativo 					= ativo;
	}

	public String getNomeBandeira() {
		return nomeBandeira;
	}

	public void setNomeBandeira(String nomeBandeira) {
		this.nomeBandeira = nomeBandeira;
	}

	public Calendar getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}

	public int getCodigoSeguranca() {
		return codigoSeguranca;
	}

	public void setCodigoSeguranca(int codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}

	public String getNomeImpresso() {
		return nomeImpresso;
	}

	public void setNomeImpresso(String nomeImpresso) {
		this.nomeImpresso = nomeImpresso;
	}

	public int getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(int numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getTipoCartao() {
		return tipoCartao;
	}

	public void setTipoCartao(String tipoCartao) {
		this.tipoCartao = tipoCartao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public boolean verificarValidade() {
		return ativo;
	}
	
	
	
}
