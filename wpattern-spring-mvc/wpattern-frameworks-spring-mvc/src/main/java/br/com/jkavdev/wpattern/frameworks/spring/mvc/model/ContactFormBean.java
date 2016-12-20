package br.com.jkavdev.wpattern.frameworks.spring.mvc.model;

import java.util.List;

import br.com.jkavdev.wpattern.frameworks.spring.mvc.utils.BaseBean;

public class ContactFormBean extends BaseBean {

	private static final long serialVersionUID = 1L;

	private List<ContactBean> contacts;

	public ContactFormBean() {

	}

	public List<ContactBean> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactBean> contacts) {
		this.contacts = contacts;
	}

}
