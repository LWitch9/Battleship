package GUI;

import javax.swing.*;
import java.awt.*;

public class Field extends JButton {

    public Field() {
        this.setPreferredSize(new Dimension(30,30));
        setMargin(new Insets(0, 0, 0, 0));
        this.setFont(new Font("Arial", Font.PLAIN, 8));
        this.setHorizontalAlignment(SwingConstants.LEFT);
        this.setVerticalAlignment(SwingConstants.TOP);
    }

    //TODO
    /*
    * Size of button
    * color
    * state
    * Label
    * */
    //Something about ActionListeners ???
    //public void setLabel(String text){ }
    public void changeColor(String color){
        //TODO
    }
    public void changeState(String state){
        //TODO change if it's disabled or not
    }
}
