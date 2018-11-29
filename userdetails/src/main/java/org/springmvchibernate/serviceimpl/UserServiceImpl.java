/**
 * 
 */
package org.springmvchibernate.serviceimpl;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
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

	private static final Logger _log = Logger.getLogger(UserServiceImpl.class.getName());

	@Autowired
	UserDao userdao;

	/*
	 * (non-Javadoc)
	 * @see org.springmvchibernate.service.UserService#login()
	 */
	@Transactional
	@Override
	public boolean login(String email, String password) {
		return userdao.isValidUser(email, password);
	}

	@Transactional
	@Override
	public Object forgotPass(String email) {
		return userdao.forgotpwd(email);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.springmvchibernate.service.UserService#savedata(org.springmvchibernate.
	 * model.User)
	 */
	@Transactional
	@Override
	public User savedata(User user) {
		User usertype = userdao.create(user);
		return usertype;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springmvchibernate.service.UserService#userdetails(java.lang.String)
	 */
	@Transactional
	@Override
	public User userdetails(String email) {
		return userdao.getUserDetails(email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springmvchibernate.service.UserService#listdetails()
	 */
	@Transactional
	@Override
	public List<User> listUsers() {
		return userdao.listsofDetails();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springmvchibernate.service.UserService#deleteUser(java.lang.Integer)
	 */
	@Transactional
	@Override
	public boolean deleteUser(Integer user_id) {
		try {
			userdao.delete(user_id);
			return true;
		} catch (HibernateException e) {
			_log.error(e);
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springmvchibernate.service.UserService#fetch(java.lang.Object)
	 */
	@Override
	public List<Object> fetchUser(Integer object) {
		return userdao.listsofUserDetails(object);
	}

	@Transactional
	@Override
	public boolean updatedata(User user) {
		try{
			userdao.update(user);
			return true;
		}catch (PersistenceException e) {
			_log.info(e);
	       return false;
	    }
	}
}
