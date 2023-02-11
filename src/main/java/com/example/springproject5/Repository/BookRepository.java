package com.example.springproject5.Repository;

import com.example.springproject5.Model.Book;
import com.example.springproject5.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findBookById(Integer id);

    Book findBookByName(String name);

    List<Book> findBookByGenre(String genre);



}
