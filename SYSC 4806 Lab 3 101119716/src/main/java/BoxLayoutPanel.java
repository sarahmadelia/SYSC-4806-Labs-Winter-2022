import javax.swing.*;
import java.awt.*;
import java.util.List;
/**
 * SYSC 4806 Lab 3
 * Creating a reusable panel
 *
 * @author Sarah Abdallah 101119716
 * (Based on Intro to Spring using Swing Doc, Chad Woolley)
 *
 */
public class BoxLayoutPanel  extends JPanel {

    private List<Component> panelComponents;
    private int axis;

    public void setPanelComponents(List<Component> panelComponents){
        this.panelComponents=panelComponents;
    }

    public void setAxis(int axis){
        this.axis= axis;
    }

    public void init(){
        setLayout(new BoxLayout(this, axis));
        for(Component panelComponent: panelComponents) {
            add(panelComponent);
        }
    }
}
