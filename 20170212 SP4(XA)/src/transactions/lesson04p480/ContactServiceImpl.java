package transactions.lesson04p480;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("contactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

	@PersistenceContext(unitName = "emfA")
	private EntityManager emA;

	@PersistenceContext(unitName = "emfB")
	private EntityManager emB;

	@Override
	public List<Contact> findAll() {
		return null;
	}

	@Override
	public Contact findById(Long id) {
		return null;
	}

	@Override
	public Contact save(Contact contact) {
		Contact contactB = new Contact();
		contactB.setFirstName(contact.getFirstName());
		contactB.setLastName(contact.getLastName());
		if (contact.getId() == null) {
			emA.persist(contact);
			emB.persist(contactB);
			//throw new JpaSystemException(new PersistenceException());
		} else {
			emA.merge(contact);
			emB.merge(contact);
		}
		return contact;
	}

	@Override
	public Long countAll() {
		return null;
	}

}
