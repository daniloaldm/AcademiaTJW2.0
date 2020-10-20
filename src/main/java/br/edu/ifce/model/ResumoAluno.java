package br.edu.ifce.model;

public class ResumoAluno {
	
	private String nome;
	private String CPF;
	
	public ResumoAluno(String nome, String CPF) {
		super();
		this.nome = nome;
		this.CPF = CPF;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	
	
}
