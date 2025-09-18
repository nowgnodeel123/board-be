package com.nowgnodeel.boardbe.board.dto;

import com.nowgnodeel.boardbe.board.common.Category;
import com.nowgnodeel.boardbe.board.entity.Board;

public record UpdateBoardResponseDto(
        String title,
        String content,
        Category category
) {
    public static UpdateBoardResponseDto from(Board board) {
        return new UpdateBoardResponseDto(
                board.getTitle(),
                board.getContent(),
                board.getCategory()
        );
    }
}
