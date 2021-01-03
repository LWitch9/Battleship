package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Field extends JButton {

    //TODO can i connect it with Coordinate? should i get rid of xp, yp here?
    public Field() {

        this.setPreferredSize(new Dimension(30,30));
        setMargin(new Insets(1, 1, 1, 1));
        this.setFont(new Font("Arial", Font.PLAIN, 8));
        this.setHorizontalAlignment(SwingConstants.LEFT);
        this.setVerticalAlignment(SwingConstants.TOP);
    }

}
