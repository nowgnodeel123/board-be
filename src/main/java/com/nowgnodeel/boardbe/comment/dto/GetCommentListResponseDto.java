package com.nowgnodeel.boardbe.comment.dto;

import com.nowgnodeel.boardbe.comment.entity.Comment;

public record GetCommentListResponseDto(
        String comment
) {
    public static GetCommentListResponseDto from(Comment comment) {
        return new GetCommentListResponseDto(
                comment.getComment()
        );
    }
}
