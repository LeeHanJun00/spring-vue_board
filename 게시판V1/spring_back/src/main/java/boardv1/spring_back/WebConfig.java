package boardv1.spring_back;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**") // CORS 설정 적용할 API URI
            .allowedOrigins("http://localhost:3000") // 허용할 출처
            .allowCredentials(true); // 인증 요청 허용 (쿠키 세션 정보 요청 허용)
  }
}