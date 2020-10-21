/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;
import SQL.BooksDAO;
import SQL.PublishersDAO;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import model.Book;
import model.Publisher;

@SuppressWarnings("serial")
public class ListaPublishers extends JFrame {
    
    private DefaultTableModel model = new DefaultTableModel();

    private JTable tabela;
    private JScrollPane rolagem;
    private JPanel fundo;

    public ListaPublishers() {
        super("Editora");
        criaJTable();
    }

    private void criaJTable() {

        model.addColumn("publisher_id");
        model.addColumn("name");
        model.addColumn("url");

        model.setNumRows(0);

        PublishersDAO dao = new PublishersDAO();
        for (Publisher p : dao.procurar()) {
            model.addRow(
                new Object[] {
                    p.getPublisher_id(),
                    p.getName(),
                    p.getUrl() ,
                }
            );
        }

        tabela = new JTable (model);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(400);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(60);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(60);
    }

    public void criaJanela() {

        rolagem = new JScrollPane(tabela);
        fundo = new JPanel();
        fundo.setLayout(new BorderLayout());
        fundo.add(BorderLayout.CENTER, rolagem);
        getContentPane().add(fundo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 320);
        setVisible(true);
    }
}