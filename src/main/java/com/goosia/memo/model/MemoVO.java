package com.goosia.memo.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class MemoVO {

    /**
     * 인덱스
     */
    @NotNull(message = "idx can not null")
    private Integer idx;


    /**
     * 내용
     */
    private String contents;

}
