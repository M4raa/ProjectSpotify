package jpaswing.projectspotiy.ui;

import javax.swing.*;
import java.awt.*;

public class ImageDisplayPanel extends JPanel {
    private JLabel imageLabel;

    public ImageDisplayPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(44, 47, 51)); // Color de fondo gris oscuro
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(imageLabel, BorderLayout.CENTER);
    }

    public void setImageIcon(ImageIcon icon) {
        imageLabel.setIcon(icon);
    }
}
