/**
 * 
 */
package org.springmvchibernate.service;

import java.util.List;

import org.springmvchibernate.model.User;

/**
 * @author Dell
 *
 */
public interface UserService {
	
	/**
	 * @param email
	 * @param password
	 * @return
	 */
	boolean login(String email, String password);
	User userdetails(String email);
	void savedata(User user);
	List<User> listUsers();
	boolean deleteUser(Integer user_id);
	User fetchUser(Object object);
}
