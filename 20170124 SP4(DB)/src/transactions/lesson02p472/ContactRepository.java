package transactions.lesson02p472;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {
	@Query("select count(c) from Contact c")
	public Long countAllContacts();
}
