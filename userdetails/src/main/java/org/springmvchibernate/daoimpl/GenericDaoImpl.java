/**
 * 
 */
package org.springmvchibernate.daoimpl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.exception.ConstraintViolationException;
import org.springmvchibernate.dao.GenericDao;

/**
 * @author Dell
 *
 */

public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	@PersistenceContext 
	protected EntityManager entitymanager;
	
	private Class<T> classtype;
	
	public GenericDaoImpl() {
		Type typ = getClass().getGenericSuperclass();
		ParameterizedType paratype = (ParameterizedType) typ;
		classtype = (Class) paratype.getActualTypeArguments()[0];
	}

	@Override
	public long countAll(final Map<String, Object> params) {

		final StringBuffer queryString = new StringBuffer("SELECT count(o) from ");
		queryString.append(classtype.getSimpleName()).append(" o ");
		// queryString.append(this.getQueryClauses(params, null));

		final Query query = this.entitymanager.createQuery(queryString.toString());
		return (Long) query.getSingleResult();
	}

	@Override
	public T create(final T typ) {
		try {
			this.entitymanager.persist(typ);
			return typ;
		 }catch (RuntimeException ex) {
	        return null;
	    }
	}

	@Override
	public void delete(final Object id) {
		this.entitymanager.remove(this.entitymanager.getReference(classtype, id));
	}

	@Override
	public T find(final Object id) {
		return (T) this.entitymanager.find(classtype, id);
	}

	@Override
	public T update(final T typ) {
		try {
			return (T) this.entitymanager.merge(typ);
		}catch(ConstraintViolationException e){
			throw e;
		}
	}

	@Override
	public List<T> listsofDetails() {
		return this.entitymanager.createQuery("SELECT d FROM "+classtype.getName()+" d").getResultList();	
	}

}