package transactions.lesson04p480;

import java.util.List;

public interface ContactService {
	public List<Contact> findAll();
	public Contact findById(Long id);
	public Contact save(Contact contact);
	public Long countAll();
}
