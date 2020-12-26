package com.hussam.inventory.inventory.repositories;

import com.hussam.inventory.inventory.entities.Role;
import com.hussam.inventory.inventory.entities.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleType(RoleType roleType);

}
