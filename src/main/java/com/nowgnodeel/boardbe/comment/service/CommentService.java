package com.nowgnodeel.boardbe.comment.service;

import com.nowgnodeel.boardbe.board.entity.Board;
import com.nowgnodeel.boardbe.board.repository.BoardRepository;
import com.nowgnodeel.boardbe.comment.dto.CreateCommentRequestDto;
import com.nowgnodeel.boardbe.comment.entity.Comment;
import com.nowgnodeel.boardbe.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public Comment createComment(Long boardId, CreateCommentRequestDto requestDto) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        Comment comment = Comment.builder()
                .comment(requestDto.comment())
                .build();
        board.addComment(comment);
        return comment;
    }

    @Transactional
    public void deleteComment(Long boardId, Long commentId) {
        boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("Board not found"));
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found"));
        commentRepository.deleteById(comment.getId());
    }
}
