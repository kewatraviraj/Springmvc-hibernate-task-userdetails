/**
 * 
 */
package org.springmvchibernate.service;

import java.util.List;

import org.springmvchibernate.model.Address;

/**
 * @author Dell
 *
 */
public interface AddressService {
	List<Address> listAddresses();

	/**
	 * @param attribute
	 * @return
	 */
//	Address fetchAddress(Object attribute);
}
