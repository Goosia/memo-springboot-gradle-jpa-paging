package com.goosia.memo.model;


import lombok.Data;

@Data
public class MemoQueryVO {

    /**
     * 인덱스
     */
    private Integer idx;


    /**
     * 내용
     */
    private String contents;

}
