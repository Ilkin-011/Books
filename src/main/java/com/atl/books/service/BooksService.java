package com.atl.books.service;

import com.atl.books.dto.BookDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BooksService {
    ResponseEntity<Void>addBook(BookDto dto);
    List<BookDto> findBooksPaging(
            String name, Integer stock,Double price, Integer page, Integer size) ;
    }

