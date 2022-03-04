package com.example.spring;

import com.example.spring.AddressBook;

import javax.persistence.*;

/**
 * Updated for Lab 4
 *
 * @author Sarah Abdallah
 * @version 2022-01-26
 */

@Entity
public class BuddyInfo {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "addressbookId")
    private AddressBook addressBook;

    /**
     * Default constructor for the pack.BuddyInfo class
     *
     */
    public BuddyInfo(){
        this.name="";
        this.phoneNumber="";
    }


    /**
     * Constructor (2) for BuddyInfo
     * @param name
     * @param phoneNumber
     */
    public BuddyInfo(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber= phoneNumber;

    }


    /**
     * Constructor (3) for BuddyInfo
     * @param name
     * @param phoneNumber
     * @param addressBook
     */
    public BuddyInfo(String name, String phoneNumber, AddressBook addressBook){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.addressBook = addressBook;
    }


    /**
     * Getter for a buddy's name
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * Setter for the buddy's name
     * @param name
     */
    public void setName(String name){
        this.name=name;
    }


    /**
     * Getter for the buddy's phone number
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setter for the buddy's phone number
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber){
        this.name=phoneNumber;
    }

    /**
     * Gets the id of this Buddy. The persistence provider should
     * autogenerate a unique id for new player objects.
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id of this Buddy to the specified value.
     * @param id the new id
     */
    public void setId(Long id){
        this.id=id;
    }


    public Long getAddressBookId(){
        return addressBook.getId();
    }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

}
