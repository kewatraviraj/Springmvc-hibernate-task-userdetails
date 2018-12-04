package org.springmvchibernate.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springmvchibernate.model.Files;
import org.springmvchibernate.model.User;
import org.springmvchibernate.service.AddressService;
import org.springmvchibernate.service.FilesService;
import org.springmvchibernate.service.UserService;

@Controller
@PropertySource("classpath:messages.properties")
@RequestMapping("/")
public class UserAction {

	private static final Logger _log = Logger.getLogger(UserAction.class.getName());

	@Autowired
	private Environment environment;

	@Autowired
	private UserService userservice;

	@Autowired
	private AddressService serviceaddress;

	@Autowired
	private FilesService servicefiles;
	
	@RequestMapping({ "/index", "/requestlogin", "/register", "/dashboard", "/forgot","/error" })
	public String requestindex(HttpServletRequest request) {
		_log.info("Requested Url :" + request.getServletPath());
		_log.info("Requested Url Context :" + request.getContextPath());
		return request.getServletPath();
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST) /*	Login User	 */
	public String login(ModelMap model, @RequestParam("userName") String email,
			@RequestParam("passWord") String password, HttpSession session) {
		
		_log.info("User Try to Login With email :" + email);
		if (false != userservice.login(email, password)) {
			User user = userservice.userdetails(email);
			session.setAttribute("first_name", user.getFirst_name());
			session.setAttribute("user_id", user.getUser_id());
			session.setAttribute("role_id", user.getRole_id());
			return "dashboard";
		} else {
			model.addAttribute("messages", environment.getProperty("logincheck"));
			return "requestlogin";
		}
	}

	@RequestMapping(value = "/forgotpass", method = RequestMethod.POST) /*	Forgot password 	*/ 
	public String forgotpassword(@RequestParam("email") String email, ModelMap model) {

		String pass = (String) userservice.forgotPass(email);
		model.addAttribute("forgotmsg", null == pass ? environment.getProperty("unknownEmailforPass")
													:environment.getProperty("getforgotpass") + pass);
		return "forgot";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET) /*	Logout User		*/
	public String logout(HttpSession session) {
		session.removeAttribute("first_name");
		session.removeAttribute("user_id");
		session.removeAttribute("role_id");
		return "requestlogin";
	}
	
	@RequestMapping("/mydetails") /* Get User Own Detail */
	public String myDetails(ModelMap model, HttpSession session) {
		return users(model, (Integer) session.getAttribute("user_id"));
	}

	@RequestMapping("/userdetails") /* Get User Details */
	public String userDetails(ModelMap model, @RequestParam("user_id") Integer user_id) {
		return users(model, user_id);
	}

	private String users(ModelMap model, Integer user_id) {		/*  Fetch User all Details*/
		List<Object> users = userservice.fetchUser(user_id);
		for (Iterator<Object> iterator1 = users.iterator(); iterator1.hasNext();) {
			User user = (User) iterator1.next();
			model.addAttribute("userdetail", user);
			model.addAttribute("addresses", user.getAddress());
			model.addAttribute("files", user.getFile());
		}
		return "register";
	}
	
	@RequestMapping(value = "/display") /* Display Details Admin Panel */
	public String fetch(ModelMap model, @RequestParam("type") String type) throws SQLException {
		if ("User".equals(type)) {
			model.addAttribute("users", userservice.listUsers());
			return "details";
		} else if ("Address".equals(type)) {
			model.addAttribute("addresses", serviceaddress.listAddresses());
			return "addresses";
		} else if("Files".equals(type)){
			List<Files> filelist = servicefiles.listFiles();
			List<String> filestring = new ArrayList<String>();
			for (Iterator<Files> iterator2 = filelist.iterator(); iterator2.hasNext();) {
				Blob filedata = iterator2.next().getFile();
				filestring.add( Base64.getEncoder().encodeToString(filedata.getBytes(1, (int) filedata.length())));
			}
			model.addAttribute("files", filelist);
			model.addAttribute("filestring",filestring);
			return "files";
		} else {
			return "error";
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
	
	@RequestMapping({"/*"})
	public String requests(HttpServletRequest request) {
		return "redirect:/error";
	}
	
	/*	@RequestMapping(value = "/forgotpass", method = RequestMethod.POST)  Forgot password 
	public void forgotpwd(@RequestBody User user,HttpServletResponse response) {
		response.setContentType("text/plain");
		String pass = (String) userservice.forgotPass(user.getEmail());
		java.io.PrintWriter writer;
		try {
			writer = response.getWriter();
			if (null == pass) {
				writer.print(environment.getProperty("unknownEmailforPass"));
			} else {
				writer.print(environment.getProperty("getforgotpass") + pass);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	/*	@RequestMapping({"/*"})
	public String requests(HttpServletRequest request) {
		""+request.getRequestURL().toString().replace(request.getServletPath(), "")+
		return "error";
	}*/
	
	/*@RequestMapping(value = {"{path:(?!webjars|static).*$}","{path:(?!webjars|static).*$}/**"},headers="Accept=text/html")
	public String requests(HttpServletRequest request) {
		return "error";
	}*/
}
