/**
 * Lab 3
 * @author Sarah Abdallah
 * @version 2022-01-26
 */
import java.awt.event.ActionEvent;

public class PrintBuddiesActionListener extends AddressBookActionListener{
    public void actionPerformed(ActionEvent e){
        model.printBuddyList();
    }
}
