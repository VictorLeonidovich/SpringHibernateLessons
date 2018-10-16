package jpa.lesson01p388;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("contactSummaryService")
@Repository
@Transactional
public class ContactSummaryServiceImpl implements ContactSummaryService {
	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly = true)
	@Override
	public List<ContactSummary> findAll() {
		List<ContactSummary> result = em.createQuery("select new jpa.lesson01p388.ContactSummary("
				+ "c.firstName, c.lastName, t.telNumber) "
				+ "from Contact c left join c.contactTelDetails t "
				+ "where t.telType='Home'", ContactSummary.class).getResultList();
		return result;
	}

}
