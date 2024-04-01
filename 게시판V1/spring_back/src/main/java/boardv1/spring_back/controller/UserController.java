package boardv1.spring_back.controller;

import boardv1.spring_back.exception.PasswordException;
import boardv1.spring_back.domain.User;
import boardv1.spring_back.service.UserService;
import jakarta.persistence.NoResultException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping("/join")
  public String joinUser(@RequestBody User user) {
    userService.join(user);
    return "ok";
  }

  @PostMapping("/login")
  public String loginUser(@RequestBody User user, HttpServletRequest req) throws PasswordException {
    User loginUser = userService.login(user);
    // 세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성
    HttpSession session = req.getSession(true);
    // 세션에 로그인 회원 정보 저장
    session.setAttribute("loginUser", loginUser);

    return "ok";
  }

  @GetMapping("/home")
  public User home(@SessionAttribute(name = "loginUser", required = false) User loginUser) {
    return loginUser;
  }
  


  @ExceptionHandler(NoResultException.class)
  public ErrorResult noResultExHandler(NoResultException e) {
    return new ErrorResult("NO_ID", e.getMessage());
  }

  @ExceptionHandler(PasswordException.class)
  public ErrorResult passwordExHandler(PasswordException e) {
    return new ErrorResult("PASSWORD_ERROR", e.getMessage());
  }

}
