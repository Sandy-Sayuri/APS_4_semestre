/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

import SQL.AuthorsDAO;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Author;


/**
 *
 * @author sandy
 */
@SuppressWarnings("serial")
public class ListaAutores extends JFrame {
    
    private DefaultTableModel model = new DefaultTableModel();

    private JTable tabela;
    private JScrollPane rolagem;
    private JPanel fundo;

    public ListaAutores() {
        super("Autores");
        criaJTable();
    }

    private void criaJTable() {

        model.addColumn("name");
        model.addColumn("fname");
        model.addColumn("author_id");

        model.setNumRows(0);

        AuthorsDAO dao = new AuthorsDAO();
        for ( Author a : dao.procurar()) {
            model.addRow(
                new Object[] {
                    a.getNome(),
                    a.getFname(),
                    a.getAuthor_id()
                }
            );
        }

        tabela = new JTable (model);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(400);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
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

