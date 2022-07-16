package board02.prac.Controller;

import board02.prac.BoardEntity.BoardEntity;
import board02.prac.BoardEntity.BoardForm;
import board02.prac.BoardReposit.BoardReposit;
import board02.prac.BoardService.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoardController {

    private final BoardReposit boardReposit;
    private final BoardService boardService;


    @Autowired
    public BoardController(BoardReposit boardReposit, BoardService boardService) {
        this.boardReposit = boardReposit;
        this.boardService = boardService;
    }

    // 게시판 목록
    @GetMapping("/allboard")
    public String boardall(Model model) {

        List<BoardEntity> boardlist = boardService.findall();

        model.addAttribute("boardlist", boardlist);

        return "Board/allboard";
    }


    // 게시판 작성
    @GetMapping("/writeboard")
    public String boardinput(){
        return "Board/writeboard";}

    @PostMapping("/writeboard")
    public String getinput(BoardForm form){

        BoardEntity boardEntity = form.toEntity();

        boardService.writing(boardEntity);

        return "redirect:/allboard"; }



    // 게시판 해당 작성글

    @GetMapping("/board/{id}")
    public String article(@PathVariable Long id, Model model) {

        BoardEntity byid = boardService.findArticle(id);

        model.addAttribute("FindById", byid);

        return "Board/board";
    }



    // 게시판 글 수정

    @GetMapping("/board/{id}/edit/")
    public String editpage(@PathVariable Long id, Model model) {

        BoardEntity editTarget = boardService.findArticle(id);

        model.addAttribute("editTarget",editTarget);

        return "Board/editboard";
    }

    @PostMapping("/board/{id}/edit/")
    public String editing(BoardForm dto) {

        BoardEntity boardEntity = dto.toEntity();

        boardService.editing(boardEntity);

        return "redirect:/board/" + boardEntity.getId();
    }




















}
