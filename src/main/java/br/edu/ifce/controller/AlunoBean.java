package br.edu.ifce.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.ifce.dao.AlunoDao;
import br.edu.ifce.model.Aluno;
import br.edu.ifce.model.Telefone;

@ManagedBean
@ViewScoped
public class AlunoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Aluno aluno;
	private AlunoDao dao;
	private Collection<Telefone> lphone;
	private Long idaluno;
	private ArrayList<Aluno> listaAlunos;

	public ArrayList<Aluno> getListaAlunos() {
		return listaAlunos;
	}

	public void setListaAlunos(ArrayList<Aluno> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}

	@PostConstruct
	private void init() {
		aluno = new Aluno();
		dao = new AlunoDao();
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String idaluno = params.get("idaluno");
		if(idaluno != null && idaluno != "") {
			aluno = dao.getById(Long.parseLong(idaluno));
		}
		
		
		lphone = aluno.getTelefone();
		buscarAluno();

	}

	public void addfone(String numero) {
		Telefone t = new Telefone();
		t.setTelefone(numero);
		t.setTipo("-- não informado --");
		this.lphone.add(t);

		for (Telefone telefone : lphone) {
			System.out.println(telefone.getTelefone());
		}
	}

	public String buscarAluno() {

		listaAlunos = (ArrayList<Aluno>) dao.findAll();

		return "listadealunos";

	}

	public String salvar() {
		dao.salvar(aluno);
		return "cadastroaluno";

	}

	public String update() {
		
		dao.update(aluno);
		return "listadealunos";

	}

	public String redirect(Long id) {

		this.aluno = dao.getById(id);

		return "editaraluno";

	}

	public String remove(Long id) {

		this.aluno = dao.getById(id);
		dao.excluir(aluno);
		return "listadealunos.jsf";

	}

	public Long getIdaluno() {
		return idaluno;
	}

	public void setIdaluno(Long idaluno) {
		this.idaluno = idaluno;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public AlunoDao getDao() {
		return dao;
	}

	public void setDao(AlunoDao dao) {
		this.dao = dao;
	}

	public void setLphone(Collection<Telefone> lphone) {
		this.lphone = lphone;
	}

}
