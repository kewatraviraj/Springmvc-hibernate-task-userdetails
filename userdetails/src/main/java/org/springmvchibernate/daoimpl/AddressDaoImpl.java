/**
 * 
 */
package org.springmvchibernate.daoimpl;

import org.springframework.stereotype.Repository;
import org.springmvchibernate.dao.AddressDao;
import org.springmvchibernate.model.Address;

/**
 * @author Dell
 *
 */
@Repository
public class AddressDaoImpl extends GenericDaoImpl<Address> implements AddressDao {
	
	/*List<Address> fetchAddressOfUser() {
		return this.entitymanager.createQuery("select from Address").getResultList();
	}*/
}
