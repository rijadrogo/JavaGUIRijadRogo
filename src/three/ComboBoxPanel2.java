package three;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ComboBoxPanel2 extends JPanel implements ActionListener {
    private String currentPatern;
    private JComponent dateTimeViewResultLabel;

    public ComboBoxPanel2() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        String[] patterns = {
                "dd MMMM yy",
                "dd.MM.yy",
                "MM/dd/yy",
                "yyyy.MM.dd 'at' hh:mm:ss z",
                "h::m a",
                "H:mm:ss:SSS",
                "K:mm a,z",
                "yyyy.MMMM.dd GGG hh:mm aaa"
        };
        currentPatern = patterns[0];
        JLabel comboBoxLabel1 = new JLabel("Enter pattern as string or");
        JLabel comboBoxLabel2 = new JLabel("select one from the list");
        JComboBox<String> patternListComboBox = new JComboBox<>(patterns);
        patternListComboBox.setEditable(true);
        patternListComboBox.addActionListener(this);

        JLabel dateViewLabel = new JLabel("Current Date/Time", JLabel.LEFT);
        dateTimeViewResultLabel = new JLabel("");


        JPanel patternPanel = new JPanel();
        patternPanel.setLayout(new BoxLayout(patternPanel, BoxLayout.PAGE_AXIS));
        patternPanel.add(comboBoxLabel1);
        patternPanel.add(comboBoxLabel2);

        patternListComboBox.setAlignmentX(LEFT_ALIGNMENT);
        patternPanel.add(patternListComboBox);

        JPanel dateTimeViewPanel = new JPanel();
        dateTimeViewPanel.setLayout(new GridLayout(0, 1));
        dateTimeViewPanel.add(dateViewLabel);
        dateTimeViewPanel.add(dateTimeViewResultLabel);

        patternPanel.setAlignmentX(LEFT_ALIGNMENT);
        dateTimeViewPanel.setAlignmentX(LEFT_ALIGNMENT);


        add(patternPanel);
        dateTimeViewResultLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        add(Box.createRigidArea(new Dimension(0, HEIGHT)));
        add(dateTimeViewResultLabel);

        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        reformat();
    }

    private void reformat() {
        Date today = new Date();
        SimpleDateFormat formater = new SimpleDateFormat(currentPatern);

        String formattedToday = formater.format(today);
        // dateTimeViewResultLabel.setText(formattedToday);
    }

    public static void createAndShowUI() {
        JFrame frame = new JFrame("Demonstracija koristenja dugmica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ComboBoxPanel2 comboBoxPanel2 = new ComboBoxPanel2();
        comboBoxPanel2.setOpaque(true);
        frame.setContentPane(comboBoxPanel2);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<String> comboBox = (JComboBox<String>) e.getSource();
        String newPattern = (String) comboBox.getSelectedItem();
        currentPatern = newPattern;
        reformat();
        ;
    }
}


