package jpa.lesson02p426;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface ContactRepository extends CrudRepository<Contact, Long> {
	public List<Contact> findByFirstName(String firstName);
	public List<Contact> findByFirstNameAndLastName(String firstName, String lastName);

}
