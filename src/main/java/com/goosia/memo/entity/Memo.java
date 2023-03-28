package com.goosia.memo.entity;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 메모
 */
@Table(name = "memo")
@EnableJpaRepositories
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
