/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;
import Conexão.Conexao;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Author;
import model.Book;
import model.BookBD;

public class BooksDAO {
     private Connection connecion;
     public  BooksDAO (Connection connecion) {
        this.connecion = connecion;
        }
    private final String SQL = "SELECT * FROM books";

    public BooksDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Book> getListaDeLivros() {

        List<Book> books = new ArrayList<Book>();

        try {
            PreparedStatement stmt = connecion.prepareStatement(SQL);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {

                Book b = new Book();
                b.setTitle(rs.getString("title"));
                b.setIsbn(rs.getString("isbn"));
                b.setPublisherId(rs.getInt("publisher_id"));
                b.setPrice(rs.getFloat("price"));

                books.add(b);

            }

            rs.close();
            stmt.close();
           connecion.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível obter a listagem dos livros: " + e.getMessage());
        }

        return books;
    }

    public void insert(Book book) throws SQLException{
        try{
        String SQL = "INSERT INTO public.books (title, isbn,price) VALUES ( '"+book.getTitle()+"', '"+book.getIsbn()+"','"+book.getPrice()+"');";
        PreparedStatement stam=connecion.prepareStatement(SQL);
        stam.execute();
        connecion.close();
        }
        catch(Exception e){
            System.err.println("[Erro] problema no  incert livros"+e);
        }
    }
    public void modificar(Book book,BookBD bd){
            try{
                String SQL="UPDATE public.books SET  title='"+book.getTitle()+"', isbn='"+book.getIsbn()+"',price='"+book.getPrice()+"'WHERE( title='"+bd.getTitle()+"'and isbn='"+bd.getIsbn()+"'price='"+bd.getPrice()+"');";
                PreparedStatement stam=connecion.prepareStatement(SQL);
                stam.execute();
                connecion.close();
            }
            catch(Exception e) {
                System.err.println("[Erro] problema no  modificar livros"+e);
            }
    } 
     public void excluir(Book book)throws SQLException{
            try{
                 String SQL = "DELETE FROM public.authors WHERE title='"+book.getTitle()+"'and isbn='"+book.getIsbn()+"'and price='"+book.getPrice()+"';";
                 PreparedStatement stam=connecion.prepareStatement(SQL);
                stam.execute();
                connecion.close();
            }
            catch (Exception e) {
                System.err.println("[Erro] problema em excluir livros"+e);
            }
        }
}