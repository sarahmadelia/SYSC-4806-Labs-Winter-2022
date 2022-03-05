package com.example.spring;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * AddressBook class updated for Lab 5
 * An AddressBook a list of buddies
 *
 * @author Sarah Abdallah
 * @version 2022-03-04
 */

@Entity
public class AddressBook {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<BuddyInfo> myBuddies;

    /**
     * Default constructor for the AddressBook class
     */
    public AddressBook() {
        myBuddies = new ArrayList<>();
    }

    /**
     * Constructor for the AddressBook class that takes an id
     * @param id
     */
    public AddressBook(Long id) {
        this.id = id;
        this.myBuddies = new ArrayList<>();
    }

    /**
     * Constructor for the AddressBook class that takes a name
     * @param name
     */
    public AddressBook(String name) {
        this.name = name;
        myBuddies = new ArrayList<>();
    }

    /**
     * Adds a buddyInfo object to the list of buddies in the address book
     * @param buddy
     */
    public void addBuddy(BuddyInfo buddy) {
        myBuddies.add(buddy);
    }

    /* Getter and Setter Methods */
    public List<BuddyInfo> getMyBuddies() { return myBuddies; }

    public void setMyBuddies(List<BuddyInfo> myBuddies) {this.myBuddies = myBuddies; }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public Long getAddressBookID(){ return id; }

    /**
     * How many buddies are in the address book
     * @return number of buddies as an integer
     */
    public int getAmount(){return myBuddies.size();}

    /**
     * Returns the index of a buddy info object
     * @param name
     * @param phoneNumber
     * @return index
     */
    public int findBuddyIndex(String name, String phoneNumber) {
        BuddyInfo toFind = new BuddyInfo(name, phoneNumber, this.id);
        for (BuddyInfo buddy : myBuddies) {
            if (buddy.equals(toFind)) {
                return myBuddies.indexOf(buddy);
            }
        }
        return -1;
    }

    /**
     * Returns a buddy info object from the passed index
     * @param index of a buddy
     */
    public BuddyInfo getBuddyFrom(int index) {
        return myBuddies.get(index);
    }




}
