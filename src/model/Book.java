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
public class Book {

   private String title;
   private String isbn;
   private int publisherId;
   private float price;

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