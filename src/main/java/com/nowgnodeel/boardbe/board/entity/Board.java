package com.nowgnodeel.boardbe.board.entity;

import com.nowgnodeel.boardbe.board.common.Category;
import com.nowgnodeel.boardbe.comment.entity.Comment;
import com.nowgnodeel.boardbe.global.entity.Timestamped;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "board_id")
    @ToString.Exclude
    private List<Comment> comments = new ArrayList<>();
}
