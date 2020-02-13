package two;

import one.ButtonPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ComboBoxPanel extends JPanel implements ActionListener {

    private final JLabel pictureLabel;

    public ComboBoxPanel() {
        super(new BorderLayout());
        String[] petNames = {"Bird", "Cat", "Dog", "Pig", "Rabbit"};
        JComboBox<String> petComboBox = new JComboBox<>(petNames);
        petComboBox.setSelectedIndex(4);
        petComboBox.addActionListener(this);


        pictureLabel = new JLabel();
        updatePictureLabel(petNames[petComboBox.getSelectedIndex()]);
        add(petComboBox, BorderLayout.PAGE_START);
        add(pictureLabel, BorderLayout.PAGE_END);
    }

    private void updatePictureLabel(String petName) {
        ImageIcon icon = createImageIcon(petName);
    }

    private ImageIcon createImageIcon(String fileName) {
        URL imageUrl = ButtonPanel.class.getResource(fileName+".gif");
        if (imageUrl != null) {
            return new ImageIcon(imageUrl);
        }
        System.out.println("Ne mogu pronaći ikonicu '" + fileName + ".gif'");
        return null;
    }


    private static void createAndShowUI() {
        JFrame frame = new JFrame("Demonstracija koristenja dugmica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ComboBoxPanel buttonPanel = new ComboBoxPanel();
        buttonPanel.setOpaque(true);
        frame.setContentPane(buttonPanel);
        frame.pack();
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<String> comboBox = (JComboBox<String>)e.getSource();
        String petName = (String) comboBox.getSelectedItem();

    }

    public static void main(String [] args){
        java.awt.EventQueue.invokeLater(ComboBoxPanel::createAndShowUI);
    }
}
