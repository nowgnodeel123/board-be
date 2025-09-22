package com.nowgnodeel.boardbe.comment.controller;

import com.nowgnodeel.boardbe.comment.dto.CreateCommentRequestDto;
import com.nowgnodeel.boardbe.comment.dto.CreateCommentResponseDto;
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
            @PathVariable("commentId") Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }
}
