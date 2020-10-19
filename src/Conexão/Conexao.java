/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexão;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.lang.ClassNotFoundException;
/**
 *
 * @author sandy
 */
public class Conexao {
    private static final String USUARIO="PostgreSQL 10";
    private static final String SENHA="12345";
    private static final String HOST="localhost";
    private static final String DATABASE="APS_4";
    public static Connection getConnection()throws ClassNotFoundException,SQLException{
    try{
        Class.forName("org.postgresql.Driver");
        String url="jdbc:postgrest://"+ HOST+"/"+ DATABASE;
        Properties props=new Properties();
        props.setProperty("user",USUARIO);
        props.setProperty("password", SENHA);
        return DriverManager.getConnection(url,props);
    }
    catch(ClassNotFoundException e){
        throw new ClassNotFoundException("Drive JDBC do PostgreSQL não localisado:" + e.getMessage());
    }
    catch(SQLException e){
        throw new SQLException("Não foi possivel conectar com o banco de dados " +DATABASE+":" + e.getMessage());
    }
    }
}
