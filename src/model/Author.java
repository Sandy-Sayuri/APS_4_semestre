/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author sandy
 */
public class Author {
    private String nome;
    private String fname;
    private int author_id ;

    public Author() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public Author(String nome, String fname) {
        this.nome = nome;
        this.fname = fname;
    }
}
