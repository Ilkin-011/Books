package com.atl.books.service;

import com.atl.books.dao.entity.BookEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpecificationService {
    public static Specification<BookEntity> hasName(String name){
        return (root,query,criteriaBuilder) ->
                name ==null ?criteriaBuilder.isNotNull(root.get("name")) : criteriaBuilder
                        .like(root.get("name"), "%" + name + "%");

    }
        public static Specification<BookEntity>hasStockCount(Integer stockCount){
            return (root,query,criteriaBuilder) ->
                    stockCount ==null ?criteriaBuilder.isNotNull(root.get("stockCount")) : criteriaBuilder
                            .like(root.get("stockCount"), "%" + stockCount + "%");

        }
    public static Specification<BookEntity>hasPrice(Double price){
        return (root,query,criteriaBuilder) ->
                price ==null ?criteriaBuilder.isNotNull(root.get("price")) : criteriaBuilder
                        .like(root.get("stockCount"), "%" + price + "%");

    }
}
