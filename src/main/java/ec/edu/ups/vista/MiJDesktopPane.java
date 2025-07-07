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

        // Fondo blanco o azul suave
        g.setColor(new Color(245, 245, 255));
        g.fillRect(0, 0, getWidth(), getHeight());

        // Cargar logo (debe estar en src/main/resources/imagenes/realmadrid.png)
        ImageIcon icon = null;
        try {
            icon = new ImageIcon(getClass().getClassLoader().getResource("imagenes/logorealmadrid.png"));
        } catch (Exception ex) {
            icon = null;
        }

        // Centro del DesktopPane
        int centroX = getWidth() / 2;
        int centroY = getHeight() / 2;
        int logoW = 140;
        int logoH = 140;
        int logoX = centroX - logoW / 2;
        int logoY = centroY - logoH / 2;

        // Dibuja logo si existe
        if (icon != null && icon.getIconWidth() > 0) {
            g.drawImage(icon.getImage(), logoX, logoY, logoW, logoH, this);
        }

        // Dibuja círculo de estrellas
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int numEstrellas = 12;
        int radio = logoW / 2 + 28; // radio desde el centro para estrellas
        int estrellaR = 13;

        for (int i = 0; i < numEstrellas; i++) {
            double ang = 2 * Math.PI * i / numEstrellas - Math.PI / 2;
            int ex = (int) (centroX + Math.cos(ang) * radio);
            int ey = (int) (centroY + Math.sin(ang) * radio);

            drawEstrella(g2, ex, ey, estrellaR, estrellaR / 2);
        }

        // Mensaje temático
        g2.setColor(new Color(21, 43, 126));
        g2.setFont(new Font("Segoe UI", Font.BOLD, 24));
        g2.drawString("¡Hala Madrid!", centroX - 75, logoY + logoH + 35);
    }

    // Método para dibujar una estrella dorada
    private void drawEstrella(Graphics2D g2, int cx, int cy, int rExt, int rInt) {
        int numPuntas = 5;
        int[] xPoints = new int[numPuntas * 2];
        int[] yPoints = new int[numPuntas * 2];

        for (int i = 0; i < numPuntas * 2; i++) {
            double ang = i * Math.PI / numPuntas - Math.PI / 2;
            int r = (i % 2 == 0) ? rExt : rInt;
            xPoints[i] = cx + (int) Math.round(Math.cos(ang) * r);
            yPoints[i] = cy + (int) Math.round(Math.sin(ang) * r);
        }
        g2.setColor(new Color(255, 215, 0)); // Dorado
        g2.fillPolygon(xPoints, yPoints, numPuntas * 2);
        g2.setColor(new Color(204, 170, 0)); // Borde dorado más oscuro
        g2.drawPolygon(xPoints, yPoints, numPuntas * 2);
    }
}

