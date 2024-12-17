package Interfaces;


import Interfaces.AlunoCadastrado;
import Interfaces.AlunoNovo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlunoNovoOuCadastrado extends JPanel {

    public AlunoNovoOuCadastrado() {
        initComponents();
    }

    private void initComponents() {
        JLabel jLabel1 = new JLabel();
        jLabel1.setText("Você já é cadastrado ou é um aluno novo?");

        JButton jButtonAlunoNovo = new JButton("Aluno Novo");
        jButtonAlunoNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAlunoNovoInterface();
            }
        });

        JButton jButtonAlunoCadastrado = new JButton("Aluno Cadastrado");
        jButtonAlunoCadastrado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAlunoCadastradoInterface();
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(jLabel1)
                .addComponent(jButtonAlunoNovo)
                .addComponent(jButtonAlunoCadastrado)
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAlunoNovo)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAlunoCadastrado)
        );
    }

    private void showAlunoNovoInterface() {
        AlunoNovo alunoNovoPanel = new AlunoNovo();
        JFrame frame = new JFrame("Aluno Novo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(alunoNovoPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        SwingUtilities.getWindowAncestor(this).dispose();
    }

    private void showAlunoCadastradoInterface() {
        AlunoCadastrado alunoCadastradoPanel = new AlunoCadastrado();
        JFrame frame = new JFrame("Aluno Cadastrado");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(alunoCadastradoPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        SwingUtilities.getWindowAncestor(this).dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Aluno Novo Ou Cadastrado");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new AlunoNovoOuCadastrado());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
