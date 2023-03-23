package com.goosia.memo.model;


import lombok.Data;

@Data
public class MemoDTO {

    /**
     * 인덱스
     */
    private Integer idx;


    /**
     * 내용
     */
    private String contents;

}
