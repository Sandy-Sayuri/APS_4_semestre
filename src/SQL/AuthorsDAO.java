/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Author;
import model.AuthorBD;

/**
 *
 * @author sandy
 */
public class AuthorsDAO {
    private Connection connecion;
     public  AuthorsDAO (Connection connecion) {
        this.connecion = connecion;
        }

    public AuthorsDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<Author> procurar() {
        List<Author> author = new ArrayList<Author>();
        try {
            String SQL = "SELECT * FROM books";
            PreparedStatement stmt = connecion.prepareStatement(SQL);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                Author a = new Author();
                a.setNome(rs.getString("name"));
                a.setFname(rs.getString("fname"));
                a.setAuthor_id(rs.getInt("author_id"));
                author.add(a);

            }
            rs.close();
            stmt.close();
            connecion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível obter a listagem dos livros: " + e.getMessage());
        }

        return author;
    }
        public void insert(Author author) throws SQLException{
           try { 
            String SQL = "INSERT INTO public.authors (name, fname) VALUES ( '"+author.getNome()+"', '"+author.getFname()+"')";
            PreparedStatement stam=connecion.prepareStatement(SQL);
            stam.execute();
            connecion.close();
           }
            catch (Exception e) {
                System.err.println("[Erro] problema no  incert autor"+e);
        }
    } 
        public void modificar(Author author,AuthorBD bd)throws SQLException{
            try{
                String SQL="UPDATE public.authors SET  name='"+author.getNome()+"', fname='"+author.getFname()+"'WHERE( name='"+bd.getNome()+"'and fname='"+bd.getFname()+"');";
            PreparedStatement stam=connecion.prepareStatement(SQL);
            stam.execute();
            connecion.close();
            }
            catch(Exception e) {
                System.err.println("[Erro] problema em  modificar autor"+e);
            }
        }
        public void excluir(Author author)throws SQLException{
            try{
                 String SQL = "DELETE FROM public.authors WHERE name='"+author.getNome()+"'and fname='"+author.getFname()+"';";
                 PreparedStatement stam=connecion.prepareStatement(SQL);
                stam.execute();
                connecion.close();
            }
            catch (Exception e) {
                System.err.println("[Erro] problema em excluir autor"+e);
            }
        }
    }

