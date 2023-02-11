package com.example.springproject5.Controller;

import com.example.springproject5.Model.Book;
import com.example.springproject5.Model.Customer;
import com.example.springproject5.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {

    final private BookService bookService;

    // CRUD

    @GetMapping("/display")
    public ResponseEntity getAlLBook(){
        List<Book> cours = bookService.getBook();
        return ResponseEntity.status(200).body(cours);
    }

    //Add
    @PostMapping("/add")
    public ResponseEntity addBook(@Valid @RequestBody Book book){
        bookService.addBook(book);
        return ResponseEntity.status(200).body("Book Added");
    }

    //update
    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@Valid @RequestBody Book book, @PathVariable Integer id) {
        bookService.updateBook(id, book);
        return ResponseEntity.status(200).body("Book is updated ");
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchant(@PathVariable Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body("Book is deleted ");
    }

    // Endpoints

    // one-to-many : assign book to a store
    @PutMapping("/assignBook/{store_id}/{Book_id}")
    public ResponseEntity assignCourse(@PathVariable Integer store_id, @PathVariable Integer Book_id){
        bookService.assignBook(store_id,Book_id);
        return ResponseEntity.status(200).body("Book Have been assigned ");
    }

    //1-Create endpoint that takes storeid and return all the books
    @PutMapping("/getAllBooksByStoreId/{store_id}")
    public ResponseEntity getAllBooksById(@PathVariable Integer store_id){
        List<Book> books = bookService.getAllBooks(store_id);
        return ResponseEntity.status(200).body(books);
    }

     //2-Create endpoint that return all books under a specific genre
    @PutMapping("/getAllBooksByGenre/{genre}")
    public ResponseEntity getAllBooksByGenre(@PathVariable String genre){
        List<Book> books = bookService.getBookByGenre(genre);
        return ResponseEntity.status(200).body(books);
    }

    //3-Create endpoint that takes bookId and return number of books available
    @PutMapping("/getBookCount/{book_id}")
    public ResponseEntity getBooksCount(@PathVariable Integer book_id){
        Integer count = bookService.getBookCount(book_id);
        return ResponseEntity.status(200).body("The Number of Books Available is "+count);
    }

    //4-Create endpoint that takes a book name and return all book information

    @PutMapping("/getBookInfo/{book_name}")
    public ResponseEntity getBookInfo(@PathVariable String book_name){
        Book book = bookService.getBookByName(book_name);
        return ResponseEntity.status(200).body(book);
    }


}
