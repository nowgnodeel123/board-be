package com.nowgnodeel.boardbe.board.controller;

import com.nowgnodeel.boardbe.board.dto.CreateBoardRequestDto;
import com.nowgnodeel.boardbe.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<String> createBoard(@RequestBody CreateBoardRequestDto requestDto) {
        return boardService.createBoard(requestDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBoard(@PathVariable Long id) {
        return boardService.deleteBoard(id);
    }
}