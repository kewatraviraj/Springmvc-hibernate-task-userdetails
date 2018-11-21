/**
 * 
 */
package org.springmvchibernate.daoimpl;

import org.springframework.stereotype.Repository;
import org.springmvchibernate.dao.FilesDao;
import org.springmvchibernate.model.Files;

/**
 * @author Dell
 *
 */
@Repository
public class FilesDaoImpl extends GenericDaoImpl<Files> implements FilesDao {
}
