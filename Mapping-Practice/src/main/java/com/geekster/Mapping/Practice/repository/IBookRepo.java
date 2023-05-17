package com.geekster.Mapping.Practice.repository;

import com.geekster.Mapping.Practice.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepo extends JpaRepository<Book,Integer> {
    @Modifying
    @Query(value = "update book set author=:author,description=:description,price=:price,title=:title where id=:id",nativeQuery = true)
    void updateBook(Integer id, String author, String description, String price, String title);
}
