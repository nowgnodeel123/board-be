package com.nowgnodeel.boardbe.board.service;

import com.nowgnodeel.boardbe.board.dto.CreateBoardRequestDto;
import com.nowgnodeel.boardbe.board.entity.Board;
import com.nowgnodeel.boardbe.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public ResponseEntity<String> createBoard(CreateBoardRequestDto requestDto) {
        Board board = Board.builder()
                .title(requestDto.title())
                .content(requestDto.content())
                .category(requestDto.category())
                .build();

        boardRepository.save(board);

        return ResponseEntity.ok().body("Board created successfully");
    }

    @Transactional
    public ResponseEntity<String> deleteBoard(Long id) {
        boardRepository.deleteById(id);

        return ResponseEntity.ok().body("Board deleted successfully");
    }
}
