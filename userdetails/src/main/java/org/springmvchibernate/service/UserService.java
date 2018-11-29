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

	Object forgotPass(String email);

	User userdetails(String email);

	User savedata(User user);
	
	boolean updatedata(User user);
	
	List<User> listUsers();

	boolean deleteUser(Integer user_id);

	List<Object> fetchUser(Integer object);
}
