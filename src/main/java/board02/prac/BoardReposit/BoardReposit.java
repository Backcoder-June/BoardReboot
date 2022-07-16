package board02.prac.BoardReposit;

import board02.prac.BoardEntity.BoardEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface BoardReposit extends CrudRepository<BoardEntity, Long> {

    @Override
    ArrayList<BoardEntity> findAll();
}
