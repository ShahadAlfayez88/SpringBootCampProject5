package com.example.springproject5.Service;

import com.example.springproject5.Exception.ApiException;
import com.example.springproject5.Model.Book;
import com.example.springproject5.Model.Customer;
import com.example.springproject5.Model.Store;
import com.example.springproject5.Repository.BookRepository;
import com.example.springproject5.Repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final StoreRepository storeRepository;
    // ADD
    public void addBook(Book book){
        bookRepository.save(book);
    }

    // Display
    public List<Book> getBook(){
        return  bookRepository.findAll();
    }

    // update
    public void updateBook(Integer id, Book book) {
        Book newBook = bookRepository.findBookById(id);
        if (newBook == null) {
            throw new ApiException("Book not found!!");
        }
       bookRepository.save(book);
    }

    // delete

    public void deleteBook(Integer id) {
        Book book = bookRepository.findBookById(id);
        if (book ==null) {
            throw new ApiException("Id is not found");
        }
        bookRepository.delete(book);
    }

    public void assignBook(Integer store_id , Integer Book_id){

        Store store = storeRepository.findStoreById(store_id);
        Book book = bookRepository.findBookById(Book_id);

        if (store ==null || book ==null ) {
            throw new ApiException("Id is not found");
        }
        book.setStore(store);
        bookRepository.save(book);

    }

    public List<Book>  getBookByGenre(String genre){
        List<Book>  books = bookRepository.findBookByGenre(genre);
        if (books.isEmpty()) {
            throw new ApiException("Id is not found");
        }
        else return books;
    }

    public List<Book> getAllBooks(Integer store_id){
        Store store = storeRepository.findStoreById(store_id);
        if (store ==null ) {
            throw new ApiException("Id is not found");
        }
        return store.getBooks();
    }

    public Integer getBookCount(Integer book_id){
        Book book = bookRepository.findBookById(book_id);
        if (book ==null ) {
            throw new ApiException("Id is not found");
        }
        return book.getBookCount();
    }

    public Book getBookByName(String name){
        Book book = bookRepository.findBookByName(name);
        if (book == null) {
            throw new ApiException("Id is not found");
        }
         return book;
    }


}
