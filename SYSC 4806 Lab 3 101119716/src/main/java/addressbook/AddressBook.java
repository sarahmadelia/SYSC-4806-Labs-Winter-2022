package addressbook;

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
        this.myBuddies = new ArrayList<BuddyInfo>();
    }
    /**
     * adds a buddy info object to the address book
     * @param aBuddy
     */
    public void addBuddy(BuddyInfo aBuddy) {
        if (aBuddy != null) {
            myBuddies.add(aBuddy);
        }
    }



    /**
     * removes a buddy info object from the address book
     * @param index
     * @return
     */
    public BuddyInfo removeBuddy(int index){
        if(index>=0 && index < myBuddies.size()) {
            return myBuddies.remove(index);
        }
        return null;
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
