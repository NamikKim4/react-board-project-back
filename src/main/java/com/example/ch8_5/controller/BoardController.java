package com.example.ch8_5.controller;

import com.example.ch8_5.service.BoardService;
import com.example.ch8_5.to.BoardTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//    BoardTo findBoardByBno(BoardTo boardTo);
//
//    void registerBoard(BoardTo boardTo);
//
//    void modifyBoard(BoardTo boardTo);
//
//    void concealBoard(BoardTo boardTo);
//
//    void removeBoard(BoardTo boardTo);

@CrossOrigin("*")
@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 보드리스트 조회
    @GetMapping("/board")
    public ResponseEntity<Map<String, Object>> findBoardAll() {
        Map<String, Object> map = new HashMap<>();
        try {
            ArrayList<BoardTo> boardList = boardService.findBoardAll();
            map.put("boardList", boardList);
            map.put("errorMsg", "success");
            map.put("errorCode", 0);
            return ResponseEntity.status(HttpStatus.OK).body(map);
        } catch (Exception e) {
            map.put("errorCode", -1);
            map.put("errorMsg", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }

    // 해당 bno의 보드 조회
    @GetMapping("/board/{bno}")
    public ResponseEntity<Map<String, Object>> findBoardByBno(@PathVariable("bno") int bno) {
        Map<String, Object> map = new HashMap<>();
        try {
            BoardTo boardByBno = boardService.findBoardByBno(bno);
            map.put("boardByBno", boardByBno);
            map.put("errorMsg", "success");
            map.put("errorCode", 0);
            return ResponseEntity.status(HttpStatus.OK).body(map);
        } catch (Exception e) {
            map.put("errorCode", -1);
            map.put("errorMsg", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }

    // 보드 등록
    @PostMapping ("/board")
    public ResponseEntity<Map<String, Object>> registerBoard(@RequestBody BoardTo boardTo) {
        HashMap<String, Object> map = new HashMap<>();
        try {
            map.put("errorMsg","success");
            map.put("errorCode", 0);
            System.out.println("[registerBoardTo] = " + boardTo);
            boardService.registerBoard(boardTo);
            return ResponseEntity.ok(map);
        } catch (Exception e){
            map.put("errorCode", -1);
            map.put("errorMsg", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }

    // 보드 수정
    @PutMapping("/board")
    public ResponseEntity<Map<String, Object>> modify(@RequestBody BoardTo boardTo) {
        Map<String, Object> map = new HashMap<>();
        try {
            map.put("boardTo", boardTo);
            map.put("errorMsg","success");
            map.put("errorCode", 0);
            boardService.modifyBoard(map);
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            map.put("errorCode", -1);
            map.put("errorMsg", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }

    // 보드 숨김(삭제처럼보이도록)
    @PutMapping("/board/conceal/{writer}/{bno}")
    public ResponseEntity<Map<String, Object>> concealBoard(
            @PathVariable("writer") String writer, @PathVariable("bno") int bno) {
        HashMap<String, Object> map = new HashMap<>();
        try {
            map.put("writer", writer);
            map.put("bno", bno);
            map.put("errorMsg","success");
            map.put("errorCode", 0);
            System.out.println(":::::concealMap::::: = " + map);
            boardService.concealBoard(map);
            return ResponseEntity.ok(map);
        } catch (Exception e){
            map.put("errorCode", -1);
            map.put("errorMsg", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }
}
