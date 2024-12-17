package Interfaces;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiretorLogin extends JPanel {

    private JTextField jTextFieldEmail;
    private JPasswordField jPasswordFieldSenha;
    private JButton jButtonOk;

    public DiretorLogin() {
        initComponents();
    }

    private void initComponents() {
        JLabel jLabelEmail = new JLabel("E-mail:");
        JLabel jLabelSenha = new JLabel("Senha:");

        jTextFieldEmail = new JTextField(20);
        jPasswordFieldSenha = new JPasswordField(20);

        jButtonOk = new JButton("OK");
        jButtonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarCredenciais();
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEmail)
                            .addComponent(jLabelSenha))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldEmail)
                            .addComponent(jPasswordFieldSenha, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jButtonOk)))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmail)
                    .addComponent(jTextFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSenha)
                    .addComponent(jPasswordFieldSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonOk)
                .addContainerGap(45, Short.MAX_VALUE))
        );
    }
    
    private boolean ValidaEmail(String email) {
        return email.equalsIgnoreCase("karen@gmail.com") || email.equalsIgnoreCase("marcio@gmail.com");
    }  

    private boolean ValidaSenha(String email, String senha) {
        if (email.equalsIgnoreCase("karen@gmail.com")) {
            return senha.equals("Karen!1234");
        } else if (email.equalsIgnoreCase("marcio@gmail.com")) {
            return senha.equals("Marcio?5678");
        }
        return false;
    }  

    public void verificarCredenciais() {
    String email = jTextFieldEmail.getText();
    String senha = new String(jPasswordFieldSenha.getPassword());

    if (ValidaEmail(email) && ValidaSenha(email, senha)) {
        JOptionPane.showMessageDialog(this, "Credenciais válidas. Acesso permitido.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        
       
        openDiretorInterfacePrincipal();
    } else {
        JOptionPane.showMessageDialog(this, "Credenciais inválidas. Acesso negado.", "Aviso", JOptionPane.WARNING_MESSAGE);
    }
}

private void openDiretorInterfacePrincipal() {
    JFrame frame = new JFrame("Diretor Interface Principal");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.add(new DiretorInterfacePrincipal());
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    SwingUtilities.getWindowAncestor(this).dispose(); 
}
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Diretor Login");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new DiretorLogin());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}