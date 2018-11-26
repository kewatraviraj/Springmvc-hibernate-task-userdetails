/**
 * 
 */
package org.springmvchibernate.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springmvchibernate.dao.FilesDao;
import org.springmvchibernate.model.Files;
import org.springmvchibernate.service.FilesService;

/**
 * @author Dell
 *
 */
@Service
public class FilesServiceImpl implements FilesService {
	
	@Autowired
	FilesDao filesdao;
	
	
	/* (non-Javadoc)
	 * @see org.springmvchibernate.service.UserService#listFileDetails()
	 */
	@Transactional
	@Override
	public List<Files> listFiles() {
		// TODO Auto-generated method stub
		return filesdao.listsofDetails();
	}


	/* (non-Javadoc)
	 * @see org.springmvchibernate.service.FilesService#fetchFiles(java.lang.Object)
	 */
/*	@Override
	public Files fetchFiles(Object object) {
		// TODO Auto-generated method stub
		return filesdao.find(object);
	}
*/
}
