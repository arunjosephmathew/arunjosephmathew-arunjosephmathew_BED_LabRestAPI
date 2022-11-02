package com.greatlearning.debateRegistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.debateRegistration.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
