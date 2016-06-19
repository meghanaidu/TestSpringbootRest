package com.contacts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contacts.domain.Contact;
import com.contacts.service.ContactService;

/**
 * @author megha
 *
 */
@RestController
@RequestMapping(value = "/contacts")
public class ContactController {

	@Autowired
	private ContactService contactService;

	/**
	 * View list of all contacts
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param orderByAsc
	 * @return
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public List<Contact> listAllContact(@RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "20") int pageSize,
			@RequestParam(value = "orderByAsc", defaultValue = "1") boolean orderByAsc) {
		return contactService.findAll(pageNum, pageSize, orderByAsc);
	}

	/**
	 * Add a new contact
	 * 
	 * @param name
	 * @param email
	 * @param profession
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public Contact addContacts(@RequestParam(value = "Name") String name, @RequestParam(value = "Email") String email,
			@RequestParam(value = "Profession") String profession) {
		Contact contact = new Contact(name, email, profession);
		return contactService.save(contact);
	}

	/**
	 * Delete a contact
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void deleteContact(@PathVariable long id) {
		contactService.delete(id);
		return;
	}

	/**
	 * Update a contact
	 * 
	 * @param id
	 * @param name
	 * @param email
	 * @param profession
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
	public void updateContact(@PathVariable long id, @RequestParam(value = "Name") String name,
			@RequestParam(value = "Email") String email, @RequestParam(value = "Profession") String profession) {
		Contact contact = new Contact(name, email, profession);
		contactService.update(contact, id);
		return;
	}

	/**
	 * Find contacts based on profession
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param orderByAsc
	 * @param profession
	 * @return
	 */
	@RequestMapping(value = "/findUnemployed", method = RequestMethod.GET, produces = "application/json")
	public List<Contact> findUnemployed(@RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "20") int pageSize,
			@RequestParam(value = "orderByAsc", defaultValue = "1") boolean orderByAsc,
			@RequestParam(value = "profession", defaultValue = "Unemployed") String profession) {
		return contactService.findWithCriteria(pageNum, pageSize, orderByAsc, profession);
	}
}
