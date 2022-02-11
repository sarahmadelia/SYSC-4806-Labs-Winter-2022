import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * SYSC 4806 LAB 3
 *
 *
 * @author Sarah Abdallah 101119716 (Taken from Intro to Spring using Swing Doc, Chad Woolley)
 * @version 2022-02-04
 */

public abstract class AddressBookActionListener implements ActionListener{
    protected JTextField nameField;
    protected JTextField numberField;
    protected AddressBookModel model;

    public void setNameField(JTextField nameField){
        this.nameField=nameField;
    }

    public void setNumberField(JTextField numberField){
        this.numberField=numberField;
    }

    public void setModel(AddressBookModel model){
        this.model=model;
    }
}
