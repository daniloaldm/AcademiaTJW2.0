package br.edu.ifce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import br.edu.ifce.utils.JPAUtil;

public abstract class GenericDao <T> {
		
    private final EntityManager manager = JPAUtil.getEntityManager();
	
	private final Class<T> clazz;
	
	public GenericDao(Class<T> clazz) {
		this.clazz = clazz;
	}

	public T getById(Long id) {
		return manager.find(clazz, id);
	}

	public List<T> findAll() { 
		TypedQuery<T> q = manager.createQuery(" FROM " + clazz.getSimpleName(), clazz);
		return q.getResultList();
	}

	public void salvar(T clazz) {
		manager.getTransaction().begin();
		manager.persist(clazz);
		manager.getTransaction().commit();
	}

	public void update(T clazz) {
		manager.getTransaction().begin();
		manager.merge(clazz);
		manager.getTransaction().commit();
	}

	public void excluir(T clazz) {
		manager.getTransaction().begin();
		manager.remove(clazz);
		manager.getTransaction().commit();
	}

	public void excluir(Long id) {
		excluir(getById(id));
	}
}
