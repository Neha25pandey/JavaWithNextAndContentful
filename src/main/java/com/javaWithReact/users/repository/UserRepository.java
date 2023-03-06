package com.javaWithReact.users.repository;

import com.javaWithReact.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {
}
