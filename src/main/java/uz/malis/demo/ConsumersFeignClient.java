package uz.malis.demo;

import java.util.Map;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import uz.malis.demo.dto.CheckConsumerDto;
import uz.malis.demo.dto.ConsumerResponseDtoMAIN;


@FeignClient(name = "consumer-feign-client", url = "http://192.168.25.57:7020")
public interface ConsumersFeignClient {

  @GetMapping("/v1/consumers/check-consumer-by-personal-account")
  CheckConsumerDto checkConsumer(
      @RequestParam String personalAccount,
      @RequestParam String coatoCode,
      @RequestHeader Map<String, String> headers
  );

  @GetMapping("/v1/consumers/{consumerId}")
  ConsumerResponseDtoMAIN findConsumer(
      @PathVariable Long consumerId,
      @RequestParam String coatoCode,
      @RequestHeader Map<String, String> headers
  );

}