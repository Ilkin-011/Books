package com.atl.books.controller;

import com.atl.books.dao.entity.BookEntity;
import com.atl.books.dto.BookDto;
import com.atl.books.service.Impl.BooksServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/book")
@RequiredArgsConstructor
public class BooksController {
    private final BooksServiceImpl booksService;

    @PostMapping("/addBook")
    public ResponseEntity<Void> postUser(@RequestBody BookDto dto) {
        return booksService.addBook(dto);
    }

    @GetMapping("/get")
    public List<BookEntity> getBook(@RequestParam(value = "name", required = false) String name,
                                    @RequestParam(value = "stockCount", required = false) Integer stockCount,
                                    @RequestParam(value = "price", required = false) Double price) {

        return booksService.findBooks(name, stockCount, price);
    }

    @GetMapping("/getBook")
    public List<BookDto> getBooks(@RequestParam(value = "name", required = false) String name,
                                  @RequestParam(value = "stockCount", required = false) Integer stockCount,
                                  @RequestParam(value = "price", required = false) Double price,
                                  @RequestParam(value = "size", required = false) Integer size,
                                  @RequestParam(value = "page", required = false) Integer page) {

        return booksService.findBooksPaging(name, stockCount, price, page, size);
    }
}
