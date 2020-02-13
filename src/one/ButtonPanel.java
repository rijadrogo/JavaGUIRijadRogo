package one;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;

public class ButtonPanel extends JPanel implements ActionListener {
    private JButton leftButton;
    private JButton middleButton;
    private JButton rightButton;

    private ButtonPanel() {
        setLeftButton();
        setMiddleButton();
        setRightButton();
    }

    private void setRightButton() {
        ImageIcon rightImageIcon = createImageIcon("left.gif");
        rightButton = new JButton("Enable middle button", rightImageIcon);
        rightButton.setMnemonic(KeyEvent.VK_E);
        rightButton.addActionListener(this);
        rightButton.setActionCommand("enable");
        add(rightButton);
    }

    private void setMiddleButton() {
        ImageIcon middleIconButton = createImageIcon("middle.gif");
        middleButton = new JButton("Victim", middleIconButton);
        middleButton.setVerticalTextPosition(AbstractButton.BOTTOM);
        middleButton.setHorizontalTextPosition(AbstractButton.CENTER);
        middleButton.addActionListener(this);
        add(middleButton);
    }

    private void setLeftButton() {
        ImageIcon leftButtonIcon = createImageIcon("right.gif");
        leftButton = new JButton("Disable button in the middle", leftButtonIcon);
        leftButton.setVerticalTextPosition(AbstractButton.CENTER);
        leftButton.setHorizontalTextPosition(AbstractButton.LEADING);
        leftButton.setMnemonic(KeyEvent.VK_D);
        leftButton.addActionListener(this);
        leftButton.setActionCommand("disable");
        add(leftButton);
    }

    private ImageIcon createImageIcon(String fileName) {
        URL imageUrl = ButtonPanel.class.getResource(fileName);
        if (imageUrl != null) {
            return new ImageIcon(imageUrl);
        }
        System.out.println("NOOOO");
        return null;
    }

    private static void createAndShowUI() {
        JFrame frame = new JFrame("Demonstracija koristenja dugmica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ButtonPanel buttonPanel = new ButtonPanel();
        buttonPanel.setOpaque(true);
        frame.setContentPane(buttonPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(ButtonPanel::createAndShowUI);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if ("disable".equals(actionCommand)) {
            middleButton.setEnabled(false);
            leftButton.setEnabled(false);
            rightButton.setEnabled(true);
        } else if("enable".equals(actionCommand)){
            middleButton.setEnabled(true);
            leftButton.setEnabled(true);
            rightButton.setEnabled(false);
        }
    }
}
