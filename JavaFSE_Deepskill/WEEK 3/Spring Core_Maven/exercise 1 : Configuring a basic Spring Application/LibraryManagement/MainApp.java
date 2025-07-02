package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        
        BookService bookService = context.getBean("bookService", BookService.class);
        
        
        String bookInfo = bookService.getBookDetails("123-4567890");
        System.out.println(bookInfo);
        
        
        ((ClassPathXmlApplicationContext) context).close();
    }
}
