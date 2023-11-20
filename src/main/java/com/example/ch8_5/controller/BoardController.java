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

//    // 보드번호로 보드 조회
//    @GetMapping("/board/{bno}")
//    public ModelMap findBoardByBno(@PathVariable int bno) {
//        try {
//            BoardTo boardByBno = boardService.findBoardByBno(bno);
//            modelMap.put("boardByBno", boardByBno);
//            modelMap.put("errorMsg", "success");
//            modelMap.put("errorCode", 0);
//        } catch (Exception e) {
//            modelMap.clear();
//            modelMap.put("errorCode", -1);
//            modelMap.put("errorMsg", e.getMessage());
//        }
//        return modelMap;
//    }

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
}
