package jpa.lesson01p388;

import java.util.List;

public interface ContactService {
	public List<Contact> findAll();
	public List<Contact> findAllWithDetail();
	public Contact findById(Long id);
	public Contact save(Contact contact);
	public void delete(Contact contact);
	public List<Contact> findAllByNativeQuery();
	public List<Contact> findByCriteriaQuery(String firstName, String lastName);
}
