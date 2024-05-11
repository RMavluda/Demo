package uz.malis.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import uz.malis.demo.dto.BaseDto;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class TariffResponseDto extends BaseDto {
  private Long price;
}
