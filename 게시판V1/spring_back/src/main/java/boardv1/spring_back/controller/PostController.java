package boardv1.spring_back.controller;

import boardv1.spring_back.domain.Post;
import boardv1.spring_back.domain.User;
import boardv1.spring_back.repository.PostRepository;
import boardv1.spring_back.service.PostService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class PostController {

  private final PostService postService;

  @PostMapping("/write")
  public String createPost(@RequestBody Map<String, String> data) {

    String userId = data.get("userId");
    String title = data.get("title");
    String content = data.get("content");

    postService.post(userId, title, content);

    return "ok";
  }

  @GetMapping("/list")
  public List<Post> getPosts() {
    return postService.posts();
  }

  @GetMapping("/post/{board_idx}")
  public Post getPost(@PathVariable("board_idx") String board_idx) {
    return postService.findPost(board_idx);
  }

}
