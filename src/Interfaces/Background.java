package Interfaces;

import javax.swing.JFrame;

public class Background extends JFrame {

    private JogoCharadas charadasPanel;

    public Background() {
        charadasPanel = new JogoCharadas();
        add(new JogoCharadas());
        setSize(735, 950);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Background();
    }
}
