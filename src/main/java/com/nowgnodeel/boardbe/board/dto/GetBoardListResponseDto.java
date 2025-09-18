package com.nowgnodeel.boardbe.board.dto;

import com.nowgnodeel.boardbe.board.common.Category;
import com.nowgnodeel.boardbe.board.entity.Board;

public record GetBoardListResponseDto(
        String title,
        String content,
        Category category
) {
    public static GetBoardListResponseDto from(Board board) {
        return new GetBoardListResponseDto(
                board.getTitle(),
                board.getContent(),
                board.getCategory()
        );
    }
}
