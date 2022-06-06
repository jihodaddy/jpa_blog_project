package blog.jpablog.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Table(name = "post")
public class Post {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long postId; 

  private String title;

  private String content;

  private String writer;
  // @ManyToOne 
  // @JoinColumn(name = "userId")
  // private User user;

  private int hits; 

  private char delchk; 

  private LocalDateTime createdDate = LocalDateTime.now(); // 생성일

  private LocalDateTime modifiedDate; // 수정일

  @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
private List<Reply> reply;

  // @Builder
  // public Post(String title, String content, String writer, int hits, char delchk) {
  //     this.title = title;
  //     this.content = content;
  //     this.writer = writer;
  //     this.hits = hits;
  //     this.delchk = delchk;
  }

