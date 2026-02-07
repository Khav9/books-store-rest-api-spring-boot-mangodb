package com.khavspring.books_store.Controller;

import com.khavspring.books_store.dto.BookDto;
import com.khavspring.books_store.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book-store")
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/welcome")
    public ResponseEntity<String> welcomeMessage() {
        return new ResponseEntity<>("Welcome to Book Store", HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDto> getBook(@PathVariable String bookId){
        BookDto bookDto = bookService.getBook(bookId);
        return new ResponseEntity<>(bookDto, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<BookDto>> getAllBooks()
    {
        List<BookDto> bookDtoList = bookService.getAllBooks();

        return new ResponseEntity<>(bookDtoList, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto)
    {
        BookDto bookDto1 = bookService.createBook(bookDto);
        return new ResponseEntity<>(bookDto1, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto)
    {
        BookDto bookDto1 = bookService.updateBookName(bookDto);
        return new ResponseEntity<>(bookDto1, HttpStatus.OK);
    }

    @DeleteMapping("/{bookId}")
    public  ResponseEntity<String> deleteBook(@PathVariable String bookId)
    {
        bookService.deleteBookById(bookId);
        return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
    }
}
