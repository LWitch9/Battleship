package GUI;

import Controller.Controller;
import Game.WhichPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View{
    private JPanel mainPanel;
    private JFrame frame;
    private JLabel player1Label, player2Label, communicationLabel;
    private JButton resetButton, battleButton;

    private BoardView player1Buttons;
    private BoardView player2Buttons;

    public View() {
        this.frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponents(frame, new Color(139, 139, 135));
        frame.setSize(840, 650);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    private void addComponents(final JFrame frame, Color componentsColor){
        this.mainPanel = new JPanel();
        LayoutManager layout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
        mainPanel.setLayout(layout);

        //Blank space
        mainPanel.add(Box.createRigidArea(new Dimension(840, 30)));

        //Add communication Label
        JPanel communicationPanel = new JPanel();
        LayoutManager communicationLayout = new BoxLayout(communicationPanel, BoxLayout.X_AXIS);
        communicationPanel.setLayout(communicationLayout);

        communicationLabel = new JLabel("Communication label");
        communicationLabel.setPreferredSize(new Dimension(720,60));
        communicationLabel.setBackground(componentsColor);
        communicationLabel.setHorizontalAlignment(SwingConstants.CENTER);

        communicationPanel.add(Box.createRigidArea(new Dimension(60, 60)));
        communicationPanel.add(communicationLabel);
        communicationPanel.add(Box.createRigidArea(new Dimension(60, 60)));

        mainPanel.add(communicationPanel);

        //Blank space
        mainPanel.add(Box.createRigidArea(new Dimension(840, 30)));

        //AddBorders
        JPanel boardsPanel = new JPanel();
        LayoutManager boardsLayout = new BoxLayout(boardsPanel, BoxLayout.X_AXIS);
        boardsPanel.setLayout(boardsLayout);

        boardsPanel.add(Box.createRigidArea(new Dimension(60, 300)));
        player1Buttons = new BoardView(WhichPlayer.PLAYER1);
        boardsPanel.add(player1Buttons);

        boardsPanel.add(Box.createRigidArea(new Dimension(120, 300)));

        player2Buttons = new BoardView(WhichPlayer.PLAYER1);
        boardsPanel.add(player2Buttons);
        boardsPanel.add(Box.createRigidArea(new Dimension(60, 300)));

        mainPanel.add(boardsPanel);

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

        mainPanel.add(playersPanel);

        //Blank space
        mainPanel.add(Box.createRigidArea(new Dimension(840, 30)));

        //Add Reset / Battle Buttons
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

        //buttonsPanel.add(Box.createRigidArea(new Dimension(120, 60)));
        buttonsPanel.add(resetButton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(240, 60)));
        buttonsPanel.add(battleButton);
        //buttonsPanel.add(Box.createRigidArea(new Dimension(120, 60)));


        mainPanel.add(buttonsPanel);
        //Blank space
        mainPanel.add(Box.createRigidArea(new Dimension(840, 30)));

        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
    }
    public void setBoardEnabled(Boolean state, WhichPlayer player){
        if(player1Buttons.getPlayer() == player){
            player1Buttons.setAllEnabled(state);
        }
        else{
            player2Buttons.setAllEnabled(state);
        }
    }
    public void setBoardColor(Color color,WhichPlayer player){
        if(player1Buttons.getPlayer() == player){
            player1Buttons.changeColorOfAll(color);
        }
        else{
            player2Buttons.changeColorOfAll(color);
        }
    }

    public void setSpecificFieldEnabled(int x, int y, Boolean state, WhichPlayer player){
        if(player1Buttons.getPlayer() == player){
            player1Buttons.setSpecificFieldEnabled(x,y,state);
        }
        else{
            player2Buttons.setSpecificFieldEnabled(x,y,state);
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
    public void addFieldsListener(ActionListener listener){
        player1Buttons.addListenerToFields(listener);
        player2Buttons.addListenerToFields(listener);
    }
    public void addResetListener(ActionListener listener){
        resetButton.addActionListener(listener);
    }
    public void addBattleListener(ActionListener listener){
        battleButton.addActionListener(listener);
    }

    public JLabel getPlayer1Label() {
        return player1Label;
    }

   public JLabel getPlayer2Label() {
        return player2Label;
    }

    public JLabel getCommunicationLabel() {
        return communicationLabel;
    }

    public void setCommunicationLabel(JLabel communicationLabel) {
        this.communicationLabel = communicationLabel;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public void setResetButton(JButton resetButton) {
        this.resetButton = resetButton;
    }

    public JButton getBattleButton() {
        return battleButton;
    }

    public void setBattleButton(JButton battleButton) {
        this.battleButton = battleButton;
    }

    public BoardView getPlayer1Buttons() {
        return player1Buttons;
    }

    public void setPlayer1Buttons(BoardView player1Buttons) {
        this.player1Buttons = player1Buttons;
    }

    public BoardView getPlayer2Buttons() {
        return player2Buttons;
    }

    public void setPlayer2Buttons(BoardView player2Buttons) {
        this.player2Buttons = player2Buttons;
    }

    public void displayMessageOnCommunicationLabel(String message){
        communicationLabel.setText(message);
    }
}
