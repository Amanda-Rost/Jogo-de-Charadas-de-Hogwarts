package Interfaces;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JogoCharadas extends JPanel {

    private Image fundo;

    public JogoCharadas() {
        ImageIcon referencia = new ImageIcon(getClass().getResource("/resources/FundoJogo.jpeg"));
        fundo = referencia.getImage();
    }

    public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0, 0, null);
        g.dispose();
    }
}
