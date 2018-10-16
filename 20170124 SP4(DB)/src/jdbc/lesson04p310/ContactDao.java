package jdbc.lesson04p310;

import java.util.List;

public interface ContactDao {
	public String findLastNameById(Long id);
	public List<Contact> findAll();
}
