package jpa.lesson04p440;

import java.util.List;

public interface ContactAuditService {
	public List<ContactAudit> findAll();

	public ContactAudit findById(Long id);

	public ContactAudit save(ContactAudit contact);
	
	public ContactAudit findAuditByRevision(Long id, int revision);

}
