/**
 * SYSC 4806 Lab 3
 *
 * @author Sarah Abdallah 101119716
 * @version 2022-02-04
 */
public class AddressBookModel {

    private AddressBook addressBook;

    public AddressBookModel() {
        addressBook = new AddressBook();
    }

    public void addBuddy(String buddyName, String buddyNumber){
        BuddyInfo buddy = new BuddyInfo(buddyName, buddyNumber);
        addressBook.addBuddy(buddy);
        System.out.println(buddy);
    }

    public void printBuddyList(){
        System.out.println(addressBook);
    }


}
