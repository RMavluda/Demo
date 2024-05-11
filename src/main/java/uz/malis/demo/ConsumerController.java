package uz.malis.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import uz.malis.demo.dto.CheckConsumerResponseDto;
import uz.malis.demo.dto.ConsumerDto;

@RestController
@RequiredArgsConstructor
public class ConsumerController implements ConsumerApi {

  private final ConsumerService consumerService;

  @Override
  public ResponseEntity<CheckConsumerResponseDto> checkConsumer(String personalAccount, String coatoCode) {

    var result = consumerService.check(coatoCode, personalAccount);
   return ResponseEntity.ok(result);
  }

  @Override
  public ResponseEntity<ConsumerDto> findConsumer(Long consumerId, String coatoCode)
  {
    var consumerDto = consumerService.findConsumer(coatoCode, consumerId);
    return ResponseEntity.ok(consumerDto);
  }
}
