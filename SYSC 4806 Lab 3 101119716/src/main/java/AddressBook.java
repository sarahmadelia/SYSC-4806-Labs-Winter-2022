import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * SYSC 4806 LAB 3
 * Part 1: Simple GUI, populate a BuddyInfo and save it in Address Book
 *        MVC principles:
 *        Register Controller to View and View to Model
 * Part 2: Use DI to assemble components of a Swing Application
 *
 * *This section was barely changed from Lab 2
 *
 * @author Sarah Abdallah
 * @version 2022-02-01
 */

@Entity
public class AddressBook {


    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<BuddyInfo> myBuddies;

    /**
     * Default constructor for the AddressBook class
     */
    public AddressBook() {
        myBuddies = new ArrayList<>();
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


    /**
     * Run this method in order to test the program
     * @param args
     */
    public static void main(String[] args) {
        Launcher launcher = new Launcher();
        launcher.launch();
    }



}
