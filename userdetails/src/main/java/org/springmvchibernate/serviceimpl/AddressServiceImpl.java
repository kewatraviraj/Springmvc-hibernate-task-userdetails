/**
 * 
 */
package org.springmvchibernate.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springmvchibernate.dao.AddressDao;
import org.springmvchibernate.model.Address;
import org.springmvchibernate.service.AddressService;

/**
 * @author Dell
 *
 */
@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	AddressDao addressdao;
	
	/* (non-Javadoc)
	 * @see org.springmvchibernate.service.UserService#listAddressDetails()
	 */
	@Transactional
	@Override
	public List<Address> listAddresses() {
		// TODO Auto-generated method stub
		return addressdao.listsofDetails();
	}

	/* (non-Javadoc)
	 * @see org.springmvchibernate.service.AddressService#fetchAddress(java.lang.Object)
	 */
	@Override
	public Address fetchAddress(Object object) {
		// TODO Auto-generated method stub
		return addressdao.find(object);
	}


}
