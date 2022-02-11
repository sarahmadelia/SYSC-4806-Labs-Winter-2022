import org.junit.Before;
import org.junit.Test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import static org.junit.Assert.*;

/**
 * Lab 2
 * Test class for AddressBook
 * @author Sarah Abdallah
 * @version 2022-01-26
 */

public class AddressBookTest {
    AddressBook addressBook;
    BuddyInfo buddy1;
    BuddyInfo buddy2;



    @Before
    public void setUp() throws Exception {
       addressBook = new AddressBook();
       buddy1= new BuddyInfo("Harry Potter", "123");
       buddy2= new BuddyInfo("Ron Weasley", "456");
    }

    @Test
    public void addBuddy() {
        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);

        assertTrue(addressBook.contains(buddy1));
        assertTrue(addressBook.contains(buddy2));
    }

    @Test
    public void removeBuddy() {
        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);

        addressBook.removeBuddy(0);
        assertFalse(addressBook.contains(buddy1));

        addressBook.removeBuddy(0);
        assertFalse(addressBook.contains(buddy2));
    }

    @Test
    public void contains() {
        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);

        assertTrue(addressBook.contains(buddy1));
        assertTrue(addressBook.contains(buddy2));
    }

    /**
     * Tests the persistance of an addresss book object
     */
    @Test
    public void persistence() {

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lab");

        EntityManager em = emf.createEntityManager();

        Long testerID = addProduct(em);
        AddressBook addressBook= queryProducts(em,testerID);
        assertNotNull(addressBook);
        removeProduct(em,addressBook);
        assertNull(queryProducts(em,testerID));


    }

    private Long addProduct(EntityManager em){
        AddressBook addressBook = new AddressBook();
        BuddyInfo buddyInfo;
        for(int num = 0; num<10; num++){
            buddyInfo= new BuddyInfo();
            addressBook.addBuddy(buddyInfo);
        }

        EntityTransaction tx= em.getTransaction();
        tx.begin();

        em.persist(addressBook);
        tx.commit();
        return addressBook.getId();
    }

    private void removeProduct(EntityManager em, AddressBook addressBook){
        em.getTransaction().begin();
        em.remove(addressBook);
        em.getTransaction().commit();
    }

    private AddressBook queryProducts(EntityManager em, Long id){

        return em.find(AddressBook.class, id);
    }



}