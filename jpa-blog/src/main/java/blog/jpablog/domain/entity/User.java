package blog.jpablog.domain.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) 
  private long userid;

  private String password;

  private String username;

  private String email;

  private String role;

  @CreationTimestamp
  private Timestamp createDate;

}
