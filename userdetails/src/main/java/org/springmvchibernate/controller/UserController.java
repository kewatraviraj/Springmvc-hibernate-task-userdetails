/**
 * 
 */
package org.springmvchibernate.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springmvchibernate.model.Address;
import org.springmvchibernate.model.Files;
import org.springmvchibernate.model.User;
import org.springmvchibernate.service.AddressService;
import org.springmvchibernate.service.FilesService;
import org.springmvchibernate.service.UserService;

/**
 * @author Dell
 *
 */
@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	User user;

	@Autowired
	Address address;

	@Autowired
	Files file;

	@Autowired
	UserService userservice;

	@Autowired
	AddressService serviceaddress;

	@Autowired
	FilesService servicefiles;

	@RequestMapping("/requestregister")
	public String request() {
		return "register";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("userName") String email, @RequestParam("passWord") String password,
			HttpSession session) {

		if (userservice.login(email, password) != false) {
			User user = userservice.userdetails(email);
			session.setAttribute("first_name", user.getFirst_name());
			session.setAttribute("user_id", user.getUser_id());
			session.setAttribute("role_id", user.getRole_id());
			return "dashboard";
		} else {
			return "index";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("first_name");
		session.removeAttribute("user_id");
		session.removeAttribute("role_id");
		return "index";
	}

	@RequestMapping(value = "/display")
	public String fetch(ModelMap model, @RequestParam("type") String type) {
		if ("User".equals(type)) {
			model.addAttribute("users", userservice.listUsers());
			return "details";
		} else if ("Address".equals(type)) {
			model.addAttribute("addresses", serviceaddress.listAddresses());
			return "addresses";
		} else {
			model.addAttribute("files", servicefiles.listFiles());
			return "files";
		}
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(ModelMap model, @ModelAttribute User user, @ModelAttribute Address address, @ModelAttribute Files file 
			/*@RequestParam("address_line1") List<String> address_line1,
			@RequestParam("address_line2") List<String> address_line2,
			@RequestParam("city") List<String> city,
			@RequestParam("state") List<String> state,
			@RequestParam("country") List<String> country,
			@RequestParam("pincode") List<Integer> pincode			
			*/) {
		
		Set<Address> setofaddress = new HashSet<Address>();
		
		/*List<Address> list = java.util.Arrays.asList(address);
		System.out.println(user.getAddress());
		System.out.println(address.getAddress_line1());
		System.out.println(list.toString().trim());
		
		*/
		setofaddress.add(address);
		/*for (int index = 0; index < address_line1.size(); index++) {
			
			address.setAddress_line1(address_line1.get(index));
			address.setAddress_line2(address_line2.get(index));
			address.setCity(city.get(index));
			address.setCountry(country.get(index));
			address.setPincode(pincode.get(index));
			address.setState(state.get(index));
			
			setofaddress.add(address);
			System.out.println(address);
		}*/
		user.setAddress(setofaddress);
	
		/*Set<Files> setoffile = new HashSet<Files>();
		
		 * try { file.setFile(BlobProxy.generateProxy(filedata.getBytes())); } catch
		 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }

			setoffile.add(file);
			user.setFile(setoffile);
		 */

		userservice.savedata(user);
		return "index";
	}
	
	@RequestMapping("/mydetails")
	public String myDetails(ModelMap model, HttpSession session) {
		model.addAttribute("userdetail", userservice.fetchUser(session.getAttribute("user_id")));
		model.addAttribute("addresses", serviceaddress.fetchAddress(session.getAttribute("user_id")));
	/*	model.addAttribute("addresses", servicefiles.fetchFiles(session.getAttribute("user_id")));
	*/	return "register";
	}
	
	@RequestMapping("deleteUser")
	public void delete(@RequestParam("user_id") Integer user_id,HttpServletResponse response) {
		response.setContentType("text/plain");
		try {
			java.io.PrintWriter writer = response.getWriter();
			if(userservice.deleteUser(user_id)) {
				writer.print(user_id);
			}else {
				writer.print("fail");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
