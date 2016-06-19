package com.contacts.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenerationTime;
import org.hibernate.validator.constraints.Email;

/**
 * @author megha
 *
 */
@Entity
@Table(name = "contactss")
public class Contact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1767826428798909234L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "ID", nullable = false)
	private long id;

	@NotNull
	@Column(name = "NAME", nullable = false)
	private String name;

	@NotNull
	@Column(name = "EMAIL", nullable = false)
	@Email
	private String email;

	@NotNull
	@Column(name = "PROFESSION", nullable = false)
	private String profession;

	@Column(name = "DATE_CREATED", insertable = false, updatable = false, columnDefinition = "datetime default current_timestamp")
	@org.hibernate.annotations.Generated(value = GenerationTime.INSERT)
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date created;

	public Contact() {
		super();
	}

	public Contact(long id) {
		this.id = id;
	}

	public Contact(String name, String email, String profession) {
		this.name = name;
		this.email = email;
		this.profession = profession;
		this.created = new Date();
	}

	@PrePersist
	protected void onCreate() {
		created = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "id='" + id + '\'' + ", name='" + name + '\'' + ", email='" + email + '\''
				+ ", profession='" + profession + '\'' + ", createdOn='" + created;
	}

}
