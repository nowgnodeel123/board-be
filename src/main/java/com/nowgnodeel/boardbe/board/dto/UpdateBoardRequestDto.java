package com.nowgnodeel.boardbe.board.dto;

import com.nowgnodeel.boardbe.board.common.Category;

public record UpdateBoardRequestDto(
        String title,
        String content,
        Category category
) {
}
