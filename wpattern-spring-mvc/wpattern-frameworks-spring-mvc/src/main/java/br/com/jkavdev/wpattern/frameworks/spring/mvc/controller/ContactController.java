package br.com.jkavdev.wpattern.frameworks.spring.mvc.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.jkavdev.wpattern.frameworks.spring.mvc.model.ContactFormBean;
import br.com.jkavdev.wpattern.frameworks.spring.mvc.model.Dataset;

@Controller
@RequestMapping("/contact")
public class ContactController {

	private static final Logger logger = Logger.getLogger(ContactController.class);

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {
		if (logger.isInfoEnabled()) {
			logger.info("List all contacts");
		}

		ContactFormBean contactForm = new ContactFormBean();
		contactForm.setContacts(Dataset.getContacts());

		return new ModelAndView("/contact/list", "contactForm", contactForm);
	}

}
