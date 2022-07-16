package board02.prac.BoardService;

import board02.prac.BoardEntity.BoardEntity;
import board02.prac.BoardEntity.BoardForm;
import board02.prac.BoardReposit.BoardReposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private final BoardReposit boardReposit;


    @Autowired
    public BoardService(BoardReposit boardReposit) {
        this.boardReposit = boardReposit;
    }



    // 게시판 글목록

    public List<BoardEntity> findall(){

        return boardReposit.findAll();
    }


    // 게시판 글작성


    public BoardEntity writing(BoardEntity boardEntity) {


        return boardReposit.save(boardEntity);
    }


    // 해당글 조회

    public BoardEntity findArticle(Long id) {

        return boardReposit.findById(id).orElse(null);
    }


    // 게시판 글 수정

    public BoardEntity editing(BoardEntity boardEntity) {

        return boardReposit.save(boardEntity);

    }











}
