package org.springmvchibernate.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Component
@Entity
public class User {

	@Id
	@GeneratedValue(generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(nullable = false, unique = true)
	private Integer user_id;

	@Temporal(value = TemporalType.DATE)
	private Date date_of_birth;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String first_name;
	@Column(nullable = false)
	private String gender;
	private String last_name;
	private Long mobile_no;
	@Column(nullable = false)
	private String password;
	private Integer role_id = 2;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private Set<Address> address;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "file_map", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "file_id") })
	private Set<Files> file;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date user_created_time;

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

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> setofaddress) {
		this.address = setofaddress;
	}

	public Set<Files> getFile() {
		return file;
	}

	public void setFile(Set<Files> file) {
		this.file = file;
	}

	public String getDate_of_birth() {
		return new SimpleDateFormat("yyyy-MM-dd").format(date_of_birth);
	}

	public void setDate_of_birth(String date_of_birth) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		this.date_of_birth = (Date) df.parse(date_of_birth);
	}


	public String getUser_created_time() {
		return user_created_time.toString();
	}

	public void setUser_created_time(String user_created_time) throws ParseException {
		this.user_created_time = (Date) new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
				.parse(user_created_time);
	}

	public void merge(User other) {
		this.user_id = other.user_id == null ? this.user_id : other.user_id;
		this.email = other.email == null ? this.email : other.email;
		this.first_name = other.first_name == null ? this.first_name : other.first_name;
		this.gender = other.gender == null ? this.gender : other.gender;
		this.last_name = other.last_name == null ? this.last_name : other.last_name;
		this.mobile_no = other.mobile_no == null ? this.mobile_no : other.mobile_no;
		this.password = other.password == null ? this.password : other.password;
		this.role_id = other.role_id == null ? this.role_id : other.role_id;
		this.date_of_birth = other.date_of_birth == null ? this.date_of_birth : other.date_of_birth;
		this.user_created_time = other.user_created_time == null ? this.user_created_time : other.user_created_time;
		this.address = other.address == null ? this.address : other.address;
		for (Iterator<Address> address_user_id = this.address.iterator(); address_user_id.hasNext();) {
			address_user_id.next().setUser_id(this.user_id);
		}
		this.file = other.file == null ? this.file : other.file;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", date_of_birth=" + date_of_birth + ", email=" + email + ", first_name="
				+ first_name + ", gender=" + gender + ", last_name=" + last_name + ", mobile_no=" + mobile_no
				+ ", password=" + password + ", role_id=" + role_id + ", address=" + address + ", file=" + file
				+ ", user_created_time=" + user_created_time + "]";
	}

	/*
	 * private Integer user_update_by; private Calendar user_update_time;
	 */
	/*
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

}
