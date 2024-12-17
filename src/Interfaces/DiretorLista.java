package Interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class DiretorLista extends JPanel {

    private JTable jTableAlunos;
    private JButton jButtonAceitar;
    private JButton jButtonRejeitar;

    public DiretorLista() {
        initComponents();
    }

    private void initComponents() {
        jTableAlunos = new JTable();
        populateTable(); 

        jButtonAceitar = new JButton("Aceitar");
        jButtonRejeitar = new JButton("Rejeitar");
        
        jButtonAceitar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jTableAlunos.getSelectedRow();
                if (selectedRow != -1) {
                   
                    ((DefaultTableModel) jTableAlunos.getModel()).removeRow(selectedRow);
                }
            }
        });
        
        jButtonRejeitar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jTableAlunos.getSelectedRow();
                if (selectedRow != -1) {
                   
                    ((DefaultTableModel) jTableAlunos.getModel()).removeRow(selectedRow);
                }
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTableAlunos, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jButtonAceitar)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonRejeitar)
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTableAlunos, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceitar)
                    .addComponent(jButtonRejeitar))
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }

    private void populateTable() {
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nome");
        model.addColumn("Sobrenome");
        model.addColumn("E-mail");
         model.addRow(new Object[]{"Arthur", "Costa", "arthurc@gmail.com","Corvinal"});
        model.addRow(new Object[]{"Arthur", "Stedile", "arthurs@gmail.com","Grifinória"});
        model.addRow(new Object[]{"Caio", "Souza", "caio@gmail.com","Corvinal"});
        model.addRow(new Object[]{"Giovana", "Vargas", "giovana@gmail.com","Sonserina"});
        model.addRow(new Object[]{"Camila", "Cunha", "camila@gmail.com","Sonseria"});
        model.addRow(new Object[]{"Isadora", "Ribeiro", "isadorar@gmail.com","Sonserina"});
        model.addRow(new Object[]{"Isadora", "Soares", "isadoras@gmail.com","Grifinória"});
        model.addRow(new Object[]{"Thayla", "Silva", "thayla@gmail.com","Lufa-Lufa"});
        model.addRow(new Object[]{"Lucas", "Portal", "lucas@gmail,com","Grifinória"});
        model.addRow(new Object[]{"Arthur", "Velasco", "arthurv@gmail.com","Lufa-Lufa"});
        model.addRow(new Object[]{"Ben-Hur", "Toledo", "benhur@gmail.com","Lufa-Lufa"});

        
        jTableAlunos.setModel(model);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Diretor Lista");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new DiretorLista());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
