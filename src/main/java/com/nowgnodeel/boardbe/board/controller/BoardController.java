package com.nowgnodeel.boardbe.board.controller;

import com.nowgnodeel.boardbe.board.dto.*;
import com.nowgnodeel.boardbe.board.entity.Board;
import com.nowgnodeel.boardbe.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<CreateBoardResponseDto> createBoard(@RequestBody CreateBoardRequestDto requestDto) {
        Board createBoard = boardService.createBoard(requestDto);
        CreateBoardResponseDto responseDto = CreateBoardResponseDto.from(createBoard);
        URI location = URI.create("/boards/" + createBoard.getId());
        return ResponseEntity.created(location).body(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UpdateBoardResponseDto> updateBoard(@PathVariable Long id, @RequestBody UpdateBoardRequestDto requestDto) {
        Board updateBoard = boardService.updateBoard(id, requestDto);
        UpdateBoardResponseDto responseDto = UpdateBoardResponseDto.from(updateBoard);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<Page<GetBoardListResponseDto>> getAllBoards(Pageable pageable, @RequestParam(required = false) String category) {
        Page<GetBoardListResponseDto> boardList = boardService.getAllBoards(pageable, category);
        return ResponseEntity.ok(boardList);
    }
}