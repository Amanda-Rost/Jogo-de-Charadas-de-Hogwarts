/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Caracteristicas.Charada;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


/**
 *
 * @autoras: Amanda e Pietra
 */
public class Charadas extends JPanel {

    private static Charada c = new Charada();
    ;
    private JPanel painel1;
    private JLabel jLabel1;
    private JButton jcerta, jerrada1, jerrada2;
    public static Charadas cha;
    private static JFrame frame = new JFrame("Charadas");

    public Charadas(Charada c) {
        Objects.requireNonNull(c, "Deve haver charadas");
        initComponents(c);
    }

    private void initComponents(Charada cha) {

        jLabel1 = new JLabel(cha.falaCharada());
        this.add(jLabel1);

        jerrada1 = new JButton(cha.imprimeRespErrada());
        jerrada1.setName("errada");
        this.add(jerrada1);
        jcerta = new JButton(cha.falaResp());
        jcerta.setName("certa");
        this.add(jcerta);
        jerrada2 = new JButton(cha.imprimeRespErrada());
        jerrada2.setName("errada");
        this.add(jerrada2);

        ButtonOuvinte handler = new ButtonOuvinte();
        jcerta.addActionListener(handler);
        jerrada1.addActionListener(handler);
        jerrada2.addActionListener(handler);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            c.insereCharadas("O que veio primeiro? A fenix ou a chama", "Um circulo nao tem principio, um circulo nao tem comeco");
            c.insereCharadas("Qual seria um nome melhor do que rei da selva para um leao?", "Emperoar");
            c.insereCharadas("Do que voce pode encher o barril para ele ficar mais leve?", "Buracos");
            c.insereRespErrada("Fenix");
            c.insereRespErrada("Imperador");
            c.insereRespErrada("ar");
            c.insereRespErrada("burro");
            c.insereRespErrada("gas");
            c.insereRespErrada("incapaz");

            proximaCharada();

        });

    }

    private static void proximaCharada() {

        cha = new Charadas(c);
        frame.add(cha);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static Charadas getJanela() {
        return cha;
    }

    private class ButtonOuvinte implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            JButton bt1 = (JButton) ae.getSource();
            if (bt1.getName().equals("certa")) {
                JOptionPane.showMessageDialog(Charadas.getJanela(), "Voce acertou :D");
                frame.remove(cha);
                if (c.getNumPerg().hasNext()) {
                    proximaCharada();
                } else {
                    JOptionPane.showMessageDialog(Charadas.getJanela(), "Voce terminou o jogo parabens !!!!");
                    JOptionPane.showMessageDialog(Charadas.getJanela(), "Aguarde o restante das equipes concluírem as charadas."
                            + "\n ------------------Lembre-se de sair da sua conta!------------------");
                    //TODO: marcar o tempo de fim da partida
                    frame.dispose();

                }
            } else {
                JOptionPane.showMessageDialog(Charadas.getJanela(), "Voce errou  :(\nTente novamente");
            }

        }
    }

}
