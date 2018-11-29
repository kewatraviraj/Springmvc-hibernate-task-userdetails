package org.springmvchibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Address {
	
	@Id
	@GeneratedValue(generator="native")
	@GenericGenerator(name="native",strategy="native")
	@Column(nullable = false,unique = true) 
	private Integer address_id;
	
	@Column(nullable = false) 
	private String address_line1;
	private String address_line2;
	@Column(nullable = false) 
	private String city;
	@Column(nullable = false) 
	private String country;
	@Column(nullable = false) 
	private Integer pincode;
	@Column(nullable = false) 
	private String state;
	
	private Integer user_id;
	/**
	 * 
	 */
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getAddress_id() {
		return address_id;
	}
	
	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}

	public String getAddress_line1() {
		return address_line1;
	}

	public void setAddress_line1(String address_line1) {
		this.address_line1 = address_line1;
	}

	public String getAddress_line2() {
		return address_line2;
	}

	public void setAddress_line2(String address_line2) {
		this.address_line2 = address_line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", address_line1=" + address_line1 + ", address_line2="
				+ address_line2 + ", city=" + city + ", country=" + country + ", pincode=" + pincode + ", state="
				+ state + ", user_id=" + user_id + "]";
	}

	/*private Calendar address_created_time;
	private Integer address_update_by;
	private Calendar address_update_time;
	*/
	
/*	public Integer getAddress_update_by() {
		return address_update_by;
	}

	public void setAddress_update_by(Integer address_update_by) {
		this.address_update_by = address_update_by;
	}
		
	public Calendar getAddress_created_time() {
		return address_created_time;
	}
	
	public void setAddress_created_time(Calendar address_created_time) {
		this.address_created_time = address_created_time;
	}
	
	public Calendar getAddress_update_time() {
		return address_update_time;
	}
	
	public void setAddress_update_time(Calendar address_update_time) {
		this.address_update_time = address_update_time;
	}
*/
}
