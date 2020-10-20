package br.edu.ifce.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQueries({
	@NamedQuery(name = "Aluno.listarTodos", query = "select a from Aluno a"),
}) 

@Entity
@Table (name = "tbl_aluno")
public class Aluno implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Aluno() {
			telefone = new ArrayList<Telefone>();
			endereco = new Endereco();
	}
	
	@Id
	@GeneratedValue
	@Column(unique = true)
	private Long id;
	
	//length: Limita a quantidade de caracteres de uma string
	//nullable: Determina se o campo pode possuir valores null ou não
	//unique: Determina se uma coluna pode ter valores repetidos ou não
	//precision: Determina a quantidade de dígitos de um número decimal a serem armazenadas
	//scale: Determina a quantidade de casas decimais de um número decimal
	
	@Column (name = "nome_aluno")
	private String nome;
	
	@ElementCollection
	private List<String> ocorrencias;
	
	@Column (name = "rg")
	private String RG;
	
	@Column (name = "cpf")
	private String CPF;
	
	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn(name="end_id" , unique = true)
	private Endereco endereco;
	
	//@ManyToOne
	//private Sede sede = new Sede();
	// 
	
	
	@OneToMany (cascade = CascadeType.PERSIST)
	private Collection<Telefone> telefone ;
	
	
	@Temporal(TemporalType.DATE)
	private Date nascimento;
	
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRG() {
		return RG;
	}
	public void setRG(String rG) {
		RG = rG;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	
	public Collection<Telefone> getTelefone() {
		return telefone;
	}
	public void setTelefone(Collection<Telefone> telefone) {
		this.telefone = telefone;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	//public Sede getSede() {
		//return sede;
	//}
	//public void setSede(Sede sede) {
		//this.sede = sede;
	//}
	
	public List<String> getOcorrencias() {
		return ocorrencias;
	}
	public void setOcorrencias(List<String> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}
	
	
		
}
