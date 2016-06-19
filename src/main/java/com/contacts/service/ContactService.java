package com.contacts.service;

import java.util.List;

import com.contacts.domain.Contact;

/**
 * @author megha
 *
 */
public interface ContactService {
	public Contact save(Contact contact);

	public Contact update(Contact contact, long id);

	public void delete(long id);

	public List<Contact> findAll(int pageNum, int pageSize, boolean orderByAsc);

	public List<Contact> findWithCriteria(int pageNum, int pageSize, boolean orderByAsc, String profession);
}
