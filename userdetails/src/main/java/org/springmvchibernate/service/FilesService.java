/**
 * 
 */
package org.springmvchibernate.service;

import java.util.List;

import org.springmvchibernate.model.Files;

/**
 * @author Dell
 *
 */
public interface FilesService {
	List<Files> listFiles();

	/**
	 * @param attribute
	 * @return
	 */
	Files fetchFiles(Object attribute);
}
