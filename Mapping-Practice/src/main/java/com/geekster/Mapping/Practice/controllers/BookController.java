package com.geekster.Mapping.Practice.controllers;

import com.geekster.Mapping.Practice.models.Book;
import com.geekster.Mapping.Practice.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/addBook")
    public String addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }
    @GetMapping("/getAll")
    public List<Book> getAll(){
        return bookService.getAll();
    }
    @PutMapping("/updateBook")
    public String updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }
    @DeleteMapping("deleteBook/{id}")
    public String deleteBook(@PathVariable Integer id){
        return bookService.deleteBook(id);
    }
}
