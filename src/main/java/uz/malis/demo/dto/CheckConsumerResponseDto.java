package uz.malis.demo.dto;

import lombok.Data;
import uz.malis.demo.ConsumerStatusEnum;

@Data
public class CheckConsumerResponseDto {

  private String api = "12345";
  private ConsumerStatusEnum statusEnum;

}
