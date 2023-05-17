package com.geekster.Mapping.Practice.services;

import com.geekster.Mapping.Practice.models.Book;
import com.geekster.Mapping.Practice.models.Student;
import com.geekster.Mapping.Practice.repository.IBookRepo;
import com.geekster.Mapping.Practice.repository.IStudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    IBookRepo iBookRepo;
    @Autowired
    IStudentRepo iStudentRepo;

    public String addBook(Book book) {
        Integer id=book.getStudent().getId();
        Student studentObj=iStudentRepo.findById(id).get();
        book.setStudent(studentObj);
        iBookRepo.save(book);
        return "book added successfully";
    }

    public List<Book> getAll() {
       return iBookRepo.findAll();

    }

    @Transactional
    public String updateBook(Book book) {
        iBookRepo.updateBook(book.getId(),book.getAuthor(),book.getDescription(),book.getPrice(),book.getTitle());
        return "Book updated successfully....!!";
    }

    public String deleteBook(Integer id) {
        iBookRepo.deleteById(id);
        return "book deleted";
    }
}
