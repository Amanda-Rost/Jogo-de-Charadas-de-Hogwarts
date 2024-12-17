package Interfaces;


import Interfaces.Background;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AlunoCadastrado extends JPanel {

    public AlunoCadastrado() {
        initComponents();
    }

    private void initComponents() {
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JTextField jTextFieldEmail = new JTextField();
        JPasswordField jPasswordFieldSenha = new JPasswordField();
        JButton jButtonEntrar = new JButton();

        jLabel1.setText("E-mail:");
        jLabel2.setText("Senha:");
        jButtonEntrar.setText("Entrar");
        jButtonEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = jTextFieldEmail.getText();
                String senha = new String(jPasswordFieldSenha.getPassword());

                if (email.isEmpty() || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(AlunoCadastrado.this, "Por favor, preencha todos os campos.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                openBackgroundInterface();
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(135, 135, 135)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldEmail)
                                .addComponent(jPasswordFieldSenha, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(61, 61, 61)
                            .addComponent(jButtonEntrar)))
                    .addContainerGap(122, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(93, 93, 93)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jPasswordFieldSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jButtonEntrar)
                    .addContainerGap(84, Short.MAX_VALUE))
        );
    }
    
    private void openBackgroundInterface() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose(); // Fecha a interface AlunoCadastrado
        new Background(); // Abre a interface Background
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("AlunoCadastrado");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new AlunoCadastrado());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
