package br.edu.ifce.code;

import br.edu.ifce.dao.AlunoDao;
import br.edu.ifce.model.Aluno;
import br.edu.ifce.model.Endereco;

public class AddAluno {
	public static void main(String args[]) {
		AlunoDao ad = new AlunoDao();
		// Sede s = new SedeDao().getById(1L);
		// System.out.println(s.getNome());

		Aluno a = new Aluno();
		a.setNome("Corneli Gomes Furtado Júnior");
		// a.setSede(s);
		ad.salvar(a);

		Endereco e = new Endereco();
		e.setLogradouro("Rua Bruno Porto, 555");

	}
}
