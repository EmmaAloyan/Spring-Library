package com.example.springbootlibrary.config;

import com.example.springbootlibrary.model.entity.RoleEntity;
import com.example.springbootlibrary.repo.RoleRepo;
import com.example.springbootlibrary.util.constants.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitRoleData {

    private final RoleRepo roleRepo;

  // @PostConstruct
    public void init() {
        roleRepo.save(RoleEntity.builder().name(Role.USER).build());
        roleRepo.save(RoleEntity.builder().name(Role.ADMIN).build());
    }
}
