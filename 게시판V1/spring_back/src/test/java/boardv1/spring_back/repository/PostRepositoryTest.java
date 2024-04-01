package boardv1.spring_back.repository;

import boardv1.spring_back.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostRepositoryTest {

  @Autowired
  private final PostRepository postRepository;

  PostRepositoryTest(PostRepository postRepository) {
    this.postRepository = postRepository;
  }



}