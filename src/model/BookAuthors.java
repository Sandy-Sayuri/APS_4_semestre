/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author sandy
 */
public class BookAuthors {
   @Id
   @Column(unique=true)
   @GeneratedValue (strategy=GenerationType.IDENTITY)
   private int BookAuthors_id ;
   @ManyToOne
   @JoinColumn(name="author_id")
   private int author_id ;
   @ManyToOne
   @JoinColumn(name="isbn")
   private String isbn;

    public BookAuthors() {
    }

    public int getBookAuthors_id() {
        return BookAuthors_id;
    }

    public void setBookAuthors_id(int BookAuthors_id) {
        this.BookAuthors_id = BookAuthors_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
   
}
