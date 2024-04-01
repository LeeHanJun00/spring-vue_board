package boardv1.spring_back.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResult {

  private String code;
  private String message;

}
