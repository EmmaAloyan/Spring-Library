package com.example.springbootlibrary.repo;

import com.example.springbootlibrary.model.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Integer>, JpaSpecificationExecutor<BookEntity> {

}
