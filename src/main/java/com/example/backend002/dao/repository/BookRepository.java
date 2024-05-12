package com.example.backend002.dao.repository;

import com.example.backend002.dao.entity.BookEntity;
import com.example.backend002.enums.BookStatus;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    List<BookEntity> findByIdIn(List<Integer> ids);

    @Query("SELECT b.id FROM BookEntity b WHERE b.status = 'ACTIVE'")
    List<Integer> findActiveBookIds();


    List<BookEntity> findByCostBetween(Integer minCost, Integer maxCost);

    Optional<BookEntity> findByStatus(BookStatus bookStatus);

    @Query("SELECT b FROM BookEntity b WHERE b.title ILIKE CONCAT('%',:prefix, '%')")
    List<BookEntity> findByTitleStartingWith(@Param("prefix") String prefix);
}
