package com.example.backend002.service.save;

;
import com.example.backend002.dao.entity.BookEntity;
import com.example.backend002.dao.repository.BookRepository;
import com.example.backend002.enums.BookStatus;
import com.example.backend002.exceptions.NotFoundException;
import com.example.backend002.model.request.save.BookSaveRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookSaveServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookSaveService bookSaveService;

    @Test
    void saveBook_WhenBookExists_ShouldUpdateBookStatus() {
        // Arrange
        long bookId = 1;
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(bookId);
        bookEntity.setStatus(BookStatus.INACTIVE);

        BookSaveRequest saveRequest = new BookSaveRequest();
        saveRequest.setStatus(BookStatus.ACTIVE);

        when(bookRepository.findById((int) bookId)).thenReturn(Optional.of(bookEntity));

        // Act
        bookSaveService.saveBook((int) bookId, saveRequest);

        // Assert
        assertEquals(BookStatus.ACTIVE, bookEntity.getStatus());
        verify(bookRepository).save(bookEntity);
    }

    @Test
    void saveBook_WhenBookDoesNotExist_ShouldThrowNotFoundException() {
        // Arrange
        int bookId = 1;
        when(bookRepository.findById(bookId)).thenReturn(Optional.empty());
        BookSaveRequest saveRequest = new BookSaveRequest();

        // Act & Assert
        assertThrows(NotFoundException.class, () -> {
            bookSaveService.saveBook(bookId, saveRequest);
        });
    }
}