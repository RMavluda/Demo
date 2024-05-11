package uz.malis.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uz.malis.demo.dto.CheckConsumerResponseDto;
import uz.malis.demo.dto.ConsumerDto;

@RequestMapping("/v1/consumers")
public interface ConsumerApi {

  @GetMapping("/check")
  ResponseEntity<CheckConsumerResponseDto> checkConsumer(
      @RequestParam String personalAccount,
      @RequestParam String coatoCode
      );

  @GetMapping("/{consumerId}")
  ResponseEntity<ConsumerDto> findConsumer(
      @PathVariable Long consumerId,
      @RequestParam String coatoCode
  );

}
