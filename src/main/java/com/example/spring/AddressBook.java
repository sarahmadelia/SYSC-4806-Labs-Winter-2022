package com.example.spring;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Updated for Lab 4
 *
 * @author Sarah Abdallah
 * @version 2022-01-26
 */

@Entity
public class AddressBook {


    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "addressBook")
    private List<BuddyInfo> myBuddies;

    /**
     * Default constructor for the pack.AddressBook class
     */
    public AddressBook() {
        myBuddies = new ArrayList<>();
    }

    public AddressBook(Long id) {
        this.id = id;
        this.myBuddies = new ArrayList<>();
    }
    /**
     * Updated method: adds a buddy info object to the address book
     * @param aBuddy buddyinfo object
     * @return AddressBook with buddies
     */
    public AddressBook addBuddy(BuddyInfo aBuddy) {
        if (aBuddy != null) {
            myBuddies.add(aBuddy);
            aBuddy.setAddressBook(this);
        }
        return this;
    }

//    public AddressBook removeBuddy(Long id){
//        for(int index=0; i<myBuddies.size();index++){
//
//    }

    /**
     * Updated method: removes a buddy info object from the ddress book
     * @param id
     * @return
     */
        public AddressBook removeBuddy(Long id){
            for(int i = 0; i < myBuddies.size(); i++){
                if(myBuddies.get(i).getId().equals(id)){
                    myBuddies.get(i).setAddressBook(null);
                    myBuddies.remove(i);
                    return this;
                }
            }
            return this;
        }


        /**
         * checking to see if the book contains a buddy
         * @param object
         * @return
         */
    public boolean contains(BuddyInfo object){
        return myBuddies.contains(object);
    }

    /**
     * prints the list of buddies that are in the book and their info
     */
    public void getInfo(){
        for(int i=0;i<myBuddies.size();i++) {
            System.out.println(myBuddies.get(i));

        }

    }

    /**
     * Gets the id of this Book. The persistence provider should
     * autogenerate a unique id for new player objects.
     * @return the id
     */

    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id of this Book to the specified value.
     * @param id the new id
     */
    public void setId(Long id){
        this.id=id;
    }

    public List<BuddyInfo> getMyBuddies() {
        return myBuddies;
    }

    public void setMyBuddies(List<BuddyInfo> myBuddies) {
        this.myBuddies = myBuddies;
    }






}
