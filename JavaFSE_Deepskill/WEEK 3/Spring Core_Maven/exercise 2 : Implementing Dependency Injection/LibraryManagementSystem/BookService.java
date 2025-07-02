package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    
    
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    
    public void performServiceOperation() {
        System.out.println("BookService: Beginning service operation");
        bookRepository.doSomething();
        System.out.println("BookService: Completed service operation");
    }
    
    public void addNewBook(String title) {
        System.out.println("BookService: Validating book data...");
        bookRepository.saveBook(title);
        System.out.println("BookService: Book added successfully");
    }
    
    public String getBookDetails(int bookId) {
        System.out.println("BookService: Processing book details request");
        return bookRepository.findBookById(bookId);
    }
}