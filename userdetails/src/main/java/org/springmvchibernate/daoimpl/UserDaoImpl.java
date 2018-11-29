/**
 * 
 */
package org.springmvchibernate.daoimpl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springmvchibernate.dao.UserDao;
import org.springmvchibernate.model.User;

/**
 * @author Dell
 *
 */
@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springmvchibernate.dao.UserDao#isValidUser(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean isValidUser(String email, String password) {
		try {
			Query query = this.entitymanager.createQuery("SELECT password FROM User where email = :email");
			return password.equals(query.setParameter("email", email).getSingleResult()) ? true : false;

		} catch (NoResultException e) {
			return false;
		}
	}

	@Override
	public Object forgotpwd(String email) {
		try {
			Query query = this.entitymanager.createQuery("SELECT password FROM User where email = :email");
			return query.setParameter("email", email).getSingleResult();

		} catch (NoResultException e) {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springmvchibernate.dao.UserDao#getUserDetails(java.lang.String)
	 */
	@Override
	public User getUserDetails(String email) {
		return (User) this.entitymanager.createQuery("from User where email = :email").setParameter("email", email)
				.getResultList().get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springmvchibernate.dao.UserDao#listsofUserDetails(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> listsofUserDetails(Integer object) {
		return this.entitymanager.createQuery("from User u where u.user_id = :user_id").setParameter("user_id", object)
				.getResultList();
	}

}
