package jpa.lesson01p388;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("jpaContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {
	private final String ALL_CONTACT_NATIVE_QUERY = 
			"select id, first_name, last_name, birth_date, version from contact";
	private Log log = LogFactory.getLog(ContactServiceImpl.class);
	@PersistenceContext
	private EntityManager em;
	@Transactional(readOnly = true)
	@Override
	public List<Contact> findAll() {
		return em.createNamedQuery("Contact.findAll", Contact.class).getResultList();
	}
	@Transactional(readOnly = true)
	@Override
	public List<Contact> findAllWithDetail() {
		return em.createNamedQuery("Contact.findAllWithDetail", Contact.class).getResultList();
		}
	@Transactional(readOnly = true)
	@Override
	public Contact findById(Long id) {
		TypedQuery<Contact> typedQuery = em.createNamedQuery("Contact.findById", Contact.class);
		typedQuery.setParameter("id", id);
		return typedQuery.getSingleResult();
	}

	@Override
	public Contact save(Contact contact) {
		if (contact.getId() == null) {
			log.info("Inserting new contact...");
			em.persist(contact);
		}else {
			em.merge(contact);
			log.info("Updating existing contact...");
		}
		log.info("Contact saved with id = " + contact.getId());
		return contact;
	}

	@Override
	public void delete(Contact contact) {
		em.remove(em.merge(contact));
		log.info("Contact with id = " + contact.getId() + " deleted successfully.");
	}
	@Transactional(readOnly = true)
	@Override
	public List<Contact> findAllByNativeQuery() {
		//return em.createNativeQuery(ALL_CONTACT_NATIVE_QUERY, Contact.class).getResultList();
		return em.createNativeQuery(ALL_CONTACT_NATIVE_QUERY, "contactResult").getResultList();
}
	@Override
	public List<Contact> findByCriteriaQuery(String firstName, String lastName) {
		log.info("Finding contact for firstName " + firstName + " and for lastName " + lastName);
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Contact> criteriaQuery = criteriaBuilder.createQuery(Contact.class);
		Root<Contact> root = criteriaQuery.from(Contact.class);
		root.fetch(Contact_.contactTelDetails, JoinType.LEFT);
		root.fetch(Contact_.hobbies, JoinType.LEFT);
		criteriaQuery.select(root).distinct(true);
		Predicate criteria = criteriaBuilder.conjunction();
		if(firstName != null){
			Predicate p = criteriaBuilder.equal(root.get(Contact_.firstName), firstName);
			criteria = criteriaBuilder.and(criteria, p);
		}
		if(lastName != null){
			Predicate p = criteriaBuilder.equal(root.get(Contact_.lastName), lastName);
			criteria = criteriaBuilder.and(criteria, p);
		}
		criteriaQuery.where(criteria);
		return em.createQuery(criteriaQuery).getResultList();
	}

}
