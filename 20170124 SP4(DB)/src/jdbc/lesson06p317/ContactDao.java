package jdbc.lesson06p317;

import java.util.List;

public interface ContactDao {
	public List<Contact> findAll();
	public List<Contact> findByFirstName(String firstName);
	public String findLastNameById(Long id);
	public List<Contact> findAllWithDetail();
	public void insert(Contact contact);
	public void insertWithDetail(Contact contact);
	public void update(Contact contact);
}
