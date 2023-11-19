package com.example.ch8_5.mapper;

import com.example.ch8_5.to.BoardTo;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface BoardMapper {
    public ArrayList<BoardTo> selectBoardAll();

    public BoardTo selectBoardByBno(BoardTo boardTo);

    public void insertBoard(BoardTo boardTo);

    public void updateBoard(BoardTo boardTo);

    public void hideBoard(BoardTo boardTo);

    public void deleteBoard(BoardTo boardTo);
}
