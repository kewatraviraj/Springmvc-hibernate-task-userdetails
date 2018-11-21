/**
 * 
 */
package org.springmvchibernate.daoimpl;

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
	
	/* (non-Javadoc)
	 * @see org.springmvchibernate.dao.UserDao#isValidUser(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean isValidUser(String email, String password) {
		Query query = this.entitymanager.createQuery("SELECT password FROM User where email = :email");
		return password.equals(query.setParameter("email",email).getSingleResult()) ? true : false;
	}

	/* (non-Javadoc)
	 * @see org.springmvchibernate.dao.UserDao#getUserDetails(java.lang.String)
	 */
	@Override
	public User getUserDetails(String email) {
		return (User) this.entitymanager.createQuery("from User where email = :email")
		  								.setParameter("email", email).getResultList().get(0);
	}
}
