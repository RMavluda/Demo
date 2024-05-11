package uz.malis.demo;


import uz.malis.demo.dto.CheckConsumerResponseDto;
import uz.malis.demo.dto.ConsumerDto;

public interface ConsumerService {

  CheckConsumerResponseDto check(String coatoCode, String personalAccount);
  ConsumerDto findConsumer(String coatoCode, Long consumerId);

}
