package com.example.springbootlibrary.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private LocalDate CreatedAt;

    @Column(name = "updated_at")
    private LocalDate UpdatedAt;

    @PrePersist
    private  void onRegister(){
        CreatedAt = LocalDate.now();
        UpdatedAt = LocalDate.now();
    }

    @PostUpdate
    private void onUpdate() {
        UpdatedAt = LocalDate.now();
    }

}
