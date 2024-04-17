package com.example.backend002.service.book;

import com.example.backend002.dao.entity.BookEntity;
import com.example.backend002.dao.entity.LibraryEntity;
import com.example.backend002.dao.repository.BookRepository;
import com.example.backend002.dao.repository.LibraryRepository;
import com.example.backend002.model.request.BookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookUpdateService {

    private final BookRepository bookRepository;
    private final LibraryRepository libraryRepository;

    public void updateBookById(Integer id, BookRequest bookRequest) {
        Optional<BookEntity> bookEntityOptional = bookRepository.findById(id);

        if (bookEntityOptional.isPresent()) {
            BookEntity bookEntity = bookEntityOptional.get();
            if (bookRequest.getAuthor() != null) {
                bookEntity.setAuthor(bookRequest.getAuthor());
            }
            if (bookRequest.getTitle() != null) {
                bookEntity.setTitle(bookRequest.getTitle());
            }
            if (bookRequest.getLibrary() != null &&
                    bookRequest.getLibrary().getId() != null) {
                Optional<LibraryEntity> libraryEntityOptional =
                        libraryRepository.findById(bookEntity.getLibrary().getId());
                if (libraryEntityOptional.isPresent()) {
                    LibraryEntity libraryEntity = libraryEntityOptional.get();
                    bookEntity.setLibrary(libraryEntity);
                }else {
                    throw new RuntimeException("A library with the specified ID was not found.");
                }
            }if (bookRequest.getLibrary() == null ||  bookRequest.getLibrary().getId() == null) {
                bookEntity.setLibrary(null);
            }
            bookRepository.save(bookEntity);
        }else {
            throw new RuntimeException("BOOK_NOT_FOUND");
        }
    }
}
