package blog.jpablog.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Post {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; 

  private String title;

  private String content;

  private String writer; 

  private int hits; 

  private char delchk; 

  private LocalDateTime createdDate = LocalDateTime.now(); // 생성일

  private LocalDateTime modifiedDate; // 수정일

  @Builder
  public Post(String title, String content, String writer, int hits, char delchk) {
      this.title = title;
      this.content = content;
      this.writer = writer;
      this.hits = hits;
      this.delchk = delchk;
  }
}
