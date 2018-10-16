package jpa.lesson03p431;

import java.util.List;

public interface ContactAuditService {
	public List<ContactAudit> findAll();

	public ContactAudit findById(Long id);

	public ContactAudit save(ContactAudit contact);

}
