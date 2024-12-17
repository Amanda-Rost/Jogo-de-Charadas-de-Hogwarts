package Interfaces;
/**
 *
 * @author 08050519
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiretorInterfacePrincipal extends JPanel {

    public DiretorInterfacePrincipal() {
        initComponents();
    }

    private void initComponents() {
        JButton jButtonLista = new JButton("Ir para solicitações de alunos");
        JButton jButtonPesquisa = new JButton("Ir para lista de alunos cadastrados");

        jButtonLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openDiretorLista();
            }
        });

        jButtonPesquisa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openDiretorPesquisa();
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonLista)
                    .addComponent(jButtonPesquisa))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jButtonLista)
                .addGap(18, 18, 18)
                .addComponent(jButtonPesquisa)
                .addContainerGap(100, Short.MAX_VALUE))
        );
    }

    private void openDiretorLista() {
        JFrame frame = new JFrame("Cadastrados");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        frame.add(new DiretorLista());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void openDiretorPesquisa() {
        JFrame frame = new JFrame("Solicitações");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        frame.add(new DiretorPesquisa());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Painel Diretor");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new DiretorInterfacePrincipal());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
