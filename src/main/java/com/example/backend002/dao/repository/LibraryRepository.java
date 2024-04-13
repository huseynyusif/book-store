package com.example.backend002.dao.repository;

import com.example.backend002.dao.entity.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<LibraryEntity,Integer> {

}
