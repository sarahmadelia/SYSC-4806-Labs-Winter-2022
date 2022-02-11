import java.awt.event.ActionListener;
import javax.swing.*;
/**
 * SYSC 4806 LAB 3
 *
 *
 * @author Sarah Abdallah 101119716 (Taken from Intro to Spring using Swing Doc, Chad Woolley)
 * @version 2022-02-04
 */
public class ActionListenerButton extends JButton{
    private ActionListener actionListener;

    public void setActionListener(ActionListener actionListener){
        this.actionListener=actionListener;
    }

    public void init(){
        this.addActionListener(actionListener);
    }
}
