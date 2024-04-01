package boardv1.spring_back.service;

import boardv1.spring_back.domain.Post;
import boardv1.spring_back.domain.User;
import boardv1.spring_back.repository.PostRepository;
import boardv1.spring_back.repository.UserRepository;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

  private final PostRepository postRepository;
  private final UserRepository userRepository;

  @Transactional
  public void post(String userId, String title, String content) {
    Optional<User> repositoryFindUser = userRepository.findById(userId);
    User findUser = repositoryFindUser.orElseThrow(() ->
            new NoResultException("[게시판] 아이디 값이 없습니다."));
    Post post = new Post();
    post.setTitle(title);
    post.setContent(content);
    post.setUser(findUser);

    postRepository.save(post);
  }

  public List<Post> posts() {
    return postRepository.findAll();
  }

  public Post findPost(String board_Idx) {
    return postRepository.findByIdx(board_Idx);
  }

}
