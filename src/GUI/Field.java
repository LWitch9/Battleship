package GUI;

import javax.swing.*;
import java.awt.*;

public class Field extends JButton {

    public Field() {
        this.setPreferredSize(new Dimension(30,30));
        setMargin(new Insets(1, 1, 1, 1));
        this.setFont(new Font("Arial", Font.PLAIN, 8));
        this.setHorizontalAlignment(SwingConstants.LEFT);
        this.setVerticalAlignment(SwingConstants.TOP);
    }
}
