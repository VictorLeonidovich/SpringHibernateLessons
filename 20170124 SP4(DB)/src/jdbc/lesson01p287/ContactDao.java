package jdbc.lesson01p287;

import java.util.List;

public interface ContactDao {
	public List<Contact> findAll();
	public List<Contact> findByFirstName(String firstName);
	public String findLastNameById(Long id);
	public String findFirstNameById(Long id);
	public void insert(Contact contact);
	public void update(Contact contact);
	public void delete(Long contactId);


}
