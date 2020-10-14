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
import model.Book;
import model.Publisher;
import model.PublisherBD;

/**
 *
 * @author sandy
 */
public class PublishersDAO {
     private Connection connecion;
     
      public   PublishersDAO  (Connection connecion) {
        this.connecion = connecion;
        }

    public PublishersDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<Publisher> procurar() {
        List<Publisher> publishers = new ArrayList<Publisher>();
        try {
            String SQL = "SELECT * FROM publishers";
            PreparedStatement stmt = connecion.prepareStatement(SQL);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                Publisher p = new Publisher();
                p.setPublisher_id(rs.getInt("publisher_id"));
                p.setName(rs.getString("name"));
                p.setUrl(rs.getString("url"));
                publishers.add(p);

            }
            rs.close();
            stmt.close();
            connecion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível obter a listagem dos editores: " + e.getMessage());
        }

        return publishers;
    }
    public void insert(Publisher Publisher) throws SQLException{
        try{
        String SQL = "INSERT INTO public.publishers(name, url) VALUES ( '"+Publisher.getName()+"', '"+Publisher.getUrl()+"');";
        PreparedStatement stam=connecion.prepareStatement(SQL);
//        stam.execute();
        connecion.close();
        }
        catch(Exception e){
            System.err.println("[Erro] problema no  incert editores"+e);
        }
    }
    public void modificar(Publisher p,PublisherBD bd){
            try{
                String SQL="UPDATE public.books SET name='"+p.getName()+"'url='"+p.getUrl()+"'WHERE( name='"+bd.getName()+"'url='"+bd.getUrl()+"');";
                PreparedStatement stam=connecion.prepareStatement(SQL);
                stam.execute();
                connecion.close();
            }
            catch(Exception e) {
                System.err.println("[Erro] problema no  modificar editores"+e);
            }
    } 
    public void excluir(Publisher p)throws SQLException{
            try{
                 String SQL = "DELETE FROM public.authors WHERE name='"+p.getName()+"'and url='"+p.getUrl()+"';";
                 PreparedStatement stam=connecion.prepareStatement(SQL);
                stam.execute();
                connecion.close();
            }
            catch (Exception e) {
                System.err.println("[Erro] problema em excluir livros"+e);
            }
        }
}
