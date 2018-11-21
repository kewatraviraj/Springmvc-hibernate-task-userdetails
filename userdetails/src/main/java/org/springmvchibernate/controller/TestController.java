/**
 * 
 */
package org.springmvchibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Dell
 *
 */
@Controller
@RequestMapping("/a")
public class TestController {

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String sayHello(ModelMap model) {
		model.addAttribute("greeting", "to Hello World from Spring MVC");
		return "welcome";
	}
}
