package boardv1.spring_back.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long user_idx;

  @Column(length = 5)
  private String name;

  @Column(length = 10)
  private String id;

  @Column(length = 10)
  private String pw;

//  @OneToMany(mappedBy = "user")
//  List<Post> posts = new ArrayList<>();

}
