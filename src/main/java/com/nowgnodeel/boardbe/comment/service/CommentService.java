package com.nowgnodeel.boardbe.comment.service;

import com.nowgnodeel.boardbe.board.entity.Board;
import com.nowgnodeel.boardbe.board.repository.BoardRepository;
import com.nowgnodeel.boardbe.comment.dto.CreateCommentRequestDto;
import com.nowgnodeel.boardbe.comment.dto.GetCommentListResponseDto;
import com.nowgnodeel.boardbe.comment.dto.UpdateCommentRequestDto;
import com.nowgnodeel.boardbe.comment.entity.Comment;
import com.nowgnodeel.boardbe.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public Comment createComment(Long boardId, CreateCommentRequestDto requestDto) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        Comment comment = Comment.builder()
                .comment(requestDto.comment())
                .build();
        board.addComment(comment);
        return comment;
    }

    @Transactional
    public void deleteComment(Long boardId, Long commentId) {
        boardRepository.findById(boardId).orElseThrow(() -> new RuntimeException("Board not found"));
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found"));
        commentRepository.deleteById(comment.getId());
    }

    @Transactional
    public Comment updateComment(Long boardId, Long commentId, UpdateCommentRequestDto requestDto) {
        boardRepository.findById(boardId).orElseThrow(() -> new RuntimeException("Board not found"));
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new RuntimeException("Comment not found"));
        comment.patch(requestDto);
        return comment;
    }

    @Transactional(readOnly = true)
    public Page<GetCommentListResponseDto> getAllComments(Long boardId, Pageable pageable) {
        boardRepository.findById(boardId).orElseThrow(() -> new RuntimeException("Board not found"));
        Page<Comment> commentPage = commentRepository.findByBoardId(boardId, pageable);
        return commentPage.map(GetCommentListResponseDto::from);
    }
}
