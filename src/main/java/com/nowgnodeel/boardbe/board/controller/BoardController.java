package com.nowgnodeel.boardbe.board.controller;

import com.nowgnodeel.boardbe.board.dto.CreateBoardRequestDto;
import com.nowgnodeel.boardbe.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<String> createBoard(@RequestBody CreateBoardRequestDto requestDto) {
        return boardService.createBoard(requestDto);
    }
}
