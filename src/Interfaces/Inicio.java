package Interfaces;


import Interfaces.AlunoNovoOuCadastrado;
import Interfaces.DiretorLogin;
import Personagens.Diretor;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio extends JPanel {

    public Inicio() {
        initComponents();
    }

    private void initComponents() {
        JLabel jLabel1 = new JLabel();
        JButton jButtonAluno = new JButton();
        JButton jButtonDiretor = new JButton();

        jLabel1.setText("Você é Aluno ou Diretor?");
        jButtonAluno.setText("Aluno");
        jButtonDiretor.setText("Diretor");

        jButtonAluno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Inicio.this);
                frame.dispose();
                abrirPaginaAluno();
            }
        });

        jButtonDiretor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Inicio.this);
                frame.dispose();
                abrirPaginaDiretor();
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jButtonAluno)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonDiretor)))
                .addContainerGap(155, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAluno)
                    .addComponent(jButtonDiretor))
                .addContainerGap(120, Short.MAX_VALUE))
        );
    }

    private void abrirPaginaAluno() {
        JFrame frame = new JFrame("Página Aluno");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new AlunoNovoOuCadastrado());
        frame.pack();
        frame.setVisible(true);
    }

    private void abrirPaginaDiretor() {
        JFrame frame = new JFrame("Página Diretor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new DiretorLogin());
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Início");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new Inicio());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}