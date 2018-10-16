package transactions.lesson03p475;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.google.common.collect.Lists;

@Service("contactService")
@Repository
public class ContactServiceImpl implements ContactService {

	private ContactRepository contactRepository;
	private TransactionTemplate transactionTemplate;
	@PersistenceContext
	private EntityManager em;

	@Autowired
	public void setContactRepository(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

	@Autowired
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
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
		return transactionTemplate.execute(new TransactionCallback<Long>() {

			@Override
			public Long doInTransaction(TransactionStatus transactionStatus) {
				return em.createNamedQuery("Contact.countAll", Long.class).getSingleResult();
			}
		});
	}

}
