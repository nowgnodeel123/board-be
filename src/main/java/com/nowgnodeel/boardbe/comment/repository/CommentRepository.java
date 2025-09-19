package com.nowgnodeel.boardbe.comment.repository;

import com.nowgnodeel.boardbe.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
