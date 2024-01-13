package com.example.springbootlibrary.repo;

import com.example.springbootlibrary.model.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepo extends JpaRepository<GenreEntity, Integer>, JpaSpecificationExecutor<GenreEntity> {

}
