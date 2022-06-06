package blog.jpablog.domain.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "user_table")
public class User {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) 
  private long userId;

  private String userPw;

  private String userName;

  private String userEmail;

  private String role;

  @CreationTimestamp
  private Timestamp createDate;

}
