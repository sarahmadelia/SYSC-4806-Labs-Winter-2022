package com.example.spring;
import java.util.List;

import com.example.spring.AddressBook;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "addressbook", path = "addressbook")
public interface AddressBookRepository extends PagingAndSortingRepository<AddressBook, Long>{
    List<AddressBook> findAddressBookById(@Param("id") Long id);
}
