package com.example.springbootlibrary.repo;

import com.example.springbootlibrary.model.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<AuthorEntity, Integer>, JpaSpecificationExecutor<AuthorEntity> {

}
