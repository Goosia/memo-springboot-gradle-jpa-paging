package com.goosia.memo.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * 메모
 */
@Table(name = "memo")
@Entity
@Data
public class Memo {

    /**
     * 인덱스
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", nullable = false)
    @Id
    private Integer idx;

    /**
     * 내용
     */
    @Column(name = "contents")
    private String contents;

}
