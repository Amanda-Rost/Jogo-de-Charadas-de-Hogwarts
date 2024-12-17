package Interfaces;

import javax.swing.*;

public class AguardandoConfirmacao extends JPanel {

    public AguardandoConfirmacao() {
        initComponents();
    }

    private void initComponents() {
        JLabel jLabel1 = new JLabel();

        jLabel1.setText("Aguardando confirmação do diretor.");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(jLabel1)
                                .addContainerGap(117, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jLabel1)
                                .addContainerGap(117, Short.MAX_VALUE))
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("AguardandoConfirmacao");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new AguardandoConfirmacao());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
