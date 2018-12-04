/**
 * 
 */
package org.springmvchibernate.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import org.springmvchibernate.service.UserService;

/**
 * @author Dell
 *
 */
@Controller
@PropertySource("classpath:messages.properties")
@RequestMapping("/")
public class UserRegister {

	private static final Logger _log = Logger.getLogger(UserRegister.class.getName());

	@Autowired
	private Environment environment;

	@Autowired
	private UserService userservice;
	
	private static Set<Address> setofaddress(List<String> operationAddress, List<String> address_id,
			List<String> address_line1, List<String> address_line2, List<String> city, List<String> state,
			List<String> country, List<Integer> pincode) {

		Set<Address> setofaddress = new HashSet<Address>();
		for (int index = 0; index < address_line1.size(); index++) {
			Address address1 = new AnnotationConfigApplicationContext(Address.class).getBean(Address.class);

			if ("updateAddress".equals(operationAddress.get(index))) {
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

	@RequestMapping(value = "/saveorupdate", method = RequestMethod.POST) /* Register or Update User */
	public String save(ModelMap model, HttpSession session, @ModelAttribute User user,
			@RequestPart("image") MultipartFile[] filedata,
			@RequestParam("operation") String operation,
			@RequestParam("operationAddress") List<String> operationAddress,
			@RequestParam("address_id") List<String> address_id,
			@RequestParam("address_line1") List<String> address_line1,
			@RequestParam("address_line2") List<String> address_line2, @RequestParam("city") List<String> city,
			@RequestParam("state") List<String> state, @RequestParam("country") List<String> country,
			@RequestParam("pincode") List<Integer> pincode)
			throws IOException {

		if ("update".equals(operation)) {

			user.setAddress(setofaddress(operationAddress, address_id, address_line1, address_line2, city, state,
					country, pincode));
			User userdata = (User) userservice.fetchUser(user.getUser_id()).iterator().next();
			userdata.merge(user);

			model.addAttribute("messages", (true == userservice.updatedata(userdata)) 
											? environment.getProperty("updatesuccessmessage")
											:environment.getProperty("updateunSuccessmessage"));	
			return "dashboard";
		} else {
			try {
				user.setUser_created_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			} catch (ParseException e) {
				_log.info(e);
			}

			user.setAddress(
					setofaddress(operationAddress, null, address_line1, address_line2, city, state, country, pincode));

			Set<Files> setoffile = new HashSet<Files>();
			if (filedata != null && filedata.length > 0) {
				for (MultipartFile fileContents : filedata) {
					_log.info("Writing File data");
					Files files = new AnnotationConfigApplicationContext(Files.class).getBean(Files.class);
					files.setFile(BlobProxy.generateProxy(fileContents.getBytes()));
					setoffile.add(files);
				}
				user.setFile(setoffile);
			}
			model.addAttribute("messages", (null != userservice.savedata(user)) 
											? environment.getProperty("registerSuccessmessage")
											:environment.getProperty("registerunSuccessmessage"));
			return "requestlogin";
		}
	}
}
