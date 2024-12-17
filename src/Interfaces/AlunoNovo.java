package Interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlunoNovo extends JPanel {

    public AlunoNovo() {
        initComponents();
    }

    private void initComponents() {
        JLabel jLabelNome = new JLabel();
        JLabel jLabelSobrenome = new JLabel();
        JLabel jLabelEmail = new JLabel();
        JLabel jLabelSenha = new JLabel();
        JLabel jLabelConfirmSenha = new JLabel();
        JLabel jLabelCasa = new JLabel(); 
        JTextField jTextFieldNome = new JTextField();
        JTextField jTextFieldSobrenome = new JTextField();
        JTextField jTextFieldEmail = new JTextField();
        JPasswordField jPasswordFieldSenha = new JPasswordField();
        JPasswordField jPasswordFieldConfirmSenha = new JPasswordField();
        JComboBox<String> jComboBoxCasa = new JComboBox<>(); 
        JButton jButtonCadastrar = new JButton();

        jLabelNome.setText("Nome:");
        jLabelSobrenome.setText("Sobrenome:");
        jLabelEmail.setText("E-mail:");
        jLabelSenha.setText("Senha:");
        jLabelConfirmSenha.setText("Confirmar Senha:");
        jLabelCasa.setText("Casa:"); // Texto para a casa
        jButtonCadastrar.setText("Cadastrar");

        // Adicionando opções de casas à caixa de seleção
        jComboBoxCasa.addItem("Grifinória");
        jComboBoxCasa.addItem("Sonserina");
        jComboBoxCasa.addItem("Lufa-Lufa");
        jComboBoxCasa.addItem("Corvinal");

        jButtonCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = jTextFieldNome.getText();
                String sobrenome = jTextFieldSobrenome.getText();
                String email = jTextFieldEmail.getText();
                String senha = new String(jPasswordFieldSenha.getPassword());
                String confirmSenha = new String(jPasswordFieldConfirmSenha.getPassword());
                String casa = (String) jComboBoxCasa.getSelectedItem(); 

                if (nome.isEmpty() || sobrenome.isEmpty() || email.isEmpty() || senha.isEmpty() || confirmSenha.isEmpty()) {
                    JOptionPane.showMessageDialog(AlunoNovo.this, "Todos os campos são obrigatórios.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (email.length() < 5 || !email.contains("@")) {
                    JOptionPane.showMessageDialog(AlunoNovo.this, "O email deve ter um formato válido.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (!senhaForte(senha)) {
                    JOptionPane.showMessageDialog(AlunoNovo.this, "A senha não atende aos requisitos mínimos.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (!senha.equals(confirmSenha)) {
                    JOptionPane.showMessageDialog(AlunoNovo.this, "As senhas não coincidem.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }

               
                closeAndOpen(new AguardandoConfirmacao());
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
                                .addComponent(jLabelNome)
                                .addComponent(jLabelSobrenome)
                                .addComponent(jLabelSenha)
                                .addComponent(jLabelConfirmSenha)
                                .addComponent(jLabelCasa))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldEmail)
                                .addComponent(jTextFieldNome)
                                .addComponent(jTextFieldSobrenome)
                                .addComponent(jPasswordFieldSenha)
                                .addComponent(jPasswordFieldConfirmSenha, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(jComboBoxCasa)) 
                            )
                        .addGroup(layout.createSequentialGroup()
                            .addGap(61, 61, 61)
                            .addComponent(jButtonCadastrar)))
                    .addContainerGap(124, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelNome)
                        .addComponent(jTextFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelSobrenome)
                        .addComponent(jTextFieldSobrenome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelEmail)
                        .addComponent(jTextFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelSenha)
                        .addComponent(jPasswordFieldSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelConfirmSenha)
                        .addComponent(jPasswordFieldConfirmSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelCasa) 
                        .addComponent(jComboBoxCasa)) 
                    .addGap(18, 18, 18)
                    .addComponent(jButtonCadastrar)
                    .addContainerGap(21, Short.MAX_VALUE))
        );
    }

    private void closeAndOpen(JPanel newPanel) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.getContentPane().remove(this);
        frame.getContentPane().add(newPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.revalidate();
        frame.repaint();
    }

    public static boolean senhaForte(String senha) {
        if (senha.length() < 6) return false;

        boolean achouNumero = false;
        boolean achouMaiuscula = false;
        boolean achouMinuscula = false;
        boolean achouSimbolo = false;
        for (char c : senha.toCharArray()) {
             if (c >= '0' && c <= '9') {
                 achouNumero = true;
             } else if (c >= 'A' && c <= 'Z') {
                 achouMaiuscula = true;
             } else if (c >= 'a' && c <= 'z') {
                 achouMinuscula = true;
             } else {
                 achouSimbolo = true;
             }
        }
        return achouNumero && achouMaiuscula && achouMinuscula && achouSimbolo;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Aluno Novo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new AlunoNovo());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
