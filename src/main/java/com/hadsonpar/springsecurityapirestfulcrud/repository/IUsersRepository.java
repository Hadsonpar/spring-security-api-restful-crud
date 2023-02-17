package com.hadsonpar.springsecurityapirestfulcrud.repository;

import com.hadsonpar.springsecurityapirestfulcrud.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
