//package com.atl.books.scheduled;
//
//import com.atl.books.dao.entity.BookEntity;
//import com.atl.books.dao.repository.BookRepository;
//import com.atl.books.dto.BookDto;
//import com.atl.books.mapper.BooksMapper;
//import lombok.RequiredArgsConstructor;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//public class MyScheduled {
//private final BookRepository repository;
//private final BooksMapper booksMapper;
//    //  @Scheduled(cron = "0 33 13 * * ?")
//    @Scheduled(fixedDelay = 3000)
//    public  void printer() {
//        System.out.println(gell());
//    }
//    public List<BookDto> gell() {
//        List<BookDto>entities=booksMapper.entityToDto(repository.findAll());
//        return entities;
//    }
//}
