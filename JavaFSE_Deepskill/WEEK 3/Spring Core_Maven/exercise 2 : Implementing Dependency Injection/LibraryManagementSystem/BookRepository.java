package com.library.repository;

public class BookRepository {
    public void doSomething() {
        System.out.println("BookRepository: Performing database operation...");
    }
    
    
    public void saveBook(String bookTitle) {
        System.out.println("BookRepository: Saving book '" + bookTitle + "' to database");
    }
    
    public String findBookById(int id) {
        System.out.println("BookRepository: Finding book with ID " + id);
        return "IKIGAI";
    }
}
