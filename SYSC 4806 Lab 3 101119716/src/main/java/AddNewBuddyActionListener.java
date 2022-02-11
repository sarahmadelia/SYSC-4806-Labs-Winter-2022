import java.awt.event.ActionEvent;
/**
 * SYSC 4806 LAB 3
 *
 * @author Sarah Abdallah 101119716 (Taken from Intro to Spring using Swing Doc, Chad Woolley)
 * @version 2022-02-04
 */

public class AddNewBuddyActionListener extends AddressBookActionListener{

        public void actionPerformed(ActionEvent e){
            model.addBuddy(nameField.getText(), numberField.getText());
            nameField.setText("");
            numberField.setText("");
        }
    }

