package com.khavspring.books_store.service;

import com.khavspring.books_store.dto.BookDto;

import java.util.List;

public interface BookService {

    public BookDto getBook(String bookId);

    public List<BookDto> getAllBooks();

    public BookDto createBook(BookDto bookDto);

    public BookDto updateBookName(BookDto bookDto);

    public void deleteBookById(String bookId);
}
