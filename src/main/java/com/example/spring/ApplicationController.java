package com.example.spring;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Controller class initialized with the provided
 * Spring Tutorials
 * Controls the AddressBook
 *
 * @author Sarah Abdallah
 * @version 2022-03-04
 *
 */
@Controller
public class ApplicationController {
    @Autowired
    AddressBookRepository addressBookRepository;
    @Autowired
    BuddyInfoRepository buddyInfoRepository;

    /**
     *
     * @param addressBook
     */
    @PostMapping("/AddressBook/new")
    public void newAddressBook(@RequestBody AddressBook addressBook){
        addressBookRepository.save(addressBook);
    }


    /**
     *
      * @param buddy
     */
    @PostMapping("/AddressBook/addNewBuddy")
    public void addNewBuddy(@RequestBody BuddyInfo buddy){
        AddressBook addressBook = addressBookRepository.findAddressBookById(buddy.getAddressBookId());
        buddyInfoRepository.save(buddy);
        addressBook.addBuddy(buddy);
        addressBookRepository.save(addressBook);
    }


}
