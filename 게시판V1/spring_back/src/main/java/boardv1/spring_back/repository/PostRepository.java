package boardv1.spring_back.repository;

import boardv1.spring_back.domain.Post;
import boardv1.spring_back.domain.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostRepository {

  private final EntityManager em;

  public void save(Post post) {
    em.persist(post);
  }

  public Post findByIdx(String board_idx) {
   return em.createQuery("select p from Post p where p.board_idx= :board_idx", Post.class)
            .setParameter("board_idx", board_idx)
            .getSingleResult();
  }

  public List<Post> findAll() {
    return em.createQuery("SELECT p FROM Post p", Post.class).getResultList();
  }

}
