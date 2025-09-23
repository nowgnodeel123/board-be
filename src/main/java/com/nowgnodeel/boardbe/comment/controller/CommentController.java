package com.nowgnodeel.boardbe.comment.controller;

import com.nowgnodeel.boardbe.comment.dto.CreateCommentRequestDto;
import com.nowgnodeel.boardbe.comment.dto.CreateCommentResponseDto;
import com.nowgnodeel.boardbe.comment.dto.UpdateCommentRequestDto;
import com.nowgnodeel.boardbe.comment.dto.UpdateCommentResponseDto;
import com.nowgnodeel.boardbe.comment.entity.Comment;
import com.nowgnodeel.boardbe.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards/{boardId}/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CreateCommentResponseDto> createComment(
            @PathVariable("boardId") Long boardId,
            @RequestBody CreateCommentRequestDto requestDto) {
        Comment createComment = commentService.createComment(boardId, requestDto);
        CreateCommentResponseDto responseDto = CreateCommentResponseDto.from(createComment);
        URI location = URI.create("/comments/" + createComment.getId());
        return ResponseEntity.created(location).body(responseDto);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(
            @PathVariable("boardId") Long boardId,
            @PathVariable("commentId") Long commentId) {
        commentService.deleteComment(boardId, commentId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{commentId}")
    public ResponseEntity<UpdateCommentResponseDto> updateComment(
            @PathVariable("boardId") Long boardId,
            @PathVariable("commentId") Long commentId,
            @RequestBody UpdateCommentRequestDto requestDto) {
        Comment comment = commentService.updateComment(boardId, commentId, requestDto);
        UpdateCommentResponseDto responseDto = UpdateCommentResponseDto.from(comment);
        return ResponseEntity.ok(responseDto);
    }
}
