package com.nowgnodeel.boardbe.board.dto;

import com.nowgnodeel.boardbe.board.common.Category;
import com.nowgnodeel.boardbe.board.entity.Board;

public record CreateBoardResponseDto(
        String title,
        String content,
        Category category
) {
    public static CreateBoardResponseDto from(Board board) {
        return new CreateBoardResponseDto(
                board.getTitle(),
                board.getContent(),
                board.getCategory()
        );
    }
}
