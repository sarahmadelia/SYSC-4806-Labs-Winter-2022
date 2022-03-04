package com.example.spring;
import javax.persistence.*;
import java.util.Objects;

/**
 * Buddy Info class updated for Lab 5
 * Represents a buddy within an Addressbook
 *
 * @author Sarah Abdallah
 * @version 2022-03-04
 */

@Entity
public class BuddyInfo {
    @Id
    @GeneratedValue
    private Long id;

    private Long addressBookID;
    private String name;
    private String phoneNumber;

    /**
     * Default constructor for the pack.BuddyInfo class
     *
     */
    public BuddyInfo(){
        this.name="";
        this.phoneNumber="";
        this.addressBookID = 0L;
    }

    /**
     * Constructor for Buddyinfo that takes a name, phoneNumber, and addressBookID
     * @param name
     * @param phoneNumber
     * @param addressBookID
     */
    public BuddyInfo(String name, String phoneNumber, Long addressBookID) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.addressBookID = addressBookID;
    }
    /* Getter and Setter Methods for parameters */

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.name=phoneNumber;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public Long getAddressBookId(){
        return addressBookID;
    }
    public void setAddressBook(Long addressBookID) {
        this.addressBookID = addressBookID;
    }

}
