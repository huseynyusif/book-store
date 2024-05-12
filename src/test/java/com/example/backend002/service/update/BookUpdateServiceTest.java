package com.example.backend002.service.update;

import com.example.backend002.dao.entity.BookEntity;
import com.example.backend002.dao.repository.BookRepository;
import com.example.backend002.enums.BookStatus;
import com.example.backend002.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookUpdateServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookUpdateService bookUpdateService;

    @Test
    void updateBookStatus_WhenBookExists_ShouldUpdateStatus(){
        //Given
        long bookId = 1;
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(bookId);
        bookEntity.setStatus(BookStatus.ACTIVE);

        when(bookRepository.findById((int) bookId)).thenReturn(Optional.of(bookEntity));
        //When
        bookUpdateService.updateBookStatus((int) bookId, BookStatus.INACTIVE);
        //Then
        assertEquals(BookStatus.INACTIVE, bookEntity.getStatus());
        verify(bookRepository).save(bookEntity);
    }

    @Test
    void updateBookStatus_WhenBookDoesNotExist_ShouldThrowNotFoundException() {
        // Given
        int bookId = 1;
        when(bookRepository.findById(bookId)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(NotFoundException.class, () -> {
            bookUpdateService.updateBookStatus(bookId, BookStatus.INACTIVE);
        });
    }

}