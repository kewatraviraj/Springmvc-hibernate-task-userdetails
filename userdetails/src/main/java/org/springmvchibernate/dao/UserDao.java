/**
 * 
 */
package org.springmvchibernate.dao;

import org.springmvchibernate.model.User;

/**
 * @author Dell
 *
 */
public interface UserDao extends GenericDao<User> {
	boolean isValidUser(String email, String password);
	User getUserDetails(String email);
}
