package one;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.net.URL;


public class CheckBoxPanel extends JPanel implements ItemListener {
    private JCheckBox chinCheckBox;
    private JCheckBox glassesCheckBox;
    private JCheckBox hairCheckBox;
    private JCheckBox teethCheckBox;

    private JLabel pictureLabel;
    private StringBuffer pictureName;

    public CheckBoxPanel() {
        super(new BorderLayout());
        pictureName = new StringBuffer("cght");
        JPanel checkBoxPanel = new JPanel(new GridLayout(0, 1));

        chinCheckBox = getCheckBox(checkBoxPanel, "Chin", KeyEvent.VK_C);
        glassesCheckBox = getCheckBox(checkBoxPanel, "Glasses", KeyEvent.VK_G);
        hairCheckBox = getCheckBox(checkBoxPanel, "Hair", KeyEvent.VK_H);
        teethCheckBox = getCheckBox(checkBoxPanel, "Teeth", KeyEvent.VK_H);

        pictureLabel = new JLabel();
        pictureLabel.setFont(pictureLabel.getFont().deriveFont(Font.ITALIC));
        updatePicture();

        add(checkBoxPanel, BorderLayout.LINE_START);
        add(pictureLabel, BorderLayout.CENTER);
    }

    private JCheckBox getCheckBox(JPanel checkBoxPanel, String text, int eventKey){
        JCheckBox checkBox = new JCheckBox(text);
        checkBox.setMnemonic(eventKey);
        checkBox.setSelected(true);
        checkBox.addItemListener(this);
        checkBoxPanel.add(checkBox);
        return checkBox;

    }

    private ImageIcon createImageIcon(String fileName) {
        URL imageUrl = ButtonPanel.class.getResource(fileName);
        if (imageUrl != null) {
            return new ImageIcon(imageUrl);
        }
        return null;
    }


    private static void createAndShowUI() {
        JFrame frame = new JFrame("Demonstracija koristenja dugmica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CheckBoxPanel buttonPanel = new CheckBoxPanel();
        buttonPanel.setOpaque(true);
        frame.setContentPane(buttonPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private void updatePicture() {
        ImageIcon imageIcon = createImageIcon("geek-" + pictureName.toString() + ".gif");
        pictureLabel.setIcon(imageIcon);
        pictureLabel.setToolTipText(pictureName.toString());
        if (imageIcon == null) {
            pictureLabel.setText("Missing image icon file");
        }
    }

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(CheckBoxPanel::createAndShowUI);
    }

    // cght
    @Override
    public void itemStateChanged(ItemEvent e) {
        int index = 0;
        char c = '-';
        ItemSelectable source = e.getItemSelectable();
        if (source == chinCheckBox) {
            index = 0;
            c = 'c';
        } else if (source == glassesCheckBox) {
            index = 1;
            c = 'g';
        } else if (source == hairCheckBox) {
            index = 2;
            c = 'h';
        } else if (source == teethCheckBox) {
            index = 3;
            c = 't';
        }
        if (e.getStateChange() == ItemEvent.DESELECTED) {
            c = '-';
        }
        pictureName.setCharAt(index, c);
        updatePicture();
    }
}
