package two;

import one.ButtonPanel;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;

public class RadioButtonLabel extends JPanel implements ActionListener {
    static final String BIRD_NAME = "Bird";
    static final String CAT_NAME = "Cat";
    static final String DOG_NAME = "Dog";
    static final String PIG_NAME = "Pig";
    static final String RABBIT_NAME = "Rabbit";

    private JLabel pictureLabel;

    private JRadioButton initButton(String name, int key, ButtonGroup buttonGroup, JPanel radioButton){
        JRadioButton button = new JRadioButton(name);
        button.setMnemonic(key);
        button.setActionCommand(name);
        button.addActionListener(this);
        buttonGroup.add(button);
        radioButton.add(button);
        return button;
    }

    public RadioButtonLabel() {
        super(new BorderLayout());

        JPanel radioButtonPanel = new JPanel(new GridLayout(0,1));

        ButtonGroup buttonGroup = new ButtonGroup();

        JRadioButton birdButton = initButton(BIRD_NAME, KeyEvent.VK_B, buttonGroup, radioButtonPanel);
        birdButton.setSelected(true);

        JRadioButton catButton = initButton(CAT_NAME, KeyEvent.VK_C, buttonGroup, radioButtonPanel);

        JRadioButton dogButton = initButton(DOG_NAME, KeyEvent.VK_D, buttonGroup, radioButtonPanel);

        JRadioButton pigButton = initButton(PIG_NAME, KeyEvent.VK_P, buttonGroup, radioButtonPanel);

        JRadioButton rabbitButton = initButton(RABBIT_NAME, KeyEvent.VK_R, buttonGroup, radioButtonPanel);

        pictureLabel = new JLabel(createImageIcon(BIRD_NAME));
        Dimension dimension = new Dimension(158, 123);
        pictureLabel.setPreferredSize(dimension);

        add(radioButtonPanel, BorderLayout.LINE_START);
        add(pictureLabel, BorderLayout.CENTER);
    }

    @Nullable
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

        RadioButtonLabel buttonPanel = new RadioButtonLabel();
        buttonPanel.setOpaque(true);
        frame.setContentPane(buttonPanel);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String fileName = e.getActionCommand();
        ImageIcon imageIcon = createImageIcon( fileName);
        pictureLabel.setIcon(imageIcon);
        pictureLabel.setToolTipText(fileName);

        if (imageIcon == null) {
            pictureLabel.setText("Missing file: '" + fileName + ".gif" + "'");
        }
    }

    @Override
    public ActionListener getActionForKeyStroke(KeyStroke aKeyStroke) {
        return null;
    }

    public static void main(String [] args){
        java.awt.EventQueue.invokeLater(RadioButtonLabel::createAndShowUI);
    }


}
