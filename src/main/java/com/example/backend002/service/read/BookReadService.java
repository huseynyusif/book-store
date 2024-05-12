package com.example.backend002.service.read;

import com.example.backend002.dao.entity.BookEntity;
import com.example.backend002.dao.repository.BookRepository;
import com.example.backend002.mapper.BookMapper;
import com.example.backend002.model.response.BookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookReadService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    

    public List<BookResponse> findBooksByCostRange(Integer minCost, Integer maxCost) {
        List<BookEntity> books = bookRepository.findByCostBetween(minCost, maxCost);
        return books.stream()
                .map(bookMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    public List<BookResponse> findByTitleStartingWith(String prefix){
        List<BookEntity> bookEntities = bookRepository.findByTitleStartingWith(prefix);
        return bookEntities.stream()
                .map(bookMapper::entityToResponse)
                .collect(Collectors.toList());
    }
}
