package Interfaces;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableCellRenderer;

public class DiretorPesquisa extends JPanel {

    private JTextField jTextFieldPesquisa;
    private JButton jButtonPesquisar;
    private JTable jTableAlunos;
    private TableRowSorter<DefaultTableModel> rowSorter;

    public DiretorPesquisa() {
        initComponents();
    }

    private void initComponents() {
        jTextFieldPesquisa = new JTextField(20);
        jButtonPesquisar = new JButton("Pesquisar");
        jTableAlunos = new JTable();

        jButtonPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = jTextFieldPesquisa.getText();
                filterAlunos(searchTerm);
            }
        });

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nome");
        model.addColumn("Sobrenome");
        model.addColumn("E-mail");
        model.addColumn("Casa");
        jTableAlunos.setModel(model);

        JScrollPane jScrollPane = new JScrollPane(jTableAlunos);

        rowSorter = new TableRowSorter<>(model);
        jTableAlunos.setRowSorter(rowSorter);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPesquisar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap())
        );

     
        fillTableWithInitialData(model);
    }

    private void fillTableWithInitialData(DefaultTableModel model) {
        
        model.addRow(new Object[]{"Amanda", "Rost", "amanda@gmail.com", "Corvinal"});
        model.addRow(new Object[]{"Pietra", "Machado", "pietra@gmail.com", "Sonserina"});
        model.addRow(new Object[]{"Anna", "Borges", "anna@gmail.com", "Grifinoria"});
        model.addRow(new Object[]{"Nicolas", "Rosa", "nicolas@gmail.com", "Lufa-Lufa"});
    }

    private void filterAlunos(String searchTerm) {
        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchTerm, 2)); // Apply filter only to the third column (E-mail)
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Diretor Interface de Pesquisa");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new DiretorPesquisa());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
