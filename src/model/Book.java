/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


/**
 *
 * @author sandy
 */
@Entity
public class Book {
    @Id
    @Column(unique=true)
    @GeneratedValue (strategy=GenerationType.IDENTITY)
   private String title;
   private String isbn;
    private float price;
   @ManyToOne
   @JoinColumn(name="publisherId")
   private int publisherId; 

    public Book(String title, String isbn, float price) {
        this.title = title;
        this.isbn = isbn;
        this.price = price;
    }

    public Book() {
    }

   public String getTitle() {
       return this.title; 
   }
   public void setTitle(String title) {
       this.title = title; 
   }

   public String getIsbn() {
       return this.isbn; 
   }
   public void setIsbn(String isbn) {
       this.isbn = isbn; 
   }

   public int getPublisherId() {
       return this.publisherId; 
   }
   public void setPublisherId(int publisherId) {
       this.publisherId = publisherId; 
   }

   public float getPrice() {
       return this.price; 
   }
   public void setPrice(float price) {
       this.price = price; 
   }
}