/**
 * 
 */
package org.springmvchibernate.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
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
@PropertySource("classpath:messages.properties")
@RequestMapping("/")
public class UserController {

	static Logger _log = Logger.getLogger(UserController.class.getName());

	@Autowired
	private Environment environment;

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

	@RequestMapping("/dashboard")
	public String requestdashboard() {
		return "dashboard";
	}

	@RequestMapping("/forgot")
	public String requestforgot() {
		return "forgot";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST) /* Login User */
	public String login(ModelMap model, @RequestParam("userName") String email,
			@RequestParam("passWord") String password, HttpSession session) {

		if (userservice.login(email, password) != false) {
			User user = userservice.userdetails(email);
			session.setAttribute("first_name", user.getFirst_name());
			session.setAttribute("user_id", user.getUser_id());
			session.setAttribute("role_id", user.getRole_id());
			return "dashboard";
		} else {
			model.addAttribute("logincheck", environment.getProperty("logincheck"));
			return "index";
		}
	}

	@RequestMapping(value = "/forgotpass", method = RequestMethod.POST) /* Forgot password */
	public String forgotpassword(@RequestParam("email") String email, ModelMap model) {

		String pass = (String) userservice.forgotPass(email);
		if (null == pass) {
			model.addAttribute("forgotmsg", environment.getProperty("unknownEmailforPass"));
		} else {
			model.addAttribute("forgotmsg", environment.getProperty("getforgotpass") + pass);
		}
		return "forgot";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET) /* Logout User */
	public String logout(HttpSession session) {
		session.removeAttribute("first_name");
		session.removeAttribute("user_id");
		session.removeAttribute("role_id");
		return "index";
	}
	
	private static Set<Address> setofaddress(
			List<String> operationAddress,
			List<String> address_id,
			List<String> address_line1,List<String> address_line2, 
			List<String> city,List<String> state, 
			List<String> country,List<Integer> pincode){
		
		Set<Address> setofaddress = new HashSet<Address>();
		for (int index = 0; index < address_line1.size(); index++) {
			Address address1 = new AnnotationConfigApplicationContext(Address.class).getBean(Address.class);
			
			if("updateAddress".equals(operationAddress.get(index))) {
			address1.setAddress_id(Integer.parseInt(address_id.get(index)));
			}
			address1.setAddress_line1(address_line1.get(index));
			address1.setAddress_line2(address_line2.get(index));
			address1.setCity(city.get(index));
			address1.setCountry(country.get(index));
			address1.setPincode(pincode.get(index));
			address1.setState(state.get(index));
			setofaddress.add(address1);
		}
		return setofaddress;
	}
	
	@RequestMapping(value = "/saveorupdate", method = RequestMethod.POST) /* Registaer User */
	public String save(ModelMap model, HttpSession session,
							@ModelAttribute User user, 
							@RequestParam("operation") String operation,
							@RequestParam("operationAddress") List<String> operationAddress,
							@RequestParam("address_id") List<String> address_id,
							@RequestParam("address_line1") List<String> address_line1,@RequestParam("address_line2") List<String> address_line2, 
							@RequestParam("city") List<String> city,@RequestParam("state") List<String> state, 
							@RequestParam("country") List<String> country,@RequestParam("pincode") List<Integer> pincode, 
							@RequestPart("image") MultipartFile[] filedata) throws IOException {
		
		if("update".equals(operation)) {
			List<Object> users = userservice.fetchUser(user.getUser_id());
			user.setAddress(setofaddress(operationAddress,address_id, address_line1, address_line2, city, state, country, pincode));
			User userdata = null;
			for (Iterator<Object> iterator1 = users.iterator(); iterator1.hasNext();) {
				userdata = (User) iterator1.next();
			}
			userdata.merge(user);
			userservice.updatedata(userdata);
			return "index";
		}else { 
			try {
				user.setUser_created_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			} catch (ParseException e) {
				_log.info(e);
			}
			
		user.setAddress(setofaddress(operationAddress,null, address_line1, address_line2, city, state, country, pincode));

		Set<Files> setoffile = new HashSet<Files>();
		if (filedata != null && filedata.length > 0) {
			for (MultipartFile fileContents : filedata) {
				Files files = new AnnotationConfigApplicationContext(Files.class).getBean(Files.class);
				files.setFile(BlobProxy.generateProxy(fileContents.getBytes()));
				setoffile.add(files);
			}
			user.setFile(setoffile);
		}
		userservice.savedata(user);
		}
		return "index";
	}

	@RequestMapping("/mydetails") /* Get User Own Detail */
	public String myDetails(ModelMap model, HttpSession session) {

		List<Object> users = userservice.fetchUser((Integer) session.getAttribute("user_id"));
		for (Iterator<Object> iterator1 = users.iterator(); iterator1.hasNext();) {
			User user = (User) iterator1.next();
			_log.info("Date Of birth :"+user.getDate_of_birth());
			model.addAttribute("userdetail", user);
			model.addAttribute("addresses", user.getAddress());
			model.addAttribute("files", user.getFile());
			
			/*for (Iterator<Files> iterator2 = user.getFile().iterator(); iterator2.hasNext();) {
			model.addAttribute("filestring", Base64.getEncoder()
												.encodeToString(iterator2.next().getFile()
														.getBytes(1, (int) iterator2.next()
															.getFile().length())));
			}*/
			
		}
		return "register";
	}

	// Set<Address> addresses = user.getAddress();
	// for (Iterator<Address> iterator2 = addresses.iterator();
	// iterator2.hasNext();) {
	// Address address = iterator2.next();
	// }

	@RequestMapping(value = "/display") /* Display Details Admin Panel */
	public String fetch(ModelMap model, @RequestParam("type") String type) throws SQLException {
		if ("User".equals(type)) {
			model.addAttribute("users", userservice.listUsers());
			return "details";
		} else if ("Address".equals(type)) {
			model.addAttribute("addresses", serviceaddress.listAddresses());
			return "addresses";
		} else {
			List<Files> filelist = servicefiles.listFiles();
			for (Iterator<Files> iterator2 = filelist.iterator(); iterator2.hasNext();) {
				model.addAttribute("filestring", Base64.getEncoder().encodeToString(iterator2.next().getFile().getBytes(1, (int) iterator2.next().getFile().length())));
				}
			model.addAttribute("files", filelist);
			return "files";
		}
	}

	@RequestMapping("deleteUser") /* Delete User From Admin Panel */
	public void delete(@RequestParam("user_id") Integer user_id, HttpServletResponse response) {
		response.setContentType("text/plain");
		try {
			java.io.PrintWriter writer = response.getWriter();
			if (userservice.deleteUser(user_id)) {
				writer.print(user_id);
			} else {
				writer.print("fail");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/userdetails") /* Get User Own Detail */
	public String userDetails(ModelMap model,@RequestParam("user_id") Integer user_id, HttpSession session) {

		List<Object> users = userservice.fetchUser(user_id);
		for (Iterator<Object> iterator1 = users.iterator(); iterator1.hasNext();) {
			User user = (User) iterator1.next();
			model.addAttribute("userdetail", user);
			model.addAttribute("addresses", user.getAddress());
			model.addAttribute("files", user.getFile());
		}
		return "register";
	}
}
