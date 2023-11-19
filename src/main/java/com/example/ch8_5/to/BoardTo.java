package com.example.ch8_5.to;

import lombok.Data;

@Data
public class BoardTo {
    private int bno;
    private String title;
    private String writer;
    private String content;
    private String writeDate;
    private String updateDate;
    private int boardLike;
    private String deletedYn;
}
