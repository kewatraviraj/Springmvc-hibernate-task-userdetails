package org.springmvchibernate.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Component
@Entity
public class User {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Integer user_id;

	// private Date date_of_birth;
	private String email;
	private String first_name;
	private String gender;
	private String last_name;
	private Long mobile_no;
	private String password;
	private Integer role_id = 2;

	/*
	 * private Calendar user_created_time; private Integer user_update_by; private
	 * Calendar user_update_time;
	 */

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private Set<Address> address;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "file_map", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "file_id") })
	private Set<Files> file;

	/*
	 * @Override public String toString() { return "User [user_id=" + user_id +
	 * ", role_id=" + role_id + ", first_name=" + first_name + ", last_name=" +
	 * last_name + ", email=" + email + ", mobile_no=" + mobile_no + ", password=" +
	 * password + ", gender=" + gender + ", date_of_birth=" + date_of_birth +
	 * ", user_created_time=" + user_created_time + ", user_update_by=" +
	 * user_update_by + ", user_update_time=" + user_update_time + ", address=" +
	 * address + ", file=" + file + "]"; }
	 */

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Long getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(Long mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * public Calendar getUser_created_time() { return user_created_time; }
	 * 
	 * public void setUser_created_time(Calendar user_created_time) {
	 * this.user_created_time = user_created_time; }
	 * 
	 * public Integer getUser_update_by() { return user_update_by; }
	 * 
	 * public void setUser_update_by(Integer user_update_by) { this.user_update_by =
	 * user_update_by; }
	 * 
	 * public Calendar getUser_update_time() { return user_update_time; }
	 * 
	 * public void setUser_update_time(Calendar user_update_time) {
	 * this.user_update_time = user_update_time; }
	 */

	public Set<Files> getFile() {
		return file;
	}

	public void setFile(Set<Files> file) {
		this.file = file;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", email=" + email + ", first_name=" + first_name + ", gender=" + gender
				+ ", last_name=" + last_name + ", mobile_no=" + mobile_no + ", password=" + password + ", role_id="
				+ role_id + ", address=" + address + ", file=" + file + "]";
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> setofaddress) {
		this.address = setofaddress;
	}

	/*
	 * public Calendar getDate_of_birth() { return date_of_birth; }
	 * 
	 * public void setDate_of_birth(Calendar date_of_birth) { this.date_of_birth =
	 * date_of_birth; }
	 */

}
