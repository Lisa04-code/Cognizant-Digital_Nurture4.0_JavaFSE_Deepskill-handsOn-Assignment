package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        
        BookService bookService = context.getBean("bookService", BookService.class);
        
        
        System.out.println("=== Testing Dependency Injection ===");
        bookService.performServiceOperation();
        
        
        System.out.println("\n=== Testing Book Management ===");
        bookService.addNewBook("The Picture of Dorian Gray");
        String book = bookService.getBookDetails(123);
        System.out.println("Retrieved book: " + book);
        
        System.out.println("\n=== All Tests Completed Successfully ===");
    }
}