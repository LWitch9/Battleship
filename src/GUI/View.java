package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class View{
    private JPanel mainPanel;
    private JFrame frame;
    private JLabel player1Label, player2Label, communicationLabel;
    //private ArrayList<ArrayList<JButton>> player1Buttons, player2Buttons;
    private JButton reset, battle;

    private BoardView player1Buttons;

    public View() {
        this.frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponents(frame);
        frame.setSize(500, 660);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private void addComponents(final JFrame frame){
        this.mainPanel = new JPanel();
        LayoutManager layout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
        //FlowLayout layout = new FlowLayout();
        mainPanel.setLayout(layout);

        mainPanel.add(new JButton("One"));
        //mainPanel.add(Box.createVerticalGlue());

        JPanel boardsPanel = new JPanel();
        //LayoutManager boardsLayout = new BoxLayout(boardsPanel, BoxLayout.X_AXIS);
        FlowLayout boardsLayout = new FlowLayout();
        boardsPanel.setLayout(boardsLayout);



        //boardsPanel.add(Box.createRigidArea(new Dimension(10, 500)));
        player1Buttons = new BoardView();
        boardsPanel.add(player1Buttons);
        //boardsPanel.add(Box.createRigidArea(new Dimension(10, 500)));


        mainPanel.add(boardsPanel);



        //player1Buttons.setBorder(BorderFactory.createLineBorder(Color.black));




        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
    }

}
