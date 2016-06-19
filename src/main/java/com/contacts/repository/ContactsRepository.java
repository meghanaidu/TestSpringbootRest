package com.contacts.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.contacts.domain.Contact;

/**
 * @author megha
 *
 */
public interface ContactsRepository extends PagingAndSortingRepository<Contact, Long> {

	Page<Contact> findAll(Pageable pageable);

	Page<Contact> findByProfession(Pageable pageable, String profession);

}
