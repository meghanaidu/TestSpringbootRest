package com.contacts.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.contacts.domain.Contact;
import com.contacts.repository.ContactsRepository;

/**
 * @author megha
 *
 */
@Service
@Transactional
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactsRepository contactsRepository;

	@Override
	public Contact save(Contact contact) {
		try {
			contactsRepository.save(contact);
		} catch (Exception ex) {
			System.out.println("Contact could not be saved - " + contact.toString());
			ex.getMessage();
		}
		return contact;
	}

	@Override
	public Contact update(Contact contact, long id) {
		try {
			Contact oldContact = contactsRepository.findOne(id);
			oldContact.setEmail(contact.getEmail());
			oldContact.setName(contact.getName());
			oldContact.setProfession(contact.getProfession());
			contactsRepository.save(oldContact);
		} catch (Exception ex) {
			System.out.println("Contact could not be updated - " + contact.toString());
			ex.getMessage();
		}
		return contact;
	}

	@Override
	public void delete(long id) {
		try {
			contactsRepository.delete(id);
		} catch (Exception ex) {
			System.out.println("Contact could not be deleted - " + id);
			ex.getMessage();
		}
		return;
	}

	@Override
	public List<Contact> findAll(int pageNum, int pageSize, boolean orderByAsc) {
		try {
			PageRequest pageRequest = null;
			if (orderByAsc) {
				pageRequest = new PageRequest(pageNum, pageSize, Sort.Direction.ASC);
			} else {
				pageRequest = new PageRequest(pageNum, pageSize, new Sort(new Order(Sort.Direction.DESC, "id")));
			}
			Page<Contact> contacts = contactsRepository.findAll(pageRequest);
			return contacts.getContent();
		} catch (Exception ex) {
			System.out.println("Could not find any contacts");
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Contact> findWithCriteria(int pageNum, int pageSize, boolean orderByAsc, String profession) {
		PageRequest pageRequest = null;
		try {
			pageRequest = new PageRequest(pageNum, pageSize, new Sort(new Order(Sort.Direction.DESC, "created")));
			Page<Contact> contacts = contactsRepository.findByProfession(pageRequest, profession);
			return contacts.getContent();
		} catch (Exception ex) {
			System.out.println("Contact could not find any contacts");
			ex.getMessage();
			return null;
		}
	}
}
