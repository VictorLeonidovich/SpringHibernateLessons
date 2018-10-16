package transactions.lesson02p472;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

@Service("contactService")
@Repository
public class ContactServiceImpl implements ContactService {
	
	private ContactRepository contactRepository;
	@Autowired
	public void setContactRepository(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}
	@Override
	public List<Contact> findAll() {
		return Lists.newArrayList(contactRepository.findAll());
	}
	@Override
	public Contact findById(Long id) {
		return contactRepository.findOne(id);
	}
	@Override
	public Contact save(Contact contact) {
		return contactRepository.save(contact);
	}
	@Override
	public Long countAll() {
		return contactRepository.countAllContacts();
	}

}
