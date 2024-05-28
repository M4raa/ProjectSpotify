package jpaswing.projectspotiy.ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DisplayPanel extends JPanel {
    private JTextArea resultsArea;

    public DisplayPanel() {
        setLayout(new BorderLayout());
        resultsArea = new JTextArea();
        resultsArea.setEditable(false);
        resultsArea.setForeground(Color.BLACK);
        resultsArea.setBackground(new Color(138, 138, 138));
        resultsArea.setBorder(BorderFactory.createEmptyBorder());
        add(new JScrollPane(resultsArea), BorderLayout.CENTER);
    }

    public void displayResults(List<String> results) {
        resultsArea.setText("");
        for (String result : results){
            resultsArea.append(result + "\n");
        }
    }
}
