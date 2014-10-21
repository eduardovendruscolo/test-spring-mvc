package br.com.rachacontas.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.rachacontas.dao.DAOBase;

@Transactional(propagation=Propagation.SUPPORTS)
public abstract class HBDAO<T> implements DAOBase<T> {

	@Autowired
	private SessionFactory sessionFactory;

	public void excluir(T objeto) {
		getSession().delete(objeto);
	}
	public T get(Long id) {
		return (T) getSession().get(getClazz(), id);
	}

	protected abstract Class getClazz();

	protected Session getSession() {
		return getSessionFactory().getCurrentSession();
	}


	public SessionFactory getSessionFactory() {return sessionFactory;}

	public List<T> list(int offset, int max) {
		return getSession().createCriteria(getClazz())
				.setMaxResults(max)
				.setFirstResult(offset).list();
	}

	public void persistir(T objeto) {
		getSession().saveOrUpdate(objeto);
	}

	public void setSessionFactory(SessionFactory sf) {sessionFactory = sf;}

}
