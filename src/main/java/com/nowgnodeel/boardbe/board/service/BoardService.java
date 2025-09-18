package com.nowgnodeel.boardbe.board.service;

import com.nowgnodeel.boardbe.board.dto.CreateBoardRequestDto;
import com.nowgnodeel.boardbe.board.dto.UpdateBoardRequestDto;
import com.nowgnodeel.boardbe.board.entity.Board;
import com.nowgnodeel.boardbe.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Board createBoard(CreateBoardRequestDto requestDto) {
        Board board = Board.builder()
                .title(requestDto.title())
                .content(requestDto.content())
                .category(requestDto.category())
                .build();
        return boardRepository.save(board);
    }

    @Transactional
    public void deleteBoard(Long id) {
        if (!boardRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Board not found");
        }
        boardRepository.deleteById(id);
    }

    @Transactional
    public Board updateBoard(Long id, UpdateBoardRequestDto requestDto) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Board not found"));
        board.patch(requestDto);
        return board;
    }
}
