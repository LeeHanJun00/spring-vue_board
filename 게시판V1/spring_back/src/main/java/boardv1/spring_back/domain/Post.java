package boardv1.spring_back.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Post {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long board_idx;

  @Column(length = 20)
  private String title;

  @Column(length = 200)
  private String content;

  @ManyToOne
  @JoinColumn(name = "user_idx")
  private User user;


}
