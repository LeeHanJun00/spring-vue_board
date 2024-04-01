package boardv1.spring_back.repository;

import boardv1.spring_back.domain.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {

  private final EntityManager em;

  public void save(User user) {
    em.persist(user);
  }

  public Optional<User> findById(String userId) {
    List<User> findUser = em.createQuery("select u from User u where u.id= :id", User.class)
            .setParameter("id", userId)
            .getResultList();

    return findUser.stream().findAny();
  }

}
