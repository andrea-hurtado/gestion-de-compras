package ec.edu.ups.vista;

import javax.swing.*;
import java.awt.*;

public class MiJDesktopPane extends JDesktopPane {

    public MiJDesktopPane() {
        super();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        g.setColor(new Color(176, 214, 213));
        g.fillRect(0, 0, getWidth(), getHeight());

        ImageIcon icon = null;
        try {
            icon = new ImageIcon(getClass().getClassLoader().getResource("imagenes/img_1.png"));
        } catch (Exception ex) {
            icon = null;
        }

        int centroX = getWidth() / 2;
        int centroY = getHeight() / 2;
        int logoW = 300;
        int logoH = 300;
        int logoX = centroX - logoW / 2;
        int logoY = centroY - logoH / 2;

        if (icon != null && icon.getIconWidth() > 0) {
            g.drawImage(icon.getImage(), logoX, logoY, logoW, logoH, this);
        }
    }
}