package com.nowgnodeel.boardbe.comment.dto;

import com.nowgnodeel.boardbe.comment.entity.Comment;

public record UpdateCommentResponseDto(
        String comment
) {
    public static UpdateCommentResponseDto from(Comment comment) {
        return new UpdateCommentResponseDto(
                comment.getComment()
        );
    }
}
