package com.nowgnodeel.boardbe.board.repository;

import com.nowgnodeel.boardbe.board.common.Category;
import com.nowgnodeel.boardbe.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    Page<Board> findByCategory(Category category, Pageable pageable);
}
