package com.nowgnodeel.boardbe.comment.dto;

import com.nowgnodeel.boardbe.comment.entity.Comment;

public record CreateCommentResponseDto(
        String comment
) {
    public static CreateCommentResponseDto from(Comment comment) {
        return new CreateCommentResponseDto(
                comment.getComment()
        );
    }
}
