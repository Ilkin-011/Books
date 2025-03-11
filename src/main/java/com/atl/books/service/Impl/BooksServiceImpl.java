package com.atl.books.service.Impl;

import com.atl.books.dao.entity.BookEntity;
import com.atl.books.dao.repository.BookRepository;
import com.atl.books.dto.BookDto;
import com.atl.books.mapper.BooksMapper;
import com.atl.books.service.BooksService;
import com.atl.books.service.SpecificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BooksServiceImpl implements BooksService {
    private final BookRepository repository;
    private final BooksMapper booksMapper;

    @Override
    public ResponseEntity<Void> addBook(BookDto dto) {
        repository.save(booksMapper.dtoToEntity(dto));
//        var entity = BookEntity.builder().name(dto.getName())
//                .stockCount(dto.getStockCount()).price(dto.getPrice()).build();
//        repository.save(entity);
        return ResponseEntity.ok().build();
    }

    public List<BookEntity> findBooks(String name, Integer stockCount, Double price) {
        Specification<BookEntity> specif = Specification
                .where(SpecificationService.hasName(name))
                .and(SpecificationService.hasStockCount(stockCount)
                        .and(SpecificationService.hasPrice(price)));
        return repository.findAll(specif);
    }
    public List<BookDto> findBooksPaging(
            String name, Integer stock,Double price, Integer page, Integer size) {

        Specification<BookEntity> spec =
                Specification
                        .where(SpecificationService.hasName(name))
                        .and(SpecificationService.hasPrice(price))
                        .and(SpecificationService.hasStockCount(stock));



        Pageable pageable = PageRequest.of(page, size,Sort.by("id").descending());
        Page<BookEntity> list =  repository.findAll(spec, pageable);
       return booksMapper.entityToDto(list.getContent());
    }

}
