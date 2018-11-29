package org.springmvchibernate.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

/**
 * @author Dell
 *
 */
@Component
@Entity
public class Files {

	@Id
	@GeneratedValue(generator="native")
	@GenericGenerator(name="native",strategy="native")
	@Column(nullable = false,unique = true) 
	private Integer file_id;
	private String file_type = "image";
	
	@Lob
	@Column(nullable = false) 
	private Blob file;
	
	public Files() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getFile_id() {
		return file_id;
	}

	public void setFile_id(Integer file_id) {
		this.file_id = file_id;
	}

	public String getFile_type() {
		return file_type;
	}

	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}

	public void setFile(Blob file) {
		this.file = file;
	}

	public Blob getFile() {
		return file;
	}

	/*private Calendar file_created_time;
	private Integer file_update_by;
	private Calendar file_update_time;*/

/*	public Integer getFile_update_by() {
		return file_update_by;
	}

	public void setFile_update_by(Integer file_update_by) {
		this.file_update_by = file_update_by;
	}

	public Calendar getFile_created_time() {
		return file_created_time;
	}

	public void setFile_created_time(Calendar file_created_time) {
		this.file_created_time = file_created_time;
	}

	public Calendar getFile_update_time() {
		return file_update_time;
	}	

	public void setFile_update_time(Calendar file_update_time) {
		this.file_update_time = file_update_time;
	}*/

}
