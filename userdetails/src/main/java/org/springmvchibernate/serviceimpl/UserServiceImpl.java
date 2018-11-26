/**
 * 
 */
package org.springmvchibernate.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springmvchibernate.dao.UserDao;
import org.springmvchibernate.model.User;
import org.springmvchibernate.service.UserService;

/**
 * @author Dell
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userdao;
	
	/* (non-Javadoc)
	 * @see org.springmvchibernate.service.UserService#login()
	 */
	@Transactional
	@Override
	public boolean login(String email,String password) {
		return userdao.isValidUser(email, password);
	}

	@Transactional
	@Override
	public Object forgotPass(String email) {
		return userdao.forgotpwd(email);
	}
	
	/* (non-Javadoc)
	 * @see org.springmvchibernate.service.UserService#savedata(org.springmvchibernate.model.User)
	 */
	@Transactional
	@Override
	public void savedata(User user) {
		userdao.create(user);
	}


	/* (non-Javadoc)
	 * @see org.springmvchibernate.service.UserService#userdetails(java.lang.String)
	 */
	@Transactional
	@Override
	public User userdetails(String email) {
		return userdao.getUserDetails(email);
	}

	/* (non-Javadoc)
	 * @see org.springmvchibernate.service.UserService#listdetails()
	 */
	@Transactional
	@Override
	public List<User> listUsers() {
		// TODO Auto-generated method stub
		return userdao.listsofDetails();
	}


	/* (non-Javadoc)
	 * @see org.springmvchibernate.service.UserService#deleteUser(java.lang.Integer)
	 */
	@Transactional
	@Override
	public boolean deleteUser(Integer user_id) {
		try { 
				userdao.delete(user_id);
				return true;
			}catch (HibernateException e) {
				e.printStackTrace();
				return false;
			}
	}

	/* (non-Javadoc)
	 * @see org.springmvchibernate.service.UserService#fetch(java.lang.Object)
	 */
	@Override
	public List<Object> fetchUser(Integer object) {
		// TODO Auto-generated method stub
		return userdao.listsofUserDetails(object);
	}
}

