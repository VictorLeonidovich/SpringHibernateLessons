package jpa.lesson02p426;

import java.util.List;

public interface ContactService {
	public List<Contact> findAll();
	public List<Contact> findByFirstName(String firstName);
	public List<Contact> findByFirstNameAndLastName(String firstName, String lastName);
}
