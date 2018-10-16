package hibernate.lesson01p349;

import java.util.List;

public interface ContactDao {
	public List<Contact> findAll();
	public List<Contact> findAllWithDetail();
	public Contact findById(Long id);
	public Contact save(Contact contact);
	public void delete(Contact contact);

}
