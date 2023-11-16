package br.com.fintech.models;

import java.util.Calendar;

public class UsuarioModel {
	private String nome;
	private String eail;
	private String telefone;
	private String cargo;
	private String funcao;
	private Calendar dataNascimento;
	private double salario;
	private EnderecoModel endereco;
	private boolean adm;
	
	public UsuarioModel() {
		super();
	}
	
	public UsuarioModel(String nome, String eail, String telefone, String cargo, String funcao, Calendar dataNascimento,
			double salario, EnderecoModel endereco, boolean adm) {
		super();
		this.nome = nome;
		this.eail = eail;
		this.telefone = telefone;
		this.cargo = cargo;
		this.funcao = funcao;
		this.dataNascimento = dataNascimento;
		this.salario = salario;
		this.endereco = endereco;
		this.adm = adm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEail() {
		return eail;
	}

	public void setEail(String eail) {
		this.eail = eail;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public EnderecoModel getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoModel endereco) {
		this.endereco = endereco;
	}

	public boolean isAdm() {
		return adm;
	}

	public void setAdm(boolean adm) {
		this.adm = adm;
	}
	
}
