package com.nowgnodeel.boardbe.user.repository;

import com.nowgnodeel.boardbe.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
