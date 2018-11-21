/**
 * 
 */
package org.springmvchibernate.dao;

import java.util.List;
import java.util.Map;

/**
 * @author Dell
 *
 */
public interface GenericDao<T> {
    
    long countAll(Map<String, Object> params);

    T create(T t);

    void delete(Object id);

    T find(Object id);

    T update(T t);  
    
    List<T> listsofDetails();
}
