package uz.malis.demo.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CheckConsumerDto {

  private String api = "it is check api";
  private Boolean status;

}
