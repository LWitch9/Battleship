package GUI;

import Controller.Messages;
import Game.WhichPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View{

    private JFrame frame;
    private JLabel player1Label, player2Label, communicationLabel;
    private JButton resetButton, battleButton;

    private BoardView player1Buttons;
    private BoardView player2Buttons;

    public View() {
        this.frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponents(frame, new Color(139, 139, 135));
        displayMessageOnCommunicationLabel(""+Messages.WELCOME);
        frame.setSize(840, 650);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void resetBoards(){
        player1Buttons.resetAll();
        player2Buttons.resetAll();
    }
    public void setBoardEnabled(Boolean state, WhichPlayer player){
        if(player1Buttons.getPlayer() == player){
            player1Buttons.setAllFieldsEnabled(state);
        }
        else{
            player2Buttons.setAllFieldsEnabled(state);
        }
    }
    public void setSpecificFieldEnabled(int x, int y, Boolean state, WhichPlayer player, boolean isStateSetPermanently){
        if(player1Buttons.getPlayer() == player){
            player1Buttons.setSpecificFieldEnabled(x,y,state, isStateSetPermanently);
        }
        else{
            player2Buttons.setSpecificFieldEnabled(x,y,state, isStateSetPermanently);
        }

    }

    public void changeColorOfBoard(Color color, WhichPlayer player){
        if(player1Buttons.getPlayer() == player){
            player1Buttons.changeColorOfAllFields(color);
        }
        else{
            player2Buttons.changeColorOfAllFields(color);
        }
    }
    public void changeColorOfSpecificField(int x, int y, Color color, WhichPlayer player){
        if(player1Buttons.getPlayer() == player){
            player1Buttons.changeColorOfSpecificField(x,y,color);
        }
        else{
            player2Buttons.changeColorOfSpecificField(x,y,color);
        }


    }

    public void addListenerToFields(ActionListener listener){
        player1Buttons.addListenerToFields(listener);
        player2Buttons.addListenerToFields(listener);
    }
    public void addListenerToResetButton(ActionListener listener){
        resetButton.addActionListener(listener);
    }
    public void addListenerToBattleButton(ActionListener listener){
        battleButton.addActionListener(listener);
    }

    public void displayMessageOnCommunicationLabel(String message){
        communicationLabel.setText("<html><div style='text-align: center;'>"+message+"</div></html>");
    }

    private void addComponents(final JFrame frame, Color componentsColor){
        JPanel mainPanel = new JPanel();
        LayoutManager layout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
        mainPanel.setLayout(layout);

        //Blank space
        mainPanel.add(Box.createRigidArea(new Dimension(840, 30)));
        mainPanel.add(prepareCommunicationLabelPanel(componentsColor));

        //Blank space
        mainPanel.add(Box.createRigidArea(new Dimension(840, 30)));
        mainPanel.add(prepareBoardersPanel());
        mainPanel.add(preparePlayersLabelsPanel(componentsColor));

        //Blank space
        mainPanel.add(Box.createRigidArea(new Dimension(840, 30)));
        mainPanel.add(prepareButtonsPanel(componentsColor));
        //Blank space
        mainPanel.add(Box.createRigidArea(new Dimension(840, 30)));

        //Add mainPanel to frame
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
    }
    private JPanel prepareCommunicationLabelPanel(Color componentsColor){
        //Add communication Label
        JPanel communicationPanel = new JPanel();
        LayoutManager communicationLayout = new BoxLayout(communicationPanel, BoxLayout.X_AXIS);
        communicationPanel.setLayout(communicationLayout);

        //TODO zawijaj tekst !!
        communicationLabel = new JLabel();
        communicationLabel.setPreferredSize(new Dimension(720,60));
        communicationLabel.setBackground(componentsColor);
        communicationLabel.setHorizontalAlignment(SwingConstants.CENTER);

        communicationPanel.add(Box.createRigidArea(new Dimension(60, 60)));
        communicationPanel.add(communicationLabel);
        communicationPanel.add(Box.createRigidArea(new Dimension(60, 60)));

        return communicationPanel;
    }
    private JPanel prepareBoardersPanel(){
        //AddBoarders
        JPanel boardsPanel = new JPanel();
        LayoutManager boardsLayout = new BoxLayout(boardsPanel, BoxLayout.X_AXIS);
        boardsPanel.setLayout(boardsLayout);

        boardsPanel.add(Box.createRigidArea(new Dimension(60, 300)));
        player1Buttons = new BoardView(WhichPlayer.GRACZ1);
        boardsPanel.add(player1Buttons);

        boardsPanel.add(Box.createRigidArea(new Dimension(120, 300)));

        player2Buttons = new BoardView(WhichPlayer.GRACZ1);
        boardsPanel.add(player2Buttons);
        boardsPanel.add(Box.createRigidArea(new Dimension(60, 300)));

        return boardsPanel;
    }
    private JPanel preparePlayersLabelsPanel(Color componentsColor){
        //Add PlayersLabels
        JPanel playersPanel = new JPanel();
        LayoutManager playersLayout = new BoxLayout(playersPanel, BoxLayout.X_AXIS);
        playersPanel.setLayout(playersLayout);

        player1Label = new JLabel("Gracz1");
        player1Label.setPreferredSize(new Dimension(300,60));
        player1Label.setBackground(componentsColor);
        player1Label.setHorizontalAlignment(SwingConstants.CENTER);

        player2Label = new JLabel("Gracz2");
        player2Label.setPreferredSize(new Dimension(300,60));
        player2Label.setBackground(componentsColor);
        player2Label.setHorizontalAlignment(SwingConstants.CENTER);

        playersPanel.add(Box.createRigidArea(new Dimension(60, 60)));
        playersPanel.add(player1Label);
        playersPanel.add(Box.createRigidArea(new Dimension(120, 60)));
        playersPanel.add(player2Label);
        playersPanel.add(Box.createRigidArea(new Dimension(60, 60)));

        return playersPanel;
    }
    private JPanel prepareButtonsPanel(Color componentsColor){
        JPanel buttonsPanel = new JPanel();
        LayoutManager buttonsLayout = new BoxLayout(buttonsPanel, BoxLayout.X_AXIS);
        buttonsPanel.setLayout(buttonsLayout);

        resetButton = new JButton("Reset");
        resetButton.setPreferredSize(new Dimension(240,60));
        resetButton.setBackground(componentsColor);
        resetButton.setMargin(new Insets(10,60,10,60));;

        battleButton = new JButton("Battle!");
        battleButton.setPreferredSize(new Dimension(240,60));
        battleButton.setBackground(componentsColor);
        battleButton.setMargin(new Insets(10,60,10,60));

        buttonsPanel.add(resetButton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(240, 60)));
        buttonsPanel.add(battleButton);

        return buttonsPanel;
    }
}
