package jpa.lesson04p440;

import org.springframework.data.repository.CrudRepository;

public interface ContactAuditRepository extends CrudRepository<ContactAudit, Long> {

}
