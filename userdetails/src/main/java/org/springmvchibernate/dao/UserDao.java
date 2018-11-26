/**
 * 
 */
package org.springmvchibernate.dao;

import java.util.List;

import org.springmvchibernate.model.User;

/**
 * @author Dell
 *
 */
public interface UserDao extends GenericDao<User> {
	
	boolean isValidUser(String email, String password);

	Object forgotpwd(String email);

	User getUserDetails(String email);

	/**
	 * @param object
	 * @return
	 */
	List<Object> listsofUserDetails(Integer object);
}
