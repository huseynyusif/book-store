package com.example.backend002.service.delete;

import com.example.backend002.dao.entity.BookEntity;
import com.example.backend002.dao.repository.BookRepository;
import com.example.backend002.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class AdminDeleteServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookDeleteService adminDeleteService;


    @Test
    void deleteBook_WhenBookExists_ShouldDeleteSuccessfully() {
        // Arrange
        long bookId = 1L;
        BookEntity existingBook = new BookEntity();
        existingBook.setId(bookId);

        when(bookRepository.findById((int) bookId)).thenReturn(Optional.of(existingBook));

        // Act
        adminDeleteService.deleteBook((int) bookId);

        // Assert
        verify(bookRepository, times(1)).delete(existingBook);
    }

    @Test
    void deleteBook_WhenBookNotFound_ShouldThrowNotFoundException() {
        // Arrange
        int nonExistingBookId = 100;

        when(bookRepository.findById(nonExistingBookId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(NotFoundException.class, () -> adminDeleteService.deleteBook(nonExistingBookId));
    }
}