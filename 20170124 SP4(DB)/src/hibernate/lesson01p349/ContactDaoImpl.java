package hibernate.lesson01p349;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("contactDao")
public class ContactDaoImpl implements ContactDao {
	private static final Log LOG = LogFactory.getLog(ContactDaoImpl.class);
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		System.out.println("=========public void setSessionFactory(SessionFactory sessionFactory)");
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Contact> findAll() {
		System.out.println("----------public List<Contact> findAll())");
		return sessionFactory.getCurrentSession().createQuery("from Contact c").list();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Contact> findAllWithDetail() {
		return sessionFactory.getCurrentSession().createNamedQuery("Contact.findAllWithDetail").list();
	}

	@Override
	@Transactional(readOnly = true)
	public Contact findById(Long id) {
		return (Contact) sessionFactory.getCurrentSession().createNamedQuery("Contact.findById").setParameter("id", id).uniqueResult();
	}

	@Override
	public Contact save(Contact contact) {
		sessionFactory.getCurrentSession().saveOrUpdate(contact);
		LOG.info("Contact saved with id = " + contact.getId());
		return contact;
	}

	@Override
	public void delete(Contact contact) {
		sessionFactory.getCurrentSession().delete(contact);
		LOG.info("Contact deleted with id = " + contact.getId());
	}

}
