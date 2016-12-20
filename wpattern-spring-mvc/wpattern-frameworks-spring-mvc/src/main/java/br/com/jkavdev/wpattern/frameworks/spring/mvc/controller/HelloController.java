package br.com.jkavdev.wpattern.frameworks.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping("/controller")
	public ModelAndView hello() {
		String message = "Welcome to Spring MVC";
		
		return new ModelAndView("/hello/view", "message", message);
	}

}
