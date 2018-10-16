package jpa.lesson01p388;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("contactSummaryUntype")
@Repository
@Transactional
public class ContactSummaryUntypeImpl {
	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly = true)
	public void displayAllContactSummary() {
		List<?> result = em.createQuery("select c.firstName, c.lastName, t.telNumber"
				+ " from Contact c left join c.contactTelDetails t" + " where t.telType='Home'").getResultList();
		int count = 0;
		for (Iterator iterator = result.iterator(); iterator.hasNext();) {
			Object[] objectValues = (Object[]) iterator.next();
			System.out
					.println(++count + ": " + objectValues[0] 
							+ ", " + objectValues[1] 
									+ ", " + objectValues[2] + ";");
		}
	}
}
