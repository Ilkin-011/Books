package com.atl.books.mapper;

import com.atl.books.dao.entity.BookEntity;
import com.atl.books.dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface BooksMapper {
    BookEntity dtoToEntity(BookDto dto);
    List<BookDto>entityToDto(List<BookEntity> dto);
}
