package boardv1.spring_back.service;

import boardv1.spring_back.exception.PasswordException;
import boardv1.spring_back.domain.User;
import boardv1.spring_back.repository.UserRepository;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

  private final UserRepository userRepository;

  @Transactional
  public void join(User user) {
    userRepository.save(user);
  }


  public User login(User user) throws NoResultException, PasswordException {
    Optional<User> repositoryFindUser = userRepository.findById(user.getId());

    User findUser = repositoryFindUser.orElseThrow(() ->
            new NoResultException("아이디 값이 없습니다."));

    validatePassword(user.getPw(), findUser.getPw());

    return findUser;
  }

  /*
   * 비밀번호 체크
   */
  private void validatePassword(String userPw, String findUserPw) throws PasswordException {
    if (!userPw.equals(findUserPw)) {
      throw new PasswordException("비밀번호가 일치하지 않습니다.");
    }
  }
}
