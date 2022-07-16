package board02.prac.BoardEntity;

import javax.persistence.*;

@Entity
@Table
public class BoardEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String contents;

    public BoardEntity(){}

    public BoardEntity(Long ID, String title, String contents) {
        this.id = ID;
        this.title = title;
        this.contents = contents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }


    @Override
    public String toString() {
        return "BoardEntity{" +
                "ID=" + id +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
