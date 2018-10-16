package jpa.lesson03p431;

import org.springframework.data.repository.CrudRepository;

public interface ContactAuditRepository extends CrudRepository<ContactAudit, Long> {

}
