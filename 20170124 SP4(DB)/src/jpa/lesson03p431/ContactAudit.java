package jpa.lesson03p431;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.domain.Auditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
//@EntityListeners(AuditingEntityListener.class)
@Table(name = "contact_audit")
public class ContactAudit implements Auditable<String, Long>, Serializable {
	private Long id;
	private int version;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String createdBy;
	private DateTime createdDate;
	private String lastModifiedBy;
	private DateTime lastModifiedDate;

	@Version
	@Column(name = "VERSION")
	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME")
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTH_DATE")
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@Override
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Transient
	@Override
	public boolean isNew() {
		if (id == null) {
			return true;
		} else {
			return false;
		}
	}

	@Column(name = "CREATED_BY")
	@Override
	public String getCreatedBy() {
		return this.createdBy;
	}

	@Column(name = "CREATED_DATE")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Override
	public DateTime getCreatedDate() {
		return this.createdDate;
	}

	@Column(name = "LAST_MODIFIED_BY")
	@Override
	public String getLastModifiedBy() {
		return this.lastModifiedBy;
	}

	@Column(name = "LAST_MODIFIED_DATE")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Override
	public DateTime getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	@Override
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	@Override
	public void setLastModifiedDate(DateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public String toString() {
		return "ContactAudit [id=" + id + ", version=" + version + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthDate=" + birthDate + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedDate=" + lastModifiedDate + "]";
	}

}
