package br.com.jkavdev.wpattern.frameworks.spring.mvc.model;

import java.util.ArrayList;
import java.util.List;

public class Dataset {

	private static List<ContactBean> contacts = new ArrayList<>();

	private static int id = 0;

	static {
		contacts.add(new ContactBean(id++, "jhonatan", "kolen", "jhonatan@gmail.com", "99346554"));
		contacts.add(new ContactBean(id++, "lucas", "alves", "lucas@gmail.com", "99346554"));
		contacts.add(new ContactBean(id++, "douglas", "alves", "douglas@gmail.com", "99346554"));
		contacts.add(new ContactBean(id++, "maria", "helena", "maria@gmail.com", "99346554"));
	}

	public static List<ContactBean> getContacts() {
		return contacts;
	}

	public static void setContacts(List<ContactBean> contacts) {
		Dataset.contacts = contacts;
	}

	public static void addContact(ContactBean contact) {
		contact.setId(id++);
		contacts.add(contact);
	}

	public static void updateContact(ContactBean contact) {
		for (int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i).getId() == contact.getId()) {
				contacts.set(i, contact);
			}
		}
	}

}
