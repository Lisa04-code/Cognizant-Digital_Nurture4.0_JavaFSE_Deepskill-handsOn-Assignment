package com.library.repository;

public class BookRepository {
    
    public String getBookInfo(String isbn) {
        return "Book details for ISBN: " + isbn;
    }
}
