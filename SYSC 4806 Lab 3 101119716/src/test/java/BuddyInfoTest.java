
import static org.junit.Assert.*;
import org.junit.*;
import addressbook.BuddyInfo;

import javax.persistence.*;

/**
 * Lab 2
 * Test class for pack.BuddyInfo
 * @author Sarah Abdallah
 * @version 2022-01-26
 */



public class BuddyInfoTest {
    BuddyInfo buddy;
    String name;
    String phoneNumber;

    @org.junit.Before
    public void setUp() throws Exception {
        name= "Alarm force rep ";
        phoneNumber= "1800 267 2001";
        buddy = new BuddyInfo(name, phoneNumber);

    }

    @org.junit.Test
    public void getName() {
        assertEquals(name, buddy.getName());

    }

    @org.junit.Test
    public void getPhoneNumber() {
        assertEquals(phoneNumber, buddy.getPhoneNumber());

    }


    /**
     * Tests the persistance of a buddyinfo object
     */
    @Test
public void persistence() {

    // Connecting to the database through EntityManagerFactory
    // connection details loaded from persistence.xml
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lab");
    EntityManager em = emf.createEntityManager();

    Long testerID = addProduct(em);
    BuddyInfo buddyInfo= queryProducts(em,testerID);

    assertNotNull(buddyInfo);
    assertEquals("Product", buddyInfo.getName());
    assertEquals("ProdNumber", buddyInfo.getPhoneNumber());
    assertEquals(testerID, buddyInfo.getId());
    removeProduct(em,buddyInfo);
    assertNull(queryProducts(em, testerID));

}

private Long addProduct(EntityManager em){
        BuddyInfo buddyInfo = new BuddyInfo("Product", "ProdNumber");
        EntityTransaction tx= em.getTransaction();
        tx.begin();
        em.persist(buddyInfo);
        tx.commit();
        return buddyInfo.getId();
}

private void removeProduct(EntityManager em, BuddyInfo buddyTest){
        em.getTransaction().begin();
        em.remove(buddyTest);
        em.getTransaction().commit();
}

private BuddyInfo queryProducts(EntityManager em, Long id){
        return em.find(BuddyInfo.class, id);
}



}