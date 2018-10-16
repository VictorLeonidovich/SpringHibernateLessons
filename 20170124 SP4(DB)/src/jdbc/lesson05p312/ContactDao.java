package jdbc.lesson05p312;

import java.util.List;

public interface ContactDao {
	public String findLastNameById(Long id);
	public List<Contact> findAll();
	public List<Contact> findAllWithDetail();
}
